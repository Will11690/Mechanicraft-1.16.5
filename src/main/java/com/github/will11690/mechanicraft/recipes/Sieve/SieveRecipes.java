package com.github.will11690.mechanicraft.recipes.Sieve;

import javax.annotation.Nullable;

import com.github.will11690.mechanicraft.init.ModBlocks;
import com.github.will11690.mechanicraft.init.ModRecipes;
import com.github.will11690.mechanicraft.util.Reference;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.crafting.ShapedRecipe;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.JSONUtils;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.registries.ForgeRegistryEntry;

public class SieveRecipes implements IRecipe<IInventory> {
   
	public static final Serializer SERIALIZER = new Serializer();
	
	private final ResourceLocation id;
    private final ItemStack output;
    private final ItemStack secondaryOutput;
    private final Ingredient input1;
    private final Ingredient input2;
    private int secondaryChanceMin = 1;
    private final int secondaryChanceMax;
    private boolean secondaryOutputChance;
    
    int randomWithRange(int min, int max) {
    	
    	min = secondaryChanceMin;
    	
    	if(secondaryChanceMax < 2) {
    		
    		max = 2;
    		
    	} else {
    	
    		max = secondaryChanceMax;
    	}
    	
    	int range = (max - min) + 1;
    	return (int)(Math.random() * range) + min;
    	
    }
    
    public void secondaryChance() {
    	
    	int min = secondaryChanceMin;
    	int max;
    	
    	if(secondaryChanceMax < 2) {
    		
    		max = 2;
    		
    	}
    	
    	if(secondaryChanceMax > 100) {
    		
    		max = 100;
    		
    	} else {
    	
    		max = secondaryChanceMax;
    	}
    	
    	int rand = randomWithRange(min, max);
    	
    	if(rand == 1) {
    		
    		secondaryOutputChance = true;
    		
    	} else secondaryOutputChance = false;
    	
    }
	
	public SieveRecipes(ResourceLocation id, Ingredient input1, Ingredient input2, ItemStack output, ItemStack secondaryOutput, int secondaryChanceMax) {
		
		this.id = id;
		this.input1 = input1;
		this.input2 = input2;
		this.output = output;
		this.secondaryOutput = secondaryOutput;
		this.secondaryChanceMax = secondaryChanceMax;
		
	}
	
	@Override
	public boolean matches(IInventory inv, World world) {
			
		if(this.input1.test(inv.getItem(0))) {
			
            return this.input2.test(inv.getItem(1));
            
        }
		
		if(this.input2.test(inv.getItem(1))) {
			
            return this.input1.test(inv.getItem(0));
            
        }

        return false;
    }

	@Override
	public ItemStack assemble(IInventory inv) {
		
		secondaryChance();
		
		return this.output.copy();
		
	}

	public ItemStack assembleSecondary(IInventory inv) {
		
		if(secondaryOutputChance == true) {
			
			return this.secondaryOutput.copy();
		}
		
		else return ItemStack.EMPTY;
	}

	@Override
	public ItemStack getResultItem() {
		
		return this.output;
		
	}

	public ItemStack getSecondaryResultItem() {
		
		if(secondaryOutputChance == true) {
			
			return this.secondaryOutput;
			
		} else return ItemStack.EMPTY;
		
	}
	
	public ItemStack getSecondaryResultJEI() {
			
			return this.secondaryOutput;
		
	}
	
	public Ingredient getInput1() {
        return this.input1;
    }
	
	public Ingredient getInput2() {
        return this.input2;
    }
	
	@Override
	public NonNullList<Ingredient> getIngredients() {
	      NonNullList<Ingredient> nonnulllist = NonNullList.create();
	      nonnulllist.add(this.input1);
	      nonnulllist.add(this.input2);
	      return nonnulllist;
	   }
	
	@Override
	public ResourceLocation getId() {
		
		return this.id;
		
	}
	
	@Override
	public boolean canCraftInDimensions(int width, int height) {
		
		return true;
		
	}

	@Override
	public IRecipeSerializer<?> getSerializer() {
		
		return SieveRecipes.SERIALIZER;
		
	}

	@Override
	public IRecipeType<?> getType() {
		
		return ModRecipes.SIEVE_RECIPES;
		
	}
	
	public ItemStack makeIcon() {
		
		return new ItemStack(ModBlocks.T1_POWERED_SIEVE.get());
		
	}

    public static class Serializer extends ForgeRegistryEntry<IRecipeSerializer<?>> implements IRecipeSerializer<SieveRecipes> {
        
    	Serializer() {
    		
    		this.setRegistryName(Reference.MOD_ID, "sieve_recipes");
    	}
    	
    	@Override
        public SieveRecipes fromJson(ResourceLocation id, JsonObject json) {
    		
    		final JsonElement input1El = JSONUtils.isArrayNode(json, "input1") ? JSONUtils.getAsJsonArray(json, "input1") : JSONUtils.getAsJsonObject(json, "input1");
    		final JsonElement input2El = JSONUtils.isArrayNode(json, "input2") ? JSONUtils.getAsJsonArray(json, "input2") : JSONUtils.getAsJsonObject(json, "input2");
			final Ingredient input1 = Ingredient.fromJson(input1El);
			final Ingredient input2 = Ingredient.fromJson(input2El);
    		
    		final ItemStack output = ShapedRecipe.itemFromJson(JSONUtils.getAsJsonObject(json, "output"));
    		final ItemStack secondaryOutput = ShapedRecipe.itemFromJson(JSONUtils.getAsJsonObject(json, "secondaryOutput"));
    		final int secondaryChanceMax = JSONUtils.getAsInt(json.get("secondaryOutput").getAsJsonObject(), "weight", 0);
    		
    		return new SieveRecipes(id, input1, input2, output, secondaryOutput, secondaryChanceMax);
        }

        @Nullable
        @Override
        public SieveRecipes fromNetwork(ResourceLocation recipeId, PacketBuffer buffer) {
        	
        	final Ingredient input1 = Ingredient.fromNetwork(buffer);
        	final Ingredient input2 = Ingredient.fromNetwork(buffer);
        	
        	final ItemStack output = buffer.readItem();
        	final ItemStack secondaryOutput = buffer.readItem();
        	final int secondaryChanceMax = buffer.readInt();
        	
            return new SieveRecipes(recipeId, input1, input2, output, secondaryOutput, secondaryChanceMax);
            
        }

        @Override
        public void toNetwork(PacketBuffer buffer, SieveRecipes recipe) {
        	
        	recipe.input1.toNetwork(buffer);
        	recipe.input2.toNetwork(buffer);
            
            buffer.writeItem(recipe.output);
            buffer.writeItem(recipe.secondaryOutput);
            buffer.writeInt(recipe.secondaryChanceMax);
            
        }
    }
    
	@Override
	public boolean isSpecial() {
    	return true;
	}
}
package com.github.will11690.mechanicraft.recipes.Crusher;

import javax.annotation.Nullable;

import com.github.will11690.mechanicraft.init.ModBlocks;
import com.github.will11690.mechanicraft.init.ModRecipes;
import com.github.will11690.mechanicraft.util.Reference;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
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

public class CrusherRecipes implements IRecipe<IInventory> {
	   
	//TODO TEST CHANGES
	
	public static final Serializer SERIALIZER = new Serializer();
	
	private final ResourceLocation id;
    private final ItemStack output;
    private final ItemStack secondaryOutput;
    private final Ingredient input;
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
	
	public CrusherRecipes(ResourceLocation id, Ingredient input, ItemStack output, ItemStack secondaryOutput, int secondaryChanceMax) {
		
		this.id = id;
		this.input = input;
		this.output = output;
		this.secondaryOutput = secondaryOutput;
		this.secondaryChanceMax = secondaryChanceMax;
		
	}
	
	@Override
	public boolean matches(IInventory inv, World world) {

        return this.input.test(inv.getItem(0));
    }

	@Override
	public ItemStack assemble(IInventory inv) {
		
		secondaryChance();
		
		return this.output.copy();
		
	}

	public ItemStack assembleSecondary(IInventory inv) {
		
		if(secondaryOutputChance == true) {
			
			if(secondaryOutput.getItem().equals(Items.AIR)) {
				
				return ItemStack.EMPTY;
				
			} else return this.secondaryOutput.copy();
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
	
	public Ingredient getInput() {
        return this.input;
    }
	
	@Override
	public NonNullList<Ingredient> getIngredients() {
	      NonNullList<Ingredient> nonnulllist = NonNullList.create();
	      nonnulllist.add(this.input);
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
		
		return CrusherRecipes.SERIALIZER;
		
	}

	@Override
	public IRecipeType<?> getType() {
		
		return ModRecipes.CRUSHER_RECIPES;
		
	}
	
	public ItemStack makeIcon() {
		
		return new ItemStack(ModBlocks.T1_CRUSHER.get());
		
	}

    public static class Serializer extends ForgeRegistryEntry<IRecipeSerializer<?>> implements IRecipeSerializer<CrusherRecipes> {
        
    	Serializer() {
    		
    		this.setRegistryName(Reference.MOD_ID, "crusher_recipes");
    	}
    	
    	@Override
        public CrusherRecipes fromJson(ResourceLocation id, JsonObject json) {
    		
    		final JsonElement inputEl = JSONUtils.isArrayNode(json, "input") ? JSONUtils.getAsJsonArray(json, "input") : JSONUtils.getAsJsonObject(json, "input");
			final Ingredient input = Ingredient.fromJson(inputEl);
    		
    		final ItemStack output = ShapedRecipe.itemFromJson(JSONUtils.getAsJsonObject(json, "output"));
    		final ItemStack secondaryOutput = ShapedRecipe.itemFromJson(JSONUtils.getAsJsonObject(json, "secondaryOutput"));
    		final int secondaryChanceMax = JSONUtils.getAsInt(json.get("secondaryOutput").getAsJsonObject(), "weight", 0);
    		
    		return new CrusherRecipes(id, input, output, secondaryOutput, secondaryChanceMax);
        }

        @Nullable
        @Override
        public CrusherRecipes fromNetwork(ResourceLocation recipeId, PacketBuffer buffer) {
        	
        	final Ingredient input = Ingredient.fromNetwork(buffer);
        	
        	final ItemStack output = buffer.readItem();
        	final ItemStack secondaryOutput = buffer.readItem();
        	final int secondaryChanceMax = buffer.readInt();
        	
            return new CrusherRecipes(recipeId, input, output, secondaryOutput, secondaryChanceMax);
            
        }

        @Override
        public void toNetwork(PacketBuffer buffer, CrusherRecipes recipe) {
        	
        	recipe.input.toNetwork(buffer);
            
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
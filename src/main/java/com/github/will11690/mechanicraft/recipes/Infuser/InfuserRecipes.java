package com.github.will11690.mechanicraft.recipes.Infuser;

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

import javax.annotation.Nullable;

public class InfuserRecipes implements IRecipe<IInventory> {
   
	public static final Serializer SERIALIZER = new Serializer();
	
	private final ResourceLocation id;
    private final ItemStack output;
    private final Ingredient input1;
    private final Ingredient input2;
	
	public InfuserRecipes(ResourceLocation id, Ingredient input1, Ingredient input2, ItemStack output) {
		
		this.id = id;
		this.input1 = input1;
		this.input2 = input2;
		this.output = output;
		
	}
	
	@Override
	public boolean matches(IInventory inv, World world) {
			
		if(this.input1.test(inv.getItem(0))) {
			
            return this.input2.test(inv.getItem(1));
            
        }
		
		if(this.input2.test(inv.getItem(0))) {
		
			return this.input1.test(inv.getItem(1));
        
		}

        return false;
    }

	@Override
	public ItemStack assemble(IInventory inv) {
		
		return this.output.copy();
		
	}

	@Override
	public ItemStack getResultItem() {
		
		return this.output;
		
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
		
		return InfuserRecipes.SERIALIZER;
		
	}

	@Override
	public IRecipeType<?> getType() {
		
		return ModRecipes.INFUSER_RECIPES;
		
	}
	
	public ItemStack makeIcon() {

		return new ItemStack(ModBlocks.BASIC_METALLIC_INFUSER.get());
		
	}

    public static class Serializer extends ForgeRegistryEntry<IRecipeSerializer<?>> implements IRecipeSerializer<InfuserRecipes> {
        
    	Serializer() {
    		
    		this.setRegistryName(Reference.MOD_ID, "infuser_recipes");
    	}
    	
    	@Override
        public InfuserRecipes fromJson(ResourceLocation id, JsonObject json) {
    		
    		final JsonElement input1El = JSONUtils.isArrayNode(json, "input1") ? JSONUtils.getAsJsonArray(json, "input1") : JSONUtils.getAsJsonObject(json, "input1");
    		final JsonElement input2El = JSONUtils.isArrayNode(json, "input2") ? JSONUtils.getAsJsonArray(json, "input2") : JSONUtils.getAsJsonObject(json, "input2");
			final Ingredient input1 = Ingredient.fromJson(input1El);
			final Ingredient input2 = Ingredient.fromJson(input2El);
    		
    		final ItemStack output = ShapedRecipe.itemFromJson(JSONUtils.getAsJsonObject(json, "output"));
    		
    		return new InfuserRecipes(id, input1, input2, output);
        }

        @Nullable
        @Override
        public InfuserRecipes fromNetwork(ResourceLocation recipeId, PacketBuffer buffer) {
        	
        	final Ingredient input1 = Ingredient.fromNetwork(buffer);
        	final Ingredient input2 = Ingredient.fromNetwork(buffer);
        	
        	final ItemStack output = buffer.readItem();
        	
            return new InfuserRecipes(recipeId, input1, input2, output);
            
        }

        @Override
        public void toNetwork(PacketBuffer buffer, InfuserRecipes recipe) {
        	
        	recipe.input1.toNetwork(buffer);
        	recipe.input2.toNetwork(buffer);
            
            buffer.writeItem(recipe.output);
            
        }
    }
    
	@Override
	public boolean isSpecial() {
    	return true;
	}
}
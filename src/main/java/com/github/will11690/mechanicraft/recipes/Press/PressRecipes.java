package com.github.will11690.mechanicraft.recipes.Press;

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

public class PressRecipes implements IRecipe<IInventory> {
	   
	public static final Serializer SERIALIZER = new Serializer();
	
	private final ResourceLocation id;
    private final ItemStack output;
    private final Ingredient input1;
    private final Ingredient input2;
    private final Ingredient input3;
    private final Ingredient input4;
    private final Ingredient input5;
    private final Ingredient input6;
    private final Ingredient input7;
    private final Ingredient input8;
    private final Ingredient input9;
	
	public PressRecipes(ResourceLocation id, Ingredient input1, Ingredient input2, Ingredient input3, Ingredient input4, Ingredient input5, Ingredient input6, Ingredient input7, Ingredient input8, Ingredient input9, ItemStack output) {
		
		this.id = id;
		this.input1 = input1;
		this.input2 = input2;
		this.input3 = input3;
		this.input4 = input4;
		this.input5 = input5;
		this.input6 = input6;
		this.input7 = input7;
		this.input8 = input8;
		this.input9 = input9;
		this.output = output;
		
	}
	
	@Override
	public boolean matches(IInventory inv, World world) {
			
		if(this.input9.test(inv.getItem(8))) {
			
            return this.input1.test(inv.getItem(0)) && this.input2.test(inv.getItem(1)) && this.input3.test(inv.getItem(2)) && this.input4.test(inv.getItem(3)) &&
            		this.input5.test(inv.getItem(4)) && this.input6.test(inv.getItem(5)) && this.input7.test(inv.getItem(6)) && this.input8.test(inv.getItem(7));
            
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
	
	public Ingredient getInput3() {
		
        return this.input3;
    }
	
	public Ingredient getInput4() {
		
        return this.input4;
    }
	
	public Ingredient getInput5() {
		
        return this.input5;
    }
	
	public Ingredient getInput6() {
		
        return this.input6;
    }
	
	public Ingredient getInput7() {
		
        return this.input7;
    }
	
	public Ingredient getInput8() {
		
        return this.input8;
    }
	
	public Ingredient getInput9() {
		
        return this.input9;
    }
	
	@Override
	public NonNullList<Ingredient> getIngredients() {
	      NonNullList<Ingredient> nonnulllist = NonNullList.create();
	      nonnulllist.add(this.input1);
	      nonnulllist.add(this.input2);
	      nonnulllist.add(this.input3);
	      nonnulllist.add(this.input4);
	      nonnulllist.add(this.input5);
	      nonnulllist.add(this.input6);
	      nonnulllist.add(this.input7);
	      nonnulllist.add(this.input8);
	      nonnulllist.add(this.input9);
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
		
		return PressRecipes.SERIALIZER;
		
	}

	@Override
	public IRecipeType<?> getType() {
		
		return ModRecipes.PRESS_RECIPES;
		
	}
	
	public ItemStack makeIcon() {

		return new ItemStack(ModBlocks.T1_PRESS.get());
		
	}

    public static class Serializer extends ForgeRegistryEntry<IRecipeSerializer<?>> implements IRecipeSerializer<PressRecipes> {
        
    	Serializer() {
    		
    		this.setRegistryName(Reference.MOD_ID, "press_recipes");
    	}
    	
    	@Override
        public PressRecipes fromJson(ResourceLocation id, JsonObject json) {
    		
    		final JsonElement input1El = JSONUtils.isArrayNode(json, "input1") ? JSONUtils.getAsJsonArray(json, "input1") : JSONUtils.getAsJsonObject(json, "input1");
    		final JsonElement input2El = JSONUtils.isArrayNode(json, "input2") ? JSONUtils.getAsJsonArray(json, "input2") : JSONUtils.getAsJsonObject(json, "input2");
    		final JsonElement input3El = JSONUtils.isArrayNode(json, "input3") ? JSONUtils.getAsJsonArray(json, "input3") : JSONUtils.getAsJsonObject(json, "input3");
    		final JsonElement input4El = JSONUtils.isArrayNode(json, "input4") ? JSONUtils.getAsJsonArray(json, "input4") : JSONUtils.getAsJsonObject(json, "input4");
    		final JsonElement input5El = JSONUtils.isArrayNode(json, "input5") ? JSONUtils.getAsJsonArray(json, "input5") : JSONUtils.getAsJsonObject(json, "input5");
    		final JsonElement input6El = JSONUtils.isArrayNode(json, "input6") ? JSONUtils.getAsJsonArray(json, "input6") : JSONUtils.getAsJsonObject(json, "input6");
    		final JsonElement input7El = JSONUtils.isArrayNode(json, "input7") ? JSONUtils.getAsJsonArray(json, "input7") : JSONUtils.getAsJsonObject(json, "input7");
    		final JsonElement input8El = JSONUtils.isArrayNode(json, "input8") ? JSONUtils.getAsJsonArray(json, "input8") : JSONUtils.getAsJsonObject(json, "input8");
    		final JsonElement input9El = JSONUtils.isArrayNode(json, "input9") ? JSONUtils.getAsJsonArray(json, "input9") : JSONUtils.getAsJsonObject(json, "input9");
			final Ingredient input1 = Ingredient.fromJson(input1El);
			final Ingredient input2 = Ingredient.fromJson(input2El);
			final Ingredient input3 = Ingredient.fromJson(input3El);
			final Ingredient input4 = Ingredient.fromJson(input4El);
			final Ingredient input5 = Ingredient.fromJson(input5El);
			final Ingredient input6 = Ingredient.fromJson(input6El);
			final Ingredient input7 = Ingredient.fromJson(input7El);
			final Ingredient input8 = Ingredient.fromJson(input8El);
			final Ingredient input9 = Ingredient.fromJson(input9El);
    		
    		final ItemStack output = ShapedRecipe.itemFromJson(JSONUtils.getAsJsonObject(json, "output"));
    		
    		return new PressRecipes(id, input1, input2, input3, input4, input5, input6, input7, input8, input9, output);
        }

        @Nullable
        @Override
        public PressRecipes fromNetwork(ResourceLocation recipeId, PacketBuffer buffer) {
        	
        	final Ingredient input1 = Ingredient.fromNetwork(buffer);
        	final Ingredient input2 = Ingredient.fromNetwork(buffer);
        	final Ingredient input3 = Ingredient.fromNetwork(buffer);
        	final Ingredient input4 = Ingredient.fromNetwork(buffer);
        	final Ingredient input5 = Ingredient.fromNetwork(buffer);
        	final Ingredient input6 = Ingredient.fromNetwork(buffer);
        	final Ingredient input7 = Ingredient.fromNetwork(buffer);
        	final Ingredient input8 = Ingredient.fromNetwork(buffer);
        	final Ingredient input9 = Ingredient.fromNetwork(buffer);
        	
        	final ItemStack output = buffer.readItem();
        	
            return new PressRecipes(recipeId, input1, input2, input3, input4, input5, input6, input7, input8, input9, output);
            
        }

        @Override
        public void toNetwork(PacketBuffer buffer, PressRecipes recipe) {
        	
        	recipe.input1.toNetwork(buffer);
        	recipe.input2.toNetwork(buffer);
        	recipe.input3.toNetwork(buffer);
        	recipe.input4.toNetwork(buffer);
        	recipe.input5.toNetwork(buffer);
        	recipe.input6.toNetwork(buffer);
        	recipe.input7.toNetwork(buffer);
        	recipe.input8.toNetwork(buffer);
        	recipe.input9.toNetwork(buffer);
            
            buffer.writeItem(recipe.output);
        }
    }
    
	@Override
	public boolean isSpecial() {
    	return true;
	}
}
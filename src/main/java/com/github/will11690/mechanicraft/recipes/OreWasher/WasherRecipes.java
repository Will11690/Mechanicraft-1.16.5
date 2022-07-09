package com.github.will11690.mechanicraft.recipes.OreWasher;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.annotation.Nullable;

import com.github.will11690.mechanicraft.fluid.MechanicraftFluidTank;
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
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.JSONUtils;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.ForgeRegistryEntry;

public class WasherRecipes implements IRecipe<IInventory> {
   
	public static final Serializer SERIALIZER = new Serializer();
	
	private final ResourceLocation id;
    private final FluidStack outputFluid;
    private final Ingredient inputStack;
    private final FluidStack inputFluid;
	
	public WasherRecipes(ResourceLocation id, Ingredient inputStack, FluidStack inputFluid, FluidStack outputFluid) {
		
		this.id = id;
		this.inputStack = inputStack;
		this.inputFluid = inputFluid;
		this.outputFluid = outputFluid;
		
	}
	
	@Override
	public boolean matches(IInventory inv, World world) {
		
		if(this.inputStack.test(inv.getItem(0))) {
			
            return true;
        }

        return false;
    }
	
	public FluidStack assembleFluid(MechanicraftFluidTank tank, ItemStackHandler stackHandler) {
		
		if(tank.getFluid().equals(inputFluid) && inputStack.test(stackHandler.getStackInSlot(0))) {
		
			return this.outputFluid.copy();
		}
		
		return FluidStack.EMPTY;
	}

	public FluidStack getResultFluid() {
		
		return this.outputFluid;
		
	}
	
	public Ingredient getInputStack() {
        return this.inputStack;
    }
	
	public FluidStack getInputFluid() {
        return this.inputFluid;
    }
	
	@Override
	public NonNullList<Ingredient> getIngredients() {
	      NonNullList<Ingredient> nonnulllist = NonNullList.create();
	      nonnulllist.add(this.inputStack);
	      return nonnulllist;
	   }
	
	public Map<FluidStack, Integer> getInputFluids() {
		
		Map<FluidStack, Integer> inputFluids = new LinkedHashMap<>();
		
		inputFluids.put(inputFluid, inputFluid.getAmount());
		
		return inputFluids;
		
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
		
		return WasherRecipes.SERIALIZER;
		
	}

	@Override
	public IRecipeType<?> getType() {
		
		return ModRecipes.WASHER_RECIPES;
		
	}
	
	public ItemStack makeIcon() {

		return new ItemStack(ModBlocks.T1_ORE_WASHER.get());
		
	}

    public static class Serializer extends ForgeRegistryEntry<IRecipeSerializer<?>> implements IRecipeSerializer<WasherRecipes> {
        
    	Serializer() {
    		
    		this.setRegistryName(Reference.MOD_ID, "washer_recipes");
    	}
    	
    	@Override
        public WasherRecipes fromJson(ResourceLocation id, JsonObject json) {
    		
    		final JsonElement inputStackEl = JSONUtils.isArrayNode(json, "inputStack") ? JSONUtils.getAsJsonArray(json, "inputStack") : JSONUtils.getAsJsonObject(json, "inputStack");
    		
    		ResourceLocation inputFluidResourceLocation = ResourceLocation.of(JSONUtils.getAsString(json.get("inputFluid").getAsJsonObject(), "fluid", "minecraft:empty"), ':');
            int inputFluidAmount = JSONUtils.getAsInt(json.get("inputFluid").getAsJsonObject(), "amount", 0);
            
            ResourceLocation outputFluidResourceLocation = ResourceLocation.of(JSONUtils.getAsString(json.get("outputFluid").getAsJsonObject(), "fluid", "minecraft:empty"), ':');
            int outputFluidAmount = JSONUtils.getAsInt(json.get("outputFluid").getAsJsonObject(), "amount", 0);
    		
			final Ingredient inputStack = Ingredient.fromJson(inputStackEl);
			final FluidStack inputFluid = new FluidStack(ForgeRegistries.FLUIDS.getValue(inputFluidResourceLocation), inputFluidAmount);
			final FluidStack outputFluid = new FluidStack(ForgeRegistries.FLUIDS.getValue(outputFluidResourceLocation), outputFluidAmount);
    		
    		return new WasherRecipes(id, inputStack, inputFluid, outputFluid);
        }

        @Nullable
        @Override
        public WasherRecipes fromNetwork(ResourceLocation recipeId, PacketBuffer buffer) {
        	
        	final Ingredient inputStack = Ingredient.fromNetwork(buffer);
        	final FluidStack inputFluid = buffer.readFluidStack();
        	
        	final FluidStack outputFluid = buffer.readFluidStack();
        	
            return new WasherRecipes(recipeId, inputStack, inputFluid, outputFluid);
            
        }

        @Override
        public void toNetwork(PacketBuffer buffer, WasherRecipes recipe) {
        	
        	recipe.inputStack.toNetwork(buffer);
        	buffer.writeFluidStack(recipe.getInputFluid());
            
        	buffer.writeFluidStack(recipe.outputFluid);
            
        }
    }
    
	@Override
	public boolean isSpecial() {
    	return true;
	}

    /**
	 * EXISTS ONLY TO REMOVE ERRORS
	 * MACHINE HAS NO ITEMSTACK OUTPUT
	 * DO NOT USE
	 * ALWAYS RETURNS ItemStack.EMPTY
	 */
	@Override
	public ItemStack assemble(IInventory inv){return ItemStack.EMPTY;}

	/**
	 * EXISTS ONLY TO REMOVE ERRORS
	 * MACHINE HAS NO ITEMSTACK OUTPUT
	 * DO NOT USE
	 * ALWAYS RETURNS ItemStack.EMPTY
	 */
	@Override
	public ItemStack getResultItem(){return ItemStack.EMPTY;}
}
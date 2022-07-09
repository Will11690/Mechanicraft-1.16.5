package com.github.will11690.mechanicraft.recipes.SlurryProcessor;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.annotation.Nullable;

import com.github.will11690.mechanicraft.init.ModBlocks;
import com.github.will11690.mechanicraft.init.ModRecipes;
import com.github.will11690.mechanicraft.util.Reference;
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
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.ForgeRegistryEntry;

public class SlurryRecipes implements IRecipe<IInventory> {
   
	public static final Serializer SERIALIZER = new Serializer();
	
	private final ResourceLocation id;
    private final ItemStack outputStack;
    private final FluidStack outputFluid;
    private final FluidStack inputFluid1;
    private final FluidStack inputFluid2;
	
	public SlurryRecipes(ResourceLocation id, FluidStack inputFluid1, FluidStack inputFluid2, ItemStack outputStack, FluidStack outputFluid) {
		
		this.id = id;
		this.inputFluid1 = inputFluid1;
		this.inputFluid2 = inputFluid2;
		this.outputStack = outputStack;
		this.outputFluid = outputFluid;
		
	}
	
	public boolean matchesFluid(FluidStack input1, FluidStack input2) {

		if(input1.containsFluid(inputFluid1) && input2.containsFluid(inputFluid2)) {
			
			return true;
			
		} else return false;
    }
	
	@Override
	public boolean matches(IInventory inv, World world) {

		ItemStack fluidBucket1 = new ItemStack(inputFluid1.getFluid().getBucket());
		ItemStack fluidBucket2 = new ItemStack(inputFluid2.getFluid().getBucket());
		
		if(Ingredient.of(fluidBucket1).test(inv.getItem(0))) {
		
			return Ingredient.of(fluidBucket2).test(inv.getItem(1));
		} else return false;
    }

	
	public ItemStack assembleStack(FluidStack input1, FluidStack input2) {
		
		if(matchesFluid(input1, input2)) {
			
			return this.outputStack.copy();
				
		} else
			
		return ItemStack.EMPTY;
	}
	
	public FluidStack assembleFluid(FluidStack input1, FluidStack input2) {
		
		if(matchesFluid(input1, input2)) {
			
			return this.outputFluid.copy();
				
		} else
			
		return FluidStack.EMPTY;
	}

	@Override
	public ItemStack getResultItem() {
		
		return this.outputStack;
		
	}

	public FluidStack getResultFluid() {
		
		return this.outputFluid;
		
	}

	public FluidStack getResultFluidWithInputs(FluidStack input1, FluidStack input2) {
		
		if(input1.containsFluid(inputFluid1) && input2.containsFluid(inputFluid2))
			return this.outputFluid;
		
		return FluidStack.EMPTY;
		
	}
	
	public FluidStack getInputFluid1() {
        return this.inputFluid1;
    }
	
	public FluidStack getInputFluid2() {
        return this.inputFluid2;
    }
	
	public Map<FluidStack, Integer> getInputFluids() {
		
		Map<FluidStack, Integer> inputFluids = new LinkedHashMap<>();
		
		inputFluids.put(inputFluid1, inputFluid2.getAmount());
		inputFluids.put(inputFluid2, inputFluid2.getAmount());
		
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
		
		return SlurryRecipes.SERIALIZER;
		
	}

	@Override
	public IRecipeType<?> getType() {
		
		return ModRecipes.SLURRY_RECIPES;
		
	}
	
	public ItemStack makeIcon() {

		return new ItemStack(ModBlocks.T1_SLURRY_PROCESSOR.get());
		
	}

    public static class Serializer extends ForgeRegistryEntry<IRecipeSerializer<?>> implements IRecipeSerializer<SlurryRecipes> {
        
    	Serializer() {
    		
    		this.setRegistryName(Reference.MOD_ID, "slurry_recipes");
    	}
    	
    	@Override
        public SlurryRecipes fromJson(ResourceLocation id, JsonObject json) {
    		
    		ResourceLocation inputFluid1ResourceLocation = ResourceLocation.of(JSONUtils.getAsString(json.get("inputFluid1").getAsJsonObject(), "fluid", "minecraft:empty"), ':');
            int inputFluid1Amount = JSONUtils.getAsInt(json.get("inputFluid1").getAsJsonObject(), "amount", 0);
    		
    		ResourceLocation inputFluid2ResourceLocation = ResourceLocation.of(JSONUtils.getAsString(json.get("inputFluid2").getAsJsonObject(), "fluid", "minecraft:empty"), ':');
            int inputFluid2Amount = JSONUtils.getAsInt(json.get("inputFluid2").getAsJsonObject(), "amount", 0);
            
            ResourceLocation outputFluidResourceLocation = ResourceLocation.of(JSONUtils.getAsString(json.get("outputFluid").getAsJsonObject(), "fluid", "minecraft:empty"), ':');
            int outputFluidAmount = JSONUtils.getAsInt(json.get("outputFluid").getAsJsonObject(), "amount", 0);
    		
			final FluidStack inputFluid1 = new FluidStack(ForgeRegistries.FLUIDS.getValue(inputFluid1ResourceLocation), inputFluid1Amount);
			final FluidStack inputFluid2 = new FluidStack(ForgeRegistries.FLUIDS.getValue(inputFluid2ResourceLocation), inputFluid2Amount);
			
			final ItemStack outputStack = ShapedRecipe.itemFromJson(JSONUtils.getAsJsonObject(json, "outputStack"));
			final FluidStack outputFluid = new FluidStack(ForgeRegistries.FLUIDS.getValue(outputFluidResourceLocation), outputFluidAmount);
    		
    		return new SlurryRecipes(id, inputFluid1, inputFluid2, outputStack, outputFluid);
        }

        @Nullable
        @Override
        public SlurryRecipes fromNetwork(ResourceLocation recipeId, PacketBuffer buffer) {
        	
        	final FluidStack inputFluid1 = buffer.readFluidStack();
        	final FluidStack inputFluid2 = buffer.readFluidStack();
        	
        	final ItemStack outputStack = buffer.readItem();
        	final FluidStack outputFluid = buffer.readFluidStack();
        	
            return new SlurryRecipes(recipeId, inputFluid1, inputFluid2, outputStack, outputFluid);
            
        }

        @Override
        public void toNetwork(PacketBuffer buffer, SlurryRecipes recipe) {
        	
        	buffer.writeFluidStack(recipe.getInputFluid1());
        	buffer.writeFluidStack(recipe.getInputFluid2());
            
        	buffer.writeItem(recipe.outputStack);
        	buffer.writeFluidStack(recipe.outputFluid);
            
        }
    }

    /**
	 * EXISTS ONLY TO REMOVE ERRORS
	 * MACHINE HAS NO ITEMSTACK OUTPUT
	 * DO NOT USE
	 * ALWAYS RETURNS ItemStack.EMPTY
	 */
	@Override
	public ItemStack assemble(IInventory inv){return ItemStack.EMPTY;}

	@Override
	public boolean isSpecial() {
    	return true;
	}
}
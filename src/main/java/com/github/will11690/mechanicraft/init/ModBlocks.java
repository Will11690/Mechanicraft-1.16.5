package com.github.will11690.mechanicraft.init;

import java.util.function.Supplier;

import com.github.will11690.mechanicraft.MechaniCraftMain;
import com.github.will11690.mechanicraft.blocks.chute.energychute.tier1.T1EnergyChute;
import com.github.will11690.mechanicraft.blocks.chute.fluidchute.tier1.T1FluidChute;
import com.github.will11690.mechanicraft.blocks.chute.itemchute.tier1.T1ItemChute;
import com.github.will11690.mechanicraft.blocks.fluidtank.advfluidtank.AdvFluidTank;
import com.github.will11690.mechanicraft.blocks.fluidtank.basicfluidtank.BasicFluidTank;
import com.github.will11690.mechanicraft.blocks.fluidtank.elitefluidtank.EliteFluidTank;
import com.github.will11690.mechanicraft.blocks.fluidtank.superiorfluidtank.SuperiorFluidTank;
import com.github.will11690.mechanicraft.blocks.fluidtank.supremefluidtank.SupremeFluidTank;
import com.github.will11690.mechanicraft.blocks.fluidtank.ultimatefluidtank.UltimateFluidTank;
import com.github.will11690.mechanicraft.blocks.machines.adv.advcgen.AdvancedCoalGenerator;
import com.github.will11690.mechanicraft.blocks.machines.adv.advfurnace.AdvancedFurnace;
import com.github.will11690.mechanicraft.blocks.machines.basic.basiccgen.BasicCoalGenerator;
import com.github.will11690.mechanicraft.blocks.machines.basic.basicfurnace.BasicFurnace;
import com.github.will11690.mechanicraft.blocks.machines.basic.basicinfuser.BasicMetallicInfuser;
import com.github.will11690.mechanicraft.blocks.machines.tier1.t1crusher.T1Crusher;
import com.github.will11690.mechanicraft.blocks.machines.tier1.t1energycube.T1EnergyCube;
import com.github.will11690.mechanicraft.blocks.machines.tier1.t1infuser.T1MetallicInfuser;
import com.github.will11690.mechanicraft.blocks.machines.tier1.t1orewasher.T1OreWasher;
import com.github.will11690.mechanicraft.blocks.machines.tier1.t1poweredsieve.T1PoweredSieve;
import com.github.will11690.mechanicraft.blocks.machines.tier1.t1press.T1Press;
import com.github.will11690.mechanicraft.blocks.machines.tier1.t1slurryprocessor.T1SlurryProcessor;
import com.github.will11690.mechanicraft.blocks.machines.tier2.t2crusher.T2Crusher;
import com.github.will11690.mechanicraft.blocks.machines.tier2.t2energycube.T2EnergyCube;
import com.github.will11690.mechanicraft.blocks.machines.tier2.t2infuser.T2MetallicInfuser;
import com.github.will11690.mechanicraft.blocks.machines.tier2.t2orewasher.T2OreWasher;
import com.github.will11690.mechanicraft.blocks.machines.tier2.t2poweredsieve.T2PoweredSieve;
import com.github.will11690.mechanicraft.blocks.machines.tier2.t2press.T2Press;
import com.github.will11690.mechanicraft.blocks.machines.tier2.t2slurryprocessor.T2SlurryProcessor;
import com.github.will11690.mechanicraft.blocks.machines.tier3.t3crusher.T3Crusher;
import com.github.will11690.mechanicraft.blocks.machines.tier3.t3energycube.T3EnergyCube;
import com.github.will11690.mechanicraft.blocks.machines.tier3.t3infuser.T3MetallicInfuser;
import com.github.will11690.mechanicraft.blocks.machines.tier3.t3orewasher.T3OreWasher;
import com.github.will11690.mechanicraft.blocks.machines.tier3.t3poweredsieve.T3PoweredSieve;
import com.github.will11690.mechanicraft.blocks.machines.tier3.t3press.T3Press;
import com.github.will11690.mechanicraft.blocks.machines.tier3.t3slurryprocessor.T3SlurryProcessor;
import com.github.will11690.mechanicraft.blocks.machines.tier4.t4crusher.T4Crusher;
import com.github.will11690.mechanicraft.blocks.machines.tier4.t4energycube.T4EnergyCube;
import com.github.will11690.mechanicraft.blocks.machines.tier4.t4infuser.T4MetallicInfuser;
import com.github.will11690.mechanicraft.blocks.machines.tier4.t4orewasher.T4OreWasher;
import com.github.will11690.mechanicraft.blocks.machines.tier4.t4poweredsieve.T4PoweredSieve;
import com.github.will11690.mechanicraft.blocks.machines.tier4.t4press.T4Press;
import com.github.will11690.mechanicraft.blocks.machines.tier4.t4slurryprocessor.T4SlurryProcessor;
import com.github.will11690.mechanicraft.blocks.machines.tier5.lineminer.LineMiner;
import com.github.will11690.mechanicraft.blocks.machines.tier5.lineminer.miningchute.MiningChute;
import com.github.will11690.mechanicraft.blocks.machines.tier5.t5crusher.T5Crusher;
import com.github.will11690.mechanicraft.blocks.machines.tier5.t5energycube.T5EnergyCube;
import com.github.will11690.mechanicraft.blocks.machines.tier5.t5infuser.T5MetallicInfuser;
import com.github.will11690.mechanicraft.blocks.machines.tier5.t5orewasher.T5OreWasher;
import com.github.will11690.mechanicraft.blocks.machines.tier5.t5poweredsieve.T5PoweredSieve;
import com.github.will11690.mechanicraft.blocks.machines.tier5.t5press.T5Press;
import com.github.will11690.mechanicraft.blocks.machines.tier5.t5slurryprocessor.T5SlurryProcessor;
import com.github.will11690.mechanicraft.blocks.machines.tier6.t6crusher.T6Crusher;
import com.github.will11690.mechanicraft.blocks.machines.tier6.t6energycube.T6EnergyCube;
import com.github.will11690.mechanicraft.blocks.machines.tier6.t6infuser.T6MetallicInfuser;
import com.github.will11690.mechanicraft.blocks.machines.tier6.t6orewasher.T6OreWasher;
import com.github.will11690.mechanicraft.blocks.machines.tier6.t6poweredsieve.T6PoweredSieve;
import com.github.will11690.mechanicraft.blocks.machines.tier6.t6press.T6Press;
import com.github.will11690.mechanicraft.blocks.machines.tier6.t6slurryprocessor.T6SlurryProcessor;
import com.github.will11690.mechanicraft.items.tanks.TankItem;
import com.github.will11690.mechanicraft.tabs.TabGroups;
import com.github.will11690.mechanicraft.util.Reference;
import com.github.will11690.mechanicraft.util.handlers.RegistryHandler;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;

public class ModBlocks {
	
	//ORES
    public static final RegistryObject<Block> COPPER_ORE = register("copper_ore", () ->
		new Block(AbstractBlock.Properties.of(Material.STONE)
		.strength(2, 3.0F).harvestLevel(1).harvestTool(ToolType.PICKAXE)
		.requiresCorrectToolForDrops().sound(SoundType.STONE)));
    
    public static final RegistryObject<Block> ENDER_ORE = register("ender_ore", () ->
		new Block(AbstractBlock.Properties.of(Material.STONE)
		.strength(3, 3.0F).harvestLevel(2).harvestTool(ToolType.PICKAXE)
		.requiresCorrectToolForDrops().sound(SoundType.STONE)));
    
    public static final RegistryObject<Block> LEAD_ORE = register("lead_ore", () ->
		new Block(AbstractBlock.Properties.of(Material.STONE)
		.strength(1, 3.0F).harvestLevel(1).harvestTool(ToolType.PICKAXE)
		.requiresCorrectToolForDrops().sound(SoundType.STONE)));
    
    public static final RegistryObject<Block> SILVER_ORE = register("silver_ore", () ->
		new Block(AbstractBlock.Properties.of(Material.STONE)
		.strength(2, 3.0F).harvestLevel(1).harvestTool(ToolType.PICKAXE)
		.requiresCorrectToolForDrops().sound(SoundType.STONE)));
    
    public static final RegistryObject<Block> TIN_ORE = register("tin_ore", () ->
		new Block(AbstractBlock.Properties.of(Material.STONE)
		.strength(2, 3.0F).harvestLevel(1).harvestTool(ToolType.PICKAXE)
		.requiresCorrectToolForDrops().sound(SoundType.STONE)));
    
    public static final RegistryObject<Block> RUBY_ORE = register("ruby_ore", () ->
		new Block(AbstractBlock.Properties.of(Material.STONE)
		.strength(3, 3.0F).harvestLevel(2).harvestTool(ToolType.PICKAXE)
		.requiresCorrectToolForDrops().sound(SoundType.STONE)));
    
    public static final RegistryObject<Block> SAPPHIRE_ORE = register("sapphire_ore", () ->
		new Block(AbstractBlock.Properties.of(Material.STONE)
		.strength(3, 3.0F).harvestLevel(2).harvestTool(ToolType.PICKAXE)
		.requiresCorrectToolForDrops().sound(SoundType.STONE)));

    //BLOCKS
    public static final RegistryObject<Block> ENDER_BLOCK = register("ender_block", () ->
    	new Block(AbstractBlock.Properties.of(Material.METAL).strength(2, 10).sound(SoundType.METAL).harvestLevel(1).harvestTool(ToolType.PICKAXE)));
    
    public static final RegistryObject<Block> STEEL_BLOCK = register("steel_block", () ->
		new Block(AbstractBlock.Properties.of(Material.METAL).strength(2, 10).sound(SoundType.METAL).harvestLevel(1).harvestTool(ToolType.PICKAXE)));
    
    public static final RegistryObject<Block> BRONZE_BLOCK = register("bronze_block", () ->
		new Block(AbstractBlock.Properties.of(Material.METAL).strength(2, 10).sound(SoundType.METAL).harvestLevel(1).harvestTool(ToolType.PICKAXE)));
    
    public static final RegistryObject<Block> COPPER_BLOCK = register("copper_block", () ->
    	new Block(AbstractBlock.Properties.of(Material.METAL).strength(2, 10).sound(SoundType.METAL).harvestLevel(1).harvestTool(ToolType.PICKAXE)));
    
    public static final RegistryObject<Block> EMERONIUM_BLOCK = register("emeronium_block", () ->
    	new Block(AbstractBlock.Properties.of(Material.METAL).strength(2, 10).sound(SoundType.METAL).harvestLevel(1).harvestTool(ToolType.PICKAXE)));
    
    public static final RegistryObject<Block> ENDONIUM_BLOCK = register("endonium_block", () ->
    	new Block(AbstractBlock.Properties.of(Material.METAL).strength(2, 10).sound(SoundType.METAL).harvestLevel(1).harvestTool(ToolType.PICKAXE)));
    
    public static final RegistryObject<Block> ENDONIUM_CRYSTAL_BLOCK = register("endonium_crystal_block", () ->
    	new Block(AbstractBlock.Properties.of(Material.METAL).strength(2, 10).sound(SoundType.METAL).harvestLevel(1).harvestTool(ToolType.PICKAXE)));
    
    public static final RegistryObject<Block> GOLD_INFUSED_IRON_BLOCK = register("gold_infused_iron_block", () ->
    	new Block(AbstractBlock.Properties.of(Material.METAL).strength(2, 10).sound(SoundType.METAL).harvestLevel(1).harvestTool(ToolType.PICKAXE)));
    
    public static final RegistryObject<Block> LEAD_BLOCK = register("lead_block", () ->
    	new Block(AbstractBlock.Properties.of(Material.METAL).strength(2, 10).sound(SoundType.METAL).harvestLevel(1).harvestTool(ToolType.PICKAXE)));
    
    public static final RegistryObject<Block> OBSIDIUM_BLOCK = register("obsidium_block", () ->
    	new Block(AbstractBlock.Properties.of(Material.METAL).strength(2, 10).sound(SoundType.METAL).harvestLevel(1).harvestTool(ToolType.PICKAXE)));
    
    public static final RegistryObject<Block> RUBONIUM_BLOCK = register("rubonium_block", () ->
    	new Block(AbstractBlock.Properties.of(Material.METAL).strength(2, 10).sound(SoundType.METAL).harvestLevel(1).harvestTool(ToolType.PICKAXE)));
    
    public static final RegistryObject<Block> RUBY_BLOCK = register("ruby_block", () ->
    	new Block(AbstractBlock.Properties.of(Material.METAL).strength(2, 10).sound(SoundType.METAL).harvestLevel(1).harvestTool(ToolType.PICKAXE)));
    
    public static final RegistryObject<Block> SAPHONIUM_BLOCK = register("saphonium_block", () ->
		new Block(AbstractBlock.Properties.of(Material.METAL).strength(2, 10).sound(SoundType.METAL).harvestLevel(1).harvestTool(ToolType.PICKAXE)));
    
    public static final RegistryObject<Block> SAPPHIRE_BLOCK = register("sapphire_block", () ->
		new Block(AbstractBlock.Properties.of(Material.METAL).strength(2, 10).sound(SoundType.METAL).harvestLevel(1).harvestTool(ToolType.PICKAXE)));
    
    public static final RegistryObject<Block> SILVER_BLOCK = register("silver_block", () ->
		new Block(AbstractBlock.Properties.of(Material.METAL).strength(2, 10).sound(SoundType.METAL).harvestLevel(1).harvestTool(ToolType.PICKAXE)));
    
    public static final RegistryObject<Block> TIN_BLOCK = register("tin_block", () ->
		new Block(AbstractBlock.Properties.of(Material.METAL).strength(2, 10).sound(SoundType.METAL).harvestLevel(1).harvestTool(ToolType.PICKAXE)));
    
    //MACHINE PARTS
    
    //CRAFTING
    public static final RegistryObject<Block> MACHINE_BLOCK = register("machine_block", () ->
	new Block(AbstractBlock.Properties.of(Material.METAL).strength(2, 10).sound(SoundType.METAL).harvestLevel(1).harvestTool(ToolType.PICKAXE)));
    
    public static final RegistryObject<Block> T1_GEAR_BOX = register("t1_gear_box", () ->
	new Block(AbstractBlock.Properties.of(Material.METAL).strength(2, 10).sound(SoundType.METAL).harvestLevel(1).harvestTool(ToolType.PICKAXE)));
    
    public static final RegistryObject<Block> T2_GEAR_BOX = register("t2_gear_box", () ->
	new Block(AbstractBlock.Properties.of(Material.METAL).strength(2, 10).sound(SoundType.METAL).harvestLevel(1).harvestTool(ToolType.PICKAXE)));
    
    public static final RegistryObject<Block> T3_GEAR_BOX = register("t3_gear_box", () ->
	new Block(AbstractBlock.Properties.of(Material.METAL).strength(2, 10).sound(SoundType.METAL).harvestLevel(1).harvestTool(ToolType.PICKAXE)));
    
    public static final RegistryObject<Block> T4_GEAR_BOX = register("t4_gear_box", () ->
	new Block(AbstractBlock.Properties.of(Material.METAL).strength(2, 10).sound(SoundType.METAL).harvestLevel(1).harvestTool(ToolType.PICKAXE)));
    
    public static final RegistryObject<Block> T5_GEAR_BOX = register("t5_gear_box", () ->
	new Block(AbstractBlock.Properties.of(Material.METAL).strength(2, 10).sound(SoundType.METAL).harvestLevel(1).harvestTool(ToolType.PICKAXE)));
    
    public static final RegistryObject<Block> T6_GEAR_BOX = register("t6_gear_box", () ->
	new Block(AbstractBlock.Properties.of(Material.METAL).strength(2, 10).sound(SoundType.METAL).harvestLevel(1).harvestTool(ToolType.PICKAXE)));
    
    //CHUTES
    
    //ENERGY
    public static final RegistryObject<T1EnergyChute> T1_ENERGY_CHUTE = register("t1_energy_chute", () ->
	new T1EnergyChute(AbstractBlock.Properties.of(Material.METAL).strength(1, 10).sound(SoundType.METAL).noOcclusion()));
    
    //ITEM
    public static final RegistryObject<T1ItemChute> T1_ITEM_CHUTE = register("t1_item_chute", () ->
	new T1ItemChute(AbstractBlock.Properties.of(Material.METAL).strength(1, 10).sound(SoundType.METAL).noOcclusion()));
    
    //FLUID
    public static final RegistryObject<T1FluidChute> T1_FLUID_CHUTE = register("t1_fluid_chute", () ->
	new T1FluidChute(AbstractBlock.Properties.of(Material.METAL).strength(1, 10).sound(SoundType.METAL).noOcclusion()));
    
    //FLUID TANKS
    
    //BASIC
    public static final RegistryObject<BasicFluidTank> BASIC_FLUID_TANK = registerTank("basic_fluid_tank", () ->
	new BasicFluidTank(AbstractBlock.Properties.of(Material.GLASS).strength(1, 20).sound(SoundType.GLASS).noOcclusion()));
    
    //ADVANCED
    public static final RegistryObject<AdvFluidTank> ADVANCED_FLUID_TANK = registerTank("advanced_fluid_tank", () ->
	new AdvFluidTank(AbstractBlock.Properties.of(Material.GLASS).strength(1, 20).sound(SoundType.GLASS).noOcclusion()));
    
    //ELITE
    public static final RegistryObject<EliteFluidTank> ELITE_FLUID_TANK = registerTank("elite_fluid_tank", () ->
	new EliteFluidTank(AbstractBlock.Properties.of(Material.GLASS).strength(1, 20).sound(SoundType.GLASS).noOcclusion()));
    
    //SUPERIOR
    public static final RegistryObject<SuperiorFluidTank> SUPERIOR_FLUID_TANK = registerTank("superior_fluid_tank", () ->
	new SuperiorFluidTank(AbstractBlock.Properties.of(Material.GLASS).strength(1, 20).sound(SoundType.GLASS).noOcclusion()));
    
    //SUPREME
    public static final RegistryObject<SupremeFluidTank> SUPREME_FLUID_TANK = registerTank("supreme_fluid_tank", () ->
	new SupremeFluidTank(AbstractBlock.Properties.of(Material.GLASS).strength(1, 20).sound(SoundType.GLASS).noOcclusion()));
    
    //ULTIMATE
    public static final RegistryObject<UltimateFluidTank> ULTIMATE_FLUID_TANK = registerTank("ultimate_fluid_tank", () ->
	new UltimateFluidTank(AbstractBlock.Properties.of(Material.GLASS).strength(1, 20).sound(SoundType.GLASS).noOcclusion()));
    
    //MACHINES
    
    //BASIC
	public static final RegistryObject<BasicMetallicInfuser> BASIC_METALLIC_INFUSER = registerMachines("basic_metallic_infuser", () ->
	new BasicMetallicInfuser(AbstractBlock.Properties.of(Material.METAL).strength(2, 20).sound(SoundType.METAL).harvestLevel(1).harvestTool(ToolType.PICKAXE)));
	
	public static final RegistryObject<BasicCoalGenerator> BASIC_COAL_GENERATOR = registerMachines("basic_coal_generator", () ->
	new BasicCoalGenerator(AbstractBlock.Properties.of(Material.METAL).strength(2, 20).sound(SoundType.METAL).harvestLevel(1).harvestTool(ToolType.PICKAXE)));
	
	public static final RegistryObject<BasicFurnace> BASIC_FURNACE = registerMachines("basic_furnace", () ->
	new BasicFurnace(AbstractBlock.Properties.of(Material.METAL).strength(2, 20).sound(SoundType.METAL).harvestLevel(1).harvestTool(ToolType.PICKAXE)));
	
    //ADVANCED
	public static final RegistryObject<AdvancedCoalGenerator> ADVANCED_COAL_GENERATOR = registerMachines("advanced_coal_generator", () ->
	new AdvancedCoalGenerator(AbstractBlock.Properties.of(Material.METAL).strength(2, 20).sound(SoundType.METAL).harvestLevel(1).harvestTool(ToolType.PICKAXE)));
	
	public static final RegistryObject<AdvancedFurnace> ADVANCED_FURNACE = registerMachines("advanced_furnace", () ->
	new AdvancedFurnace(AbstractBlock.Properties.of(Material.METAL).strength(2, 20).sound(SoundType.METAL).harvestLevel(1).harvestTool(ToolType.PICKAXE)));
	
    //T1 Machines
	public static final RegistryObject<T1EnergyCube> T1_ENERGY_CUBE = registerMachines("t1_energy_cube", () ->
	new T1EnergyCube(AbstractBlock.Properties.of(Material.METAL).strength(2, 20).sound(SoundType.METAL).harvestLevel(1).harvestTool(ToolType.PICKAXE)));
	
	public static final RegistryObject<T1Crusher> T1_CRUSHER = registerMachines("t1_crusher", () ->
	new T1Crusher(AbstractBlock.Properties.of(Material.METAL).strength(2, 20).sound(SoundType.METAL).harvestLevel(1).harvestTool(ToolType.PICKAXE)));
	
	public static final RegistryObject<T1Press> T1_PRESS = registerMachines("t1_press", () ->
	new T1Press(AbstractBlock.Properties.of(Material.METAL).strength(2, 20).sound(SoundType.METAL).harvestLevel(1).harvestTool(ToolType.PICKAXE)));
	
	public static final RegistryObject<T1MetallicInfuser> T1_METALLIC_INFUSER = registerMachines("t1_metallic_infuser", () ->
	new T1MetallicInfuser(AbstractBlock.Properties.of(Material.METAL).strength(2, 20).sound(SoundType.METAL).harvestLevel(1).harvestTool(ToolType.PICKAXE)));
	
	public static final RegistryObject<T1PoweredSieve> T1_POWERED_SIEVE = registerMachines("t1_powered_sieve", () ->
	new T1PoweredSieve(AbstractBlock.Properties.of(Material.METAL).strength(2, 20).sound(SoundType.METAL).harvestLevel(1).harvestTool(ToolType.PICKAXE)));
	
	public static final RegistryObject<T1OreWasher> T1_ORE_WASHER = registerMachines("t1_ore_washer", () ->
	new T1OreWasher(AbstractBlock.Properties.of(Material.METAL).strength(2, 20).sound(SoundType.METAL).harvestLevel(1).harvestTool(ToolType.PICKAXE)));
	
	public static final RegistryObject<T1SlurryProcessor> T1_SLURRY_PROCESSOR = registerMachines("t1_slurry_processor", () ->
	new T1SlurryProcessor(AbstractBlock.Properties.of(Material.METAL).strength(2, 20).sound(SoundType.METAL).harvestLevel(1).harvestTool(ToolType.PICKAXE)));//PAUSE
	
    //T2 Machines
	public static final RegistryObject<T2EnergyCube> T2_ENERGY_CUBE = registerMachines("t2_energy_cube", () ->
	new T2EnergyCube(AbstractBlock.Properties.of(Material.METAL).strength(2, 20).sound(SoundType.METAL).harvestLevel(1).harvestTool(ToolType.PICKAXE)));
	
	public static final RegistryObject<T2Crusher> T2_CRUSHER = registerMachines("t2_crusher", () ->
	new T2Crusher(AbstractBlock.Properties.of(Material.METAL).strength(2, 20).sound(SoundType.METAL).harvestLevel(1).harvestTool(ToolType.PICKAXE)));
	
	public static final RegistryObject<T2Press> T2_PRESS = registerMachines("t2_press", () ->
	new T2Press(AbstractBlock.Properties.of(Material.METAL).strength(2, 20).sound(SoundType.METAL).harvestLevel(1).harvestTool(ToolType.PICKAXE)));
	
	public static final RegistryObject<T2MetallicInfuser> T2_METALLIC_INFUSER = registerMachines("t2_metallic_infuser", () ->
	new T2MetallicInfuser(AbstractBlock.Properties.of(Material.METAL).strength(2, 20).sound(SoundType.METAL).harvestLevel(1).harvestTool(ToolType.PICKAXE)));
	
	public static final RegistryObject<T2PoweredSieve> T2_POWERED_SIEVE = registerMachines("t2_powered_sieve", () ->
	new T2PoweredSieve(AbstractBlock.Properties.of(Material.METAL).strength(2, 20).sound(SoundType.METAL).harvestLevel(1).harvestTool(ToolType.PICKAXE)));
	
	public static final RegistryObject<T2OreWasher> T2_ORE_WASHER = registerMachines("t2_ore_washer", () ->
	new T2OreWasher(AbstractBlock.Properties.of(Material.METAL).strength(2, 20).sound(SoundType.METAL).harvestLevel(1).harvestTool(ToolType.PICKAXE)));
	
	public static final RegistryObject<T2SlurryProcessor> T2_SLURRY_PROCESSOR = registerMachines("t2_slurry_processor", () ->
	new T2SlurryProcessor(AbstractBlock.Properties.of(Material.METAL).strength(2, 20).sound(SoundType.METAL).harvestLevel(1).harvestTool(ToolType.PICKAXE)));
    
    //T3 Machines
	public static final RegistryObject<T3EnergyCube> T3_ENERGY_CUBE = registerMachines("t3_energy_cube", () ->
	new T3EnergyCube(AbstractBlock.Properties.of(Material.METAL).strength(2, 20).sound(SoundType.METAL).harvestLevel(1).harvestTool(ToolType.PICKAXE)));
	
	public static final RegistryObject<T3Crusher> T3_CRUSHER = registerMachines("t3_crusher", () ->
	new T3Crusher(AbstractBlock.Properties.of(Material.METAL).strength(2, 20).sound(SoundType.METAL).harvestLevel(1).harvestTool(ToolType.PICKAXE)));
	
	public static final RegistryObject<T3Press> T3_PRESS = registerMachines("t3_press", () ->
	new T3Press(AbstractBlock.Properties.of(Material.METAL).strength(2, 20).sound(SoundType.METAL).harvestLevel(1).harvestTool(ToolType.PICKAXE)));
	
	public static final RegistryObject<T3MetallicInfuser> T3_METALLIC_INFUSER = registerMachines("t3_metallic_infuser", () ->
	new T3MetallicInfuser(AbstractBlock.Properties.of(Material.METAL).strength(2, 20).sound(SoundType.METAL).harvestLevel(1).harvestTool(ToolType.PICKAXE)));
	
	public static final RegistryObject<T3PoweredSieve> T3_POWERED_SIEVE = registerMachines("t3_powered_sieve", () ->
	new T3PoweredSieve(AbstractBlock.Properties.of(Material.METAL).strength(2, 20).sound(SoundType.METAL).harvestLevel(1).harvestTool(ToolType.PICKAXE)));
	
	public static final RegistryObject<T3OreWasher> T3_ORE_WASHER = registerMachines("t3_ore_washer", () ->
	new T3OreWasher(AbstractBlock.Properties.of(Material.METAL).strength(2, 20).sound(SoundType.METAL).harvestLevel(1).harvestTool(ToolType.PICKAXE)));
	
	public static final RegistryObject<T3SlurryProcessor> T3_SLURRY_PROCESSOR = registerMachines("t3_slurry_processor", () ->
	new T3SlurryProcessor(AbstractBlock.Properties.of(Material.METAL).strength(2, 20).sound(SoundType.METAL).harvestLevel(1).harvestTool(ToolType.PICKAXE)));
    
    //T4 Machines
	public static final RegistryObject<T4EnergyCube> T4_ENERGY_CUBE = registerMachines("t4_energy_cube", () ->
	new T4EnergyCube(AbstractBlock.Properties.of(Material.METAL).strength(2, 20).sound(SoundType.METAL).harvestLevel(1).harvestTool(ToolType.PICKAXE)));
	
	public static final RegistryObject<T4Crusher> T4_CRUSHER = registerMachines("t4_crusher", () ->
	new T4Crusher(AbstractBlock.Properties.of(Material.METAL).strength(2, 20).sound(SoundType.METAL).harvestLevel(1).harvestTool(ToolType.PICKAXE)));
	
	public static final RegistryObject<T4Press> T4_PRESS = registerMachines("t4_press", () ->
	new T4Press(AbstractBlock.Properties.of(Material.METAL).strength(2, 20).sound(SoundType.METAL).harvestLevel(1).harvestTool(ToolType.PICKAXE)));
	
	public static final RegistryObject<T4MetallicInfuser> T4_METALLIC_INFUSER = registerMachines("t4_metallic_infuser", () ->
	new T4MetallicInfuser(AbstractBlock.Properties.of(Material.METAL).strength(2, 20).sound(SoundType.METAL).harvestLevel(1).harvestTool(ToolType.PICKAXE)));
	
	public static final RegistryObject<T4PoweredSieve> T4_POWERED_SIEVE = registerMachines("t4_powered_sieve", () ->
	new T4PoweredSieve(AbstractBlock.Properties.of(Material.METAL).strength(2, 20).sound(SoundType.METAL).harvestLevel(1).harvestTool(ToolType.PICKAXE)));
	
	public static final RegistryObject<T4OreWasher> T4_ORE_WASHER = registerMachines("t4_ore_washer", () ->
	new T4OreWasher(AbstractBlock.Properties.of(Material.METAL).strength(2, 20).sound(SoundType.METAL).harvestLevel(1).harvestTool(ToolType.PICKAXE)));
	
	public static final RegistryObject<T4SlurryProcessor> T4_SLURRY_PROCESSOR = registerMachines("t4_slurry_processor", () ->
	new T4SlurryProcessor(AbstractBlock.Properties.of(Material.METAL).strength(2, 20).sound(SoundType.METAL).harvestLevel(1).harvestTool(ToolType.PICKAXE)));
    
    //T5 Machines
	public static final RegistryObject<LineMiner> LINE_MINER = registerMachines("line_miner", () ->
	new LineMiner(AbstractBlock.Properties.of(Material.METAL).strength(2, 20).sound(SoundType.METAL).noOcclusion().harvestLevel(1).harvestTool(ToolType.PICKAXE)));
	
	public static final RegistryObject<MiningChute> MINING_CHUTE = registerMachines("mining_chute", () ->
	new MiningChute(AbstractBlock.Properties.of(Material.METAL).strength(Float.MAX_VALUE, Float.MAX_VALUE).sound(SoundType.METAL).noOcclusion()));
	
	public static final RegistryObject<T5EnergyCube> T5_ENERGY_CUBE = registerMachines("t5_energy_cube", () ->
	new T5EnergyCube(AbstractBlock.Properties.of(Material.METAL).strength(2, 20).sound(SoundType.METAL).harvestLevel(1).harvestTool(ToolType.PICKAXE)));
	
	public static final RegistryObject<T5Crusher> T5_CRUSHER = registerMachines("t5_crusher", () ->
	new T5Crusher(AbstractBlock.Properties.of(Material.METAL).strength(2, 20).sound(SoundType.METAL).harvestLevel(1).harvestTool(ToolType.PICKAXE)));
	
	public static final RegistryObject<T5Press> T5_PRESS = registerMachines("t5_press", () ->
	new T5Press(AbstractBlock.Properties.of(Material.METAL).strength(2, 20).sound(SoundType.METAL).harvestLevel(1).harvestTool(ToolType.PICKAXE)));
	
	public static final RegistryObject<T5MetallicInfuser> T5_METALLIC_INFUSER = registerMachines("t5_metallic_infuser", () ->
	new T5MetallicInfuser(AbstractBlock.Properties.of(Material.METAL).strength(2, 20).sound(SoundType.METAL).harvestLevel(1).harvestTool(ToolType.PICKAXE)));
	
	public static final RegistryObject<T5PoweredSieve> T5_POWERED_SIEVE = registerMachines("t5_powered_sieve", () ->
	new T5PoweredSieve(AbstractBlock.Properties.of(Material.METAL).strength(2, 20).sound(SoundType.METAL).harvestLevel(1).harvestTool(ToolType.PICKAXE)));
	
	public static final RegistryObject<T5OreWasher> T5_ORE_WASHER = registerMachines("t5_ore_washer", () ->
	new T5OreWasher(AbstractBlock.Properties.of(Material.METAL).strength(2, 20).sound(SoundType.METAL).harvestLevel(1).harvestTool(ToolType.PICKAXE)));
	
	public static final RegistryObject<T5SlurryProcessor> T5_SLURRY_PROCESSOR = registerMachines("t5_slurry_processor", () ->
	new T5SlurryProcessor(AbstractBlock.Properties.of(Material.METAL).strength(2, 20).sound(SoundType.METAL).harvestLevel(1).harvestTool(ToolType.PICKAXE)));
    
    //T6 Machines
	public static final RegistryObject<T6EnergyCube> T6_ENERGY_CUBE = registerMachines("t6_energy_cube", () ->
	new T6EnergyCube(AbstractBlock.Properties.of(Material.METAL).strength(2, 20).sound(SoundType.METAL).harvestLevel(1).harvestTool(ToolType.PICKAXE)));
	
	public static final RegistryObject<T6Crusher> T6_CRUSHER = registerMachines("t6_crusher", () ->
	new T6Crusher(AbstractBlock.Properties.of(Material.METAL).strength(2, 20).sound(SoundType.METAL).harvestLevel(1).harvestTool(ToolType.PICKAXE)));
	
	public static final RegistryObject<T6Press> T6_PRESS = registerMachines("t6_press", () ->
	new T6Press(AbstractBlock.Properties.of(Material.METAL).strength(2, 20).sound(SoundType.METAL).harvestLevel(1).harvestTool(ToolType.PICKAXE)));
	
	public static final RegistryObject<T6MetallicInfuser> T6_METALLIC_INFUSER = registerMachines("t6_metallic_infuser", () ->
	new T6MetallicInfuser(AbstractBlock.Properties.of(Material.METAL).strength(2, 20).sound(SoundType.METAL).harvestLevel(1).harvestTool(ToolType.PICKAXE)));
	
	public static final RegistryObject<T6PoweredSieve> T6_POWERED_SIEVE = registerMachines("t6_powered_sieve", () ->
	new T6PoweredSieve(AbstractBlock.Properties.of(Material.METAL).strength(2, 20).sound(SoundType.METAL).harvestLevel(1).harvestTool(ToolType.PICKAXE)));
	
	public static final RegistryObject<T6OreWasher> T6_ORE_WASHER = registerMachines("t6_ore_washer", () ->
	new T6OreWasher(AbstractBlock.Properties.of(Material.METAL).strength(2, 20).sound(SoundType.METAL).harvestLevel(1).harvestTool(ToolType.PICKAXE)));
	
	public static final RegistryObject<T6SlurryProcessor> T6_SLURRY_PROCESSOR = registerMachines("t6_slurry_processor", () ->
	new T6SlurryProcessor(AbstractBlock.Properties.of(Material.METAL).strength(2, 20).sound(SoundType.METAL).harvestLevel(1).harvestTool(ToolType.PICKAXE)));
	
	public static void registerMachines() {}

    private static <T extends Block> RegistryObject<T> registerNoItemMachines(String name, Supplier<T> block) {
    	
    	MechaniCraftMain.MECHANICRAFT_LOGGER.info(Reference.MOD_ID + "-" + Reference.VERSION + ": " + "Setting up Deferred Registry Tiles-0!");
        return RegistryHandler.BLOCKS.register(name, block);
    }

    private static <T extends Block> RegistryObject<T> registerMachines(String name, Supplier<T> block) {
        RegistryObject<T> ret = registerNoItemMachines(name, block);
        MechaniCraftMain.MECHANICRAFT_LOGGER.info(Reference.MOD_ID + "-" + Reference.VERSION + ": " + "Setting up Deferred Registry Tiles-1!");
        RegistryHandler.ITEMS.register(name, () -> new BlockItem(ret.get(), new Item.Properties().tab(TabGroups.MOD_MACHINES_GROUP)));
        return ret;
    }

    public static void register() {}

    private static <T extends Block> RegistryObject<T> registerNoItem(String name, Supplier<T> block) {
    	
    	MechaniCraftMain.MECHANICRAFT_LOGGER.info(Reference.MOD_ID + "-" + Reference.VERSION + ": " + "Setting up Deferred Registry Non Tiles-0!");
        return RegistryHandler.BLOCKS.register(name, block);
    }

    private static <T extends Block> RegistryObject<T> register(String name, Supplier<T> block) {
        RegistryObject<T> ret = registerNoItem(name, block);
        MechaniCraftMain.MECHANICRAFT_LOGGER.info(Reference.MOD_ID + "-" + Reference.VERSION + ": " + "Setting up Deferred Registry Non Tiles-1!");
        RegistryHandler.ITEMS.register(name, () -> new BlockItem(ret.get(), new Item.Properties().tab(TabGroups.MOD_BLOCK_GROUP)));
        return ret;
    }

    private static <T extends Block> RegistryObject<T> registerTank(String name, Supplier<T> block) {
        RegistryObject<T> ret = registerNoItem(name, block);
        MechaniCraftMain.MECHANICRAFT_LOGGER.info(Reference.MOD_ID + "-" + Reference.VERSION + ": " + "Setting up Deferred Registry Tanks-1!");
        RegistryHandler.ITEMS.register(name, () -> new TankItem(ret.get(), new Item.Properties().tab(TabGroups.MOD_BLOCK_GROUP)));
        return ret;
    }
}
package net.yohn.tutorialmod.block;

import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.yohn.tutorialmod.TutorialMod;
import net.yohn.tutorialmod.block.custom.JewFurnance;
import net.yohn.tutorialmod.block.custom.JumpyBlock;
import net.yohn.tutorialmod.item.ModCreativeModeTab;
import net.yohn.tutorialmod.item.ModItems;

import java.util.function.Supplier;

public class ModBlocks {
    public static  final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, TutorialMod.MOD_ID);



    public static final RegistryObject<Block> PRAWN_BLOCK = registerBlock("prawn_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .jumpFactor(5f)
                    .strength(1f).requiresCorrectToolForDrops()), ModCreativeModeTab.TUTORIAL_TAB);

    public static final RegistryObject<Block> JUMPY_BLOCK = registerBlock("jumpy_block",
            () -> new JumpyBlock(BlockBehaviour.Properties.of(Material.STONE) // to use script must chnage name -> Jumpy Block
                    .jumpFactor(5f)
                    .strength(1f).requiresCorrectToolForDrops()), ModCreativeModeTab.TUTORIAL_TAB);

    public static final RegistryObject<Block> JEW_FURNANCE = registerBlock("jewfurnance",
            () -> new JewFurnance(BlockBehaviour.Properties.of(Material.STONE) // to use script must chnage name -> Jumpy Block
                    .lightLevel(state -> state.getValue(JewFurnance.LIT)? 15:0) // if it is on lit it
                    .strength(1f).requiresCorrectToolForDrops()), ModCreativeModeTab.TUTORIAL_TAB);

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block,
                                                                            CreativeModeTab tab) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}

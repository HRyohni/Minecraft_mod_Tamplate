package net.yohn.tutorialmod.item;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.yohn.tutorialmod.TutorialMod;
import net.yohn.tutorialmod.item.custom.EightBallItem;

public class ModItems {
public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, TutorialMod.MOD_ID);


public static final RegistryObject<Item> ZIRCON = ITEMS.register("zircon",
        ()-> new Item( new Item.Properties().tab(ModCreativeModeTab.TUTORIAL_TAB)));

    public static final RegistryObject<Item> PRAWN = ITEMS.register("prawn",
            ()-> new Item( new Item.Properties().tab(ModCreativeModeTab.TUTORIAL_TAB)));

    public static final RegistryObject<Item> Eight_Ball = ITEMS.register("eight_ball",
            ()-> new EightBallItem( new Item.Properties().tab(ModCreativeModeTab.TUTORIAL_TAB).stacksTo(1))); // Item -> EightBallItem new class

    public static void register (IEventBus eventBus)
    {
        ITEMS.register(eventBus);
    }

}

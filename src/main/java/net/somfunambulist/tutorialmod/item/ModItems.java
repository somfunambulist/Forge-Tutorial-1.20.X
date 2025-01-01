package net.somfunambulist.tutorialmod.item;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.RegistryObject;
import net.somfunambulist.tutorialmod.TutorialMod;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, TutorialMod.MOD_ID);

    public static final RegistryObject<Item> TWISTY_CARROT = ITEMS.register("twisty_carrot",
            () -> new Item(new Item.Properties().food(ModFoods.TWISTY_CARROT)));
    public static final RegistryObject<Item> LEGGY_CARROT = ITEMS.register("leggy_carrot",
            () -> new Item(new Item.Properties().food(ModFoods.TWISTY_CARROT)));
    public static final RegistryObject<Item> CARROT_BABY = ITEMS.register("carrot_baby",
            () -> new Item(new Item.Properties().food(ModFoods.TWISTY_CARROT)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}

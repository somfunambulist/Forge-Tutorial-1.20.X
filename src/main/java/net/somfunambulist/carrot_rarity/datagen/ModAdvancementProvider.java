package net.somfunambulist.carrot_rarity.datagen;

import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.DisplayInfo;
import net.minecraft.advancements.FrameType;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.client.Minecraft;
import net.minecraft.core.HolderLookup;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.ForgeAdvancementProvider;
import net.somfunambulist.carrot_rarity.CarrotRarity;
import net.somfunambulist.carrot_rarity.item.ModItems;

import java.util.function.Consumer;

public class ModAdvancementProvider implements ForgeAdvancementProvider.AdvancementGenerator {
    @Override
    public void generate(HolderLookup.Provider registries, Consumer<Advancement> saver, ExistingFileHelper existingFileHelper) {
        Advancement rootAdvancement = Advancement.Builder.advancement()
                .display(new DisplayInfo(new ItemStack(ModItems.LEGGY_CARROT.get()),
                        Component.literal("Carrot Rarity"), Component.literal("That's a nice pull!"),
                        new ResourceLocation("minecraft", "textures/block/gold_block.png"), FrameType.TASK,
                        true, true, false))
                .addCriterion("has_leggy_carrot", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.LEGGY_CARROT.get()))
                .save(saver, new ResourceLocation(CarrotRarity.MOD_ID, "leggy_carrot"), existingFileHelper);

        Advancement rareCarrot = Advancement.Builder.advancement()
                .display(new DisplayInfo(new ItemStack(ModItems.CARROT_BABY.get()),
                        Component.literal("BCIF"), Component.literal("(Best Carrot In the Format)"),
                        null, FrameType.GOAL,
                        true, true, false))
                .parent(rootAdvancement)
                .addCriterion("has_carrot_baby", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.CARROT_BABY.get()))
                .save(saver, new ResourceLocation(CarrotRarity.MOD_ID, "carrot_baby"), existingFileHelper);

        Advancement secretRare = Advancement.Builder.advancement()
                .display(new DisplayInfo(new ItemStack(ModItems.HOLOGRAPHIC_CARROT_BABY.get()),
                        Component.literal("Secret Rare"), Component.literal("You hit the jackpot!"),
                        null, FrameType.CHALLENGE,
                        true, true, true))
                .parent(rareCarrot)
                .addCriterion("has_holographic_carrot_baby", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.HOLOGRAPHIC_CARROT_BABY.get()))
                .save(saver, new ResourceLocation(CarrotRarity.MOD_ID, "holographic_carrot_baby"), existingFileHelper);
    }
}

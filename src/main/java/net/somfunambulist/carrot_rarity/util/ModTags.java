package net.somfunambulist.carrot_rarity.util;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.somfunambulist.carrot_rarity.CarrotRarity;

public class ModTags {
    public static class Blocks {

        private static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(CarrotRarity.MOD_ID, name));
        }
    }

    public static class Items {
        public static final TagKey<Item> IS_CARROT = tag("is_carrot");

        private static TagKey<Item> tag(String name) {
            return ItemTags.create(new ResourceLocation(CarrotRarity.MOD_ID, name));
        }
    }
}

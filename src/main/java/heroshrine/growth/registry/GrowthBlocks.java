package heroshrine.growth.registry;

import heroshrine.growth.Growth;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.MapColor;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvents;

public class GrowthBlocks {

    public static final Block ENTHRALLED = withItem("thrallroot", new Block(Settings.ENTHRALLED));

    public static void initialize() {
        Growth.LOGGER.info("Registering Blocks for " + Growth.MOD_ID);
    }

    public static <T extends Block> T register(String name, T block) {
        return Registry.register(Registries.BLOCK, Growth.id(name), block);
    }

    public static <T extends Block> T withItem(String name, T block) {
        return withItem(name, block, new Item.Settings());
    }

    public static <T extends Block> T withItem(String name, T block, Item.Settings settings) {
        T registered = register(name, block);
        GrowthItems.register(name, new BlockItem(registered, settings));
        return registered;
    }

    public class Settings {
        public static final AbstractBlock.Settings ENTHRALLED = AbstractBlock.Settings.create()
                .mapColor(MapColor.DARK_RED)
                .strength(6.0F, 12.0F)
                .sounds(new BlockSoundGroup(1.0F, 0.8f, SoundEvents.ENTITY_SQUID_HURT, SoundEvents.BLOCK_PACKED_MUD_STEP, SoundEvents.BLOCK_PACKED_MUD_FALL, SoundEvents.ENTITY_STRIDER_STEP, SoundEvents.ENTITY_SQUID_HURT))
                .solid()
                .requiresTool()
                .slipperiness(0.67F)
                .velocityMultiplier(0.98F)
                .allowsSpawning(Blocks::always);
    }
}

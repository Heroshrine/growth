package heroshrine.growth;

import heroshrine.growth.registry.GrowthBlocks;
import heroshrine.growth.registry.GrowthItemGroups;
import heroshrine.growth.registry.GrowthItems;
import net.fabricmc.api.ModInitializer;

import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Growth implements ModInitializer {
    public static final String MOD_ID = "growth";

    // This logger is used to write text to the console and the log file.
    // It is considered best practice to use your mod id as the logger's name.
    // That way, it's clear which mod wrote info, warnings, and errors.
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        // This code runs as soon as Minecraft is in a mod-load-ready state.
        // However, some things (like resources) may still be uninitialized.
        // Proceed with mild caution.

        GrowthItems.initialize();
        GrowthBlocks.initialize();
        GrowthItemGroups.initialize();
    }

    public static Identifier id(String name) {
        return Identifier.of(MOD_ID, name);
    }
}
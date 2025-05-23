package heroshrine.growth.registry;

import heroshrine.growth.Growth;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class GrowthItems {

    public static void initialize() {
        Growth.LOGGER.info("Registering Items for " + Growth.MOD_ID);
    }

    public static <T extends Item> T register(String name, T item) {
        return Registry.register(Registries.ITEM, Growth.id(name), item);
    }

}

package heroshrine.growth.registry;

import heroshrine.growth.Growth;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.Optional;
import java.util.stream.Stream;

public class GrowthItemGroups {

    private static final Text EXAMPLE_GROUP_TITLE = Text.translatable("itemGroup." + Growth.MOD_ID + ".example_group");


    public static final ItemGroup EXAMPLE_GROUP = register("example_group", FabricItemGroup.builder()
            .displayName(EXAMPLE_GROUP_TITLE)
            .icon(GrowthBlocks.ENTHRALLED.asItem()::getDefaultStack)
            .special()
            .entries((displayContext, entries) -> {
                Stream<Identifier> itemIds = Registries.ITEM.getIds().stream().filter(key -> key.getNamespace().equals(Growth.MOD_ID));
                Stream<Item> items = itemIds.map(Registries.ITEM::getOrEmpty)
                        .map(Optional::orElseThrow);
                items.forEach(entries::add);
            })
            .build());

    public static <T extends ItemGroup> T register(String name, T itemGroup) {
        return Registry.register(Registries.ITEM_GROUP, Growth.id(name), itemGroup);
    }

    public static void initialize() {
        Growth.LOGGER.info("Registering Item Groups for " + Growth.MOD_ID);
    }

}

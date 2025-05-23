package heroshrine.growth.data.provider;

import heroshrine.growth.registry.GrowthBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.TexturedModel;

public class ModelProvider extends FabricModelProvider {
    public ModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {

        blockStateModelGenerator.registerRandomHorizontalRotations(TexturedModel.CUBE_ALL, GrowthBlocks.ENTHRALLED);

    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
    }
}

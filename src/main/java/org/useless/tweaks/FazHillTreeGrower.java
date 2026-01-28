package org.useless.tweaks;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.grower.AbstractMegaTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.ovdrstudios.mw.ManagementWantedMod;
import org.jetbrains.annotations.Nullable;

public class FazHillTreeGrower extends AbstractMegaTreeGrower {
    private static final ResourceKey<ConfiguredFeature<?, ?>> FAZ_HILLS_TREE = ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(ManagementWantedMod.MODID, "faz_trees_plain"));
    private static final ResourceKey<ConfiguredFeature<?, ?>> FAZ_HILLS_TREE_MEGA = ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(ManagementWantedMod.MODID, "fazbear_hills_tree"));
    @Override
    protected @Nullable ResourceKey<ConfiguredFeature<?, ?>> getConfiguredMegaFeature(RandomSource p_222904_) {
        return FAZ_HILLS_TREE_MEGA;
    }

    @Override
    protected @Nullable ResourceKey<ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource p_222910_, boolean p_222911_) {
        return FAZ_HILLS_TREE;
    }
}

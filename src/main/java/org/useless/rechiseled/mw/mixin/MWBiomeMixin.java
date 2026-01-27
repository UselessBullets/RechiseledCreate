package org.useless.rechiseled.mw.mixin;

import com.google.common.base.Suppliers;
import com.mojang.datafixers.util.Pair;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeSource;
import net.minecraft.world.level.biome.Climate;
import net.minecraft.world.level.biome.FeatureSorter;
import net.minecraft.world.level.biome.MultiNoiseBiomeSource;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.dimension.BuiltinDimensionTypes;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.dimension.LevelStem;
import net.minecraft.world.level.levelgen.NoiseBasedChunkGenerator;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;
import net.minecraft.world.level.levelgen.SurfaceRules;
import net.minecraft.world.level.levelgen.SurfaceRules.RuleSource;
import net.minecraftforge.event.server.ServerAboutToStartEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.ovdrstudios.mw.init.ManagementWantedModBiomes;
import net.ovdrstudios.mw.init.ManagementWantedModBlocks;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.useless.rechiseled.mw.RechiseledMW;

import java.util.ArrayList;
import java.util.List;

@Mixin(value = ManagementWantedModBiomes.class, remap = false)
public abstract class MWBiomeMixin {
    @Shadow
    private static void addParameterPoint(List<Pair<Climate.ParameterPoint, Holder<Biome>>> parameters, Pair<Climate.ParameterPoint, Holder<Biome>> point) {

    }

    @Shadow
    private static void addSurfaceRule(List<SurfaceRules.RuleSource> surfaceRules, int index, SurfaceRules.RuleSource rule) {
    }

    @Shadow
    private static RuleSource preliminarySurfaceRule(ResourceKey<Biome> biomeKey, BlockState groundBlock, BlockState undergroundBlock, BlockState underwaterBlock) {
        return null;
    }

    /**
     * @author Useless
     * @reason I hate management wanted biomes
     */
    @SubscribeEvent
    @Overwrite
    public static void onServerAboutToStart(ServerAboutToStartEvent event) {
        RechiseledMW.LOGGER.info("Did MW Biome Mixin!");
        MinecraftServer server = event.getServer();
        Registry<DimensionType> dimensionTypeRegistry = server.registryAccess().registryOrThrow(Registries.DIMENSION_TYPE);
        Registry<LevelStem> levelStemTypeRegistry = server.registryAccess().registryOrThrow(Registries.LEVEL_STEM);
        Registry<Biome> biomeRegistry = server.registryAccess().registryOrThrow(Registries.BIOME);

        for(LevelStem levelStem : levelStemTypeRegistry.stream().toList()) {
            DimensionType dimensionType = levelStem.type().value();
            if (dimensionType == dimensionTypeRegistry.getOrThrow(BuiltinDimensionTypes.OVERWORLD)) {
                ChunkGenerator chunkGenerator = levelStem.generator();
                BiomeSource var10 = chunkGenerator.getBiomeSource();
                if (var10 instanceof MultiNoiseBiomeSource noiseSource) {
                    List<Pair<Climate.ParameterPoint, Holder<Biome>>> parameters = new ArrayList<>(noiseSource.parameters().values());

                    final float hillOff = 0.125f;
                    final float woodOff = 0.05f;
                    final float fieldOff = 0.0f;
                    final float lilyOff = 0.025f;
                    final float tombOff = 0.0f;
                    addParameterPoint(parameters, new Pair<>(new Climate.ParameterPoint(Climate.Parameter.span(-0.15F + hillOff, 0.5F - hillOff), Climate.Parameter.span(-0.3F + hillOff, 0.9F - hillOff), Climate.Parameter.span(0.0F + hillOff, 0.6F - hillOff), Climate.Parameter.span(-0.4F + hillOff, 0.4F - hillOff), Climate.Parameter.point(0.0F), Climate.Parameter.span(-1.0F + hillOff, 0.8F - hillOff), 0L), biomeRegistry.getHolderOrThrow(ResourceKey.create(Registries.BIOME, new ResourceLocation("management_wanted", "fazbear_hills")))));
                    addParameterPoint(parameters, new Pair<>(new Climate.ParameterPoint(Climate.Parameter.span(-0.15F + hillOff, 0.5F - hillOff), Climate.Parameter.span(-0.3F + hillOff, 0.9F - hillOff), Climate.Parameter.span(0.0F + hillOff, 0.6F - hillOff), Climate.Parameter.span(-0.4F + hillOff, 0.4F - hillOff), Climate.Parameter.point(1.0F), Climate.Parameter.span(-1.0F + hillOff, 0.8F - hillOff), 0L), biomeRegistry.getHolderOrThrow(ResourceKey.create(Registries.BIOME, new ResourceLocation("management_wanted", "fazbear_hills")))));
                    addParameterPoint(parameters, new Pair<>(new Climate.ParameterPoint(Climate.Parameter.span(0.2F + woodOff, 0.9F - woodOff), Climate.Parameter.span(-0.7F + woodOff, 0.2F - woodOff), Climate.Parameter.span(0.05F + woodOff, 0.7F - woodOff), Climate.Parameter.span(-0.3F + woodOff, 0.5F - woodOff), Climate.Parameter.point(0.0F), Climate.Parameter.span(-0.8F + woodOff, 0.6F - woodOff), 0L), biomeRegistry.getHolderOrThrow(ResourceKey.create(Registries.BIOME, new ResourceLocation("management_wanted", "choppys_woods")))));
                    addParameterPoint(parameters, new Pair<>(new Climate.ParameterPoint(Climate.Parameter.span(0.2F + woodOff, 0.9F - woodOff), Climate.Parameter.span(-0.7F + woodOff, 0.2F - woodOff), Climate.Parameter.span(0.05F + woodOff, 0.7F - woodOff), Climate.Parameter.span(-0.3F + woodOff, 0.5F - woodOff), Climate.Parameter.point(1.0F), Climate.Parameter.span(-0.8F + woodOff, 0.6F - woodOff), 0L), biomeRegistry.getHolderOrThrow(ResourceKey.create(Registries.BIOME, new ResourceLocation("management_wanted", "choppys_woods")))));
                    addParameterPoint(parameters, new Pair<>(new Climate.ParameterPoint(Climate.Parameter.span(-1.0F + fieldOff, -0.4F - fieldOff), Climate.Parameter.span(0.05F + fieldOff, 1.0F - fieldOff), Climate.Parameter.span(0.25F + fieldOff, 1.0F - fieldOff), Climate.Parameter.span(-0.5F + fieldOff, 0.5F - fieldOff), Climate.Parameter.point(0.0F), Climate.Parameter.span(-0.8F, 0.7F), 0L), biomeRegistry.getHolderOrThrow(ResourceKey.create(Registries.BIOME, new ResourceLocation("management_wanted", "dusting_fields")))));
                    addParameterPoint(parameters, new Pair<>(new Climate.ParameterPoint(Climate.Parameter.span(-1.0F + fieldOff, -0.4F - fieldOff), Climate.Parameter.span(0.05F + fieldOff, 1.0F - fieldOff), Climate.Parameter.span(0.25F + fieldOff, 1.0F - fieldOff), Climate.Parameter.span(-0.5F + fieldOff, 0.5F - fieldOff), Climate.Parameter.point(1.0F), Climate.Parameter.span(-0.8F, 0.7F), 0L), biomeRegistry.getHolderOrThrow(ResourceKey.create(Registries.BIOME, new ResourceLocation("management_wanted", "dusting_fields")))));
                    addParameterPoint(parameters, new Pair<>(new Climate.ParameterPoint(Climate.Parameter.span(0.0F + lilyOff, 0.6F - lilyOff), Climate.Parameter.span(0.0F + lilyOff, 0.9F - lilyOff), Climate.Parameter.span(-0.8F + lilyOff, 0.0F - lilyOff), Climate.Parameter.span(-0.3F + lilyOff, 0.45F - lilyOff), Climate.Parameter.point(0.0F), Climate.Parameter.span(-0.5F, 0.5F), 0L), biomeRegistry.getHolderOrThrow(ResourceKey.create(Registries.BIOME, new ResourceLocation("management_wanted", "lilygear_lake")))));
                    addParameterPoint(parameters, new Pair<>(new Climate.ParameterPoint(Climate.Parameter.span(0.0F + lilyOff, 0.6F - lilyOff), Climate.Parameter.span(0.0F + lilyOff, 0.9F - lilyOff), Climate.Parameter.span(-0.8F + lilyOff, 0.0F - lilyOff), Climate.Parameter.span(-0.3F + lilyOff, 0.45F - lilyOff), Climate.Parameter.point(1.0F), Climate.Parameter.span(-0.5F, 0.5F), 0L), biomeRegistry.getHolderOrThrow(ResourceKey.create(Registries.BIOME, new ResourceLocation("management_wanted", "lilygear_lake")))));
                    addParameterPoint(parameters, new Pair<>(new Climate.ParameterPoint(Climate.Parameter.span(-0.45F/* + tombOff*/, 0.0F/* - tombOff*/), Climate.Parameter.span(-1.0F + tombOff, 0.1F - tombOff), Climate.Parameter.span(0.05F + tombOff, 1.0F - tombOff), Climate.Parameter.span(0.0F + tombOff, 0.7F - tombOff), Climate.Parameter.point(0.0F), Climate.Parameter.span(-0.7F, 0.8F), 0L), biomeRegistry.getHolderOrThrow(ResourceKey.create(Registries.BIOME, new ResourceLocation("management_wanted", "blacktomb_yard")))));
                    addParameterPoint(parameters, new Pair<>(new Climate.ParameterPoint(Climate.Parameter.span(-0.45F/* + tombOff*/, 0.0F/* - tombOff*/), Climate.Parameter.span(-1.0F + tombOff, 0.1F - tombOff), Climate.Parameter.span(0.05F + tombOff, 1.0F - tombOff), Climate.Parameter.span(0.0F + tombOff, 0.7F - tombOff), Climate.Parameter.point(1.0F), Climate.Parameter.span(-0.7F, 0.8F), 0L), biomeRegistry.getHolderOrThrow(ResourceKey.create(Registries.BIOME, new ResourceLocation("management_wanted", "blacktomb_yard")))));
                    chunkGenerator.biomeSource = MultiNoiseBiomeSource.createFromList(new Climate.ParameterList<>(parameters));
                    chunkGenerator.featuresPerStep = Suppliers.memoize(() -> FeatureSorter.buildFeaturesPerStep(List.copyOf(chunkGenerator.biomeSource.possibleBiomes()), (biome) -> chunkGenerator.generationSettingsGetter.apply(biome).features(), true));
                }

                if (chunkGenerator instanceof NoiseBasedChunkGenerator noiseGenerator) {
                    NoiseGeneratorSettings noiseGeneratorSettings = noiseGenerator.settings.value();
                    SurfaceRules.RuleSource currentRuleSource = noiseGeneratorSettings.surfaceRule();
                    if (currentRuleSource instanceof SurfaceRules.SequenceRuleSource sequenceRuleSource) {
                        List<SurfaceRules.RuleSource> surfaceRules = new ArrayList<>(sequenceRuleSource.sequence());
                        addSurfaceRule(surfaceRules, 1, preliminarySurfaceRule(ResourceKey.create(Registries.BIOME, new ResourceLocation("management_wanted", "fazbear_hills")), ManagementWantedModBlocks.FAZ_HILLS_GRASS.get().defaultBlockState(), ManagementWantedModBlocks.FAZ_HILLS_DIRT.get().defaultBlockState(), ManagementWantedModBlocks.FAZ_HILLS_STONE.get().defaultBlockState()));
                        addSurfaceRule(surfaceRules, 1, preliminarySurfaceRule(ResourceKey.create(Registries.BIOME, new ResourceLocation("management_wanted", "choppys_woods")), ManagementWantedModBlocks.CHOPPY_GRASS.get().defaultBlockState(), ManagementWantedModBlocks.FAZ_HILLS_DIRT.get().defaultBlockState(), ManagementWantedModBlocks.FAZ_HILLS_STONE.get().defaultBlockState()));
                        addSurfaceRule(surfaceRules, 1, preliminarySurfaceRule(ResourceKey.create(Registries.BIOME, new ResourceLocation("management_wanted", "dusting_fields")), ManagementWantedModBlocks.DUSTING_GRASS.get().defaultBlockState(), ManagementWantedModBlocks.DUSTING_DIRT.get().defaultBlockState(), ManagementWantedModBlocks.FAZ_HILLS_STONE.get().defaultBlockState()));
                        addSurfaceRule(surfaceRules, 1, preliminarySurfaceRule(ResourceKey.create(Registries.BIOME, new ResourceLocation("management_wanted", "lilygear_lake")), ManagementWantedModBlocks.FAZ_HILLS_GRASS.get().defaultBlockState(), ManagementWantedModBlocks.FAZ_HILLS_DIRT.get().defaultBlockState(), Blocks.GRAVEL.defaultBlockState()));
                        addSurfaceRule(surfaceRules, 1, preliminarySurfaceRule(ResourceKey.create(Registries.BIOME, new ResourceLocation("management_wanted", "blacktomb_yard")), ManagementWantedModBlocks.BLACK_TOMB_GRASS.get().defaultBlockState(), ManagementWantedModBlocks.BLACK_TOMB_DIRT.get().defaultBlockState(), ManagementWantedModBlocks.FAZ_HILLS_STONE.get().defaultBlockState()));
                        NoiseGeneratorSettings moddedNoiseGeneratorSettings = new NoiseGeneratorSettings(noiseGeneratorSettings.noiseSettings(), noiseGeneratorSettings.defaultBlock(), noiseGeneratorSettings.defaultFluid(), noiseGeneratorSettings.noiseRouter(), SurfaceRules.sequence(surfaceRules.toArray((x$0) -> new RuleSource[x$0])), noiseGeneratorSettings.spawnTarget(), noiseGeneratorSettings.seaLevel(), noiseGeneratorSettings.disableMobGeneration(), noiseGeneratorSettings.aquifersEnabled(), noiseGeneratorSettings.oreVeinsEnabled(), noiseGeneratorSettings.useLegacyRandomSource());
                        noiseGenerator.settings = new Holder.Direct<>(moddedNoiseGeneratorSettings);
                    }
                }
            }
        }
    }
}

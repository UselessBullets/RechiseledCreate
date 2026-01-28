package org.useless.tweaks.mixin;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DeadBushBlock;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.minecraftforge.common.util.ForgeSoundType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.ovdrstudios.mw.init.ManagementWantedModBlocks;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.useless.tweaks.FazHillTreeGrower;
import org.useless.tweaks.UselessTweaks;
import org.useless.tweaks.blocks.FazHillsGrassBlockNew;

import java.util.function.Supplier;

@Mixin(value = ManagementWantedModBlocks.class, remap = false)
public class MWBlocksMixin {
    @Redirect(method = "<clinit>", at = @At(value = "INVOKE", target = "Lnet/minecraftforge/registries/DeferredRegister;register(Ljava/lang/String;Ljava/util/function/Supplier;)Lnet/minecraftforge/registries/RegistryObject;", ordinal = 1202))
    private static RegistryObject<Block> unfuckBlackTombBush(DeferredRegister<Block> instance, String s, Supplier<? extends Block> name) {
        UselessTweaks.LOGGER.info("Replacing MW {} block!", s);
        return instance.register(s,
            () -> new DeadBushBlock(
                BlockBehaviour.Properties.of()
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .sound(
                        new ForgeSoundType(1.0F, 1.0F,
                            () -> ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.fromNamespaceAndPath("minecraft", "block.grass.break")),
                            () -> ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.fromNamespaceAndPath("minecraft", "block.grass.step")),
                            () -> ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.fromNamespaceAndPath("minecraft", "block.grass.place")),
                            () -> ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.fromNamespaceAndPath("minecraft", "block.grass.hit")),
                            () -> ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.fromNamespaceAndPath("minecraft", "block.grass.fall"))))
                    .strength(0.0F, 0.1F)
                    .noCollission()
                    .noOcclusion()
                    .isRedstoneConductor((bs, br, bp) -> false)));
    }

    @Redirect(method = "<clinit>", at = @At(value = "INVOKE", target = "Lnet/minecraftforge/registries/DeferredRegister;register(Ljava/lang/String;Ljava/util/function/Supplier;)Lnet/minecraftforge/registries/RegistryObject;", ordinal = 1324))
    private static RegistryObject<Block> unfuckFazHillsSapling(DeferredRegister<Block> instance, String s, Supplier<? extends Block> name) {
        UselessTweaks.LOGGER.info("Replacing MW {} block!", s);
        return instance.register(s,
            () -> new SaplingBlock(new FazHillTreeGrower()
                , BlockBehaviour.Properties.of()
                .mapColor(MapColor.PLANT)
                .randomTicks()
                .sound(SoundType.GRASS)
                .instabreak()
                .noCollission()
                .offsetType(BlockBehaviour.OffsetType.NONE)
                .pushReaction(PushReaction.DESTROY)));
    }

    @Redirect(method = "<clinit>", at = @At(value = "INVOKE", target = "Lnet/minecraftforge/registries/DeferredRegister;register(Ljava/lang/String;Ljava/util/function/Supplier;)Lnet/minecraftforge/registries/RegistryObject;", ordinal = 609))
    private static RegistryObject<Block> unfuckFazHillsGrass(DeferredRegister<Block> instance, String s, Supplier<? extends Block> name) {
        UselessTweaks.LOGGER.info("Replacing MW {} block!", s);
        return instance.register(s,
            () -> new FazHillsGrassBlockNew(
                BlockBehaviour.Properties.of()
                    .mapColor(MapColor.GRASS)
                    .sound(new ForgeSoundType(1.0F, 1.0F,
                        () -> ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.fromNamespaceAndPath("minecraft", "block.grass.break")),
                        () -> ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.fromNamespaceAndPath("minecraft", "block.grass.step")),
                        () -> ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.fromNamespaceAndPath("minecraft", "block.grass.place")),
                        () -> ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.fromNamespaceAndPath("minecraft", "block.grass.hit")),
                        () -> ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.fromNamespaceAndPath("minecraft", "block.grass.fall"))))
                    .strength(0.5F, 5.0F)
                    .randomTicks(), ManagementWantedModBlocks.FAZ_HILLS_DIRT));
    }

    @Redirect(method = "<clinit>", at = @At(value = "INVOKE", target = "Lnet/minecraftforge/registries/DeferredRegister;register(Ljava/lang/String;Ljava/util/function/Supplier;)Lnet/minecraftforge/registries/RegistryObject;", ordinal = 503))
    private static RegistryObject<Block> unfuckChoppyGrass(DeferredRegister<Block> instance, String s, Supplier<? extends Block> name) {
        UselessTweaks.LOGGER.info("Replacing MW {} block!", s);
        return instance.register(s,
            () -> new FazHillsGrassBlockNew(
                BlockBehaviour.Properties.of()
                    .mapColor(MapColor.GRASS)
                    .sound(new ForgeSoundType(1.0F, 1.0F,
                        () -> ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.fromNamespaceAndPath("minecraft", "block.grass.break")),
                        () -> ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.fromNamespaceAndPath("minecraft", "block.grass.step")),
                        () -> ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.fromNamespaceAndPath("minecraft", "block.grass.place")),
                        () -> ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.fromNamespaceAndPath("minecraft", "block.grass.hit")),
                        () -> ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.fromNamespaceAndPath("minecraft", "block.grass.fall")))).strength(0.5F, 5.0F)
                    .randomTicks(), ManagementWantedModBlocks.FAZ_HILLS_DIRT));
    }

    @Redirect(method = "<clinit>", at = @At(value = "INVOKE", target = "Lnet/minecraftforge/registries/DeferredRegister;register(Ljava/lang/String;Ljava/util/function/Supplier;)Lnet/minecraftforge/registries/RegistryObject;", ordinal = 504))
    private static RegistryObject<Block> unfuckDustingGrass(DeferredRegister<Block> instance, String s, Supplier<? extends Block> name) {
        UselessTweaks.LOGGER.info("Replacing MW {} block!", s);
        return instance.register(s,
            () -> new FazHillsGrassBlockNew(
                BlockBehaviour.Properties.of()
                    .mapColor(MapColor.GRASS)
                    .sound(new ForgeSoundType(1.0F, 1.0F,
                        () -> ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.fromNamespaceAndPath("minecraft", "block.grass.break")),
                        () -> ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.fromNamespaceAndPath("minecraft", "block.grass.step")),
                        () -> ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.fromNamespaceAndPath("minecraft", "block.grass.place")),
                        () -> ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.fromNamespaceAndPath("minecraft", "block.grass.hit")),
                        () -> ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.fromNamespaceAndPath("minecraft", "block.grass.fall"))))
                    .strength(0.5F, 5.0F)
                    .randomTicks(), ManagementWantedModBlocks.DUSTING_DIRT));
    }

    @Redirect(method = "<clinit>", at = @At(value = "INVOKE", target = "Lnet/minecraftforge/registries/DeferredRegister;register(Ljava/lang/String;Ljava/util/function/Supplier;)Lnet/minecraftforge/registries/RegistryObject;", ordinal = 1201))
    private static RegistryObject<Block> unfuckBlacktombGrass(DeferredRegister<Block> instance, String s, Supplier<? extends Block> name) {
        UselessTweaks.LOGGER.info("Replacing MW {} block!", s);
        return instance.register(s,
            () -> new FazHillsGrassBlockNew(
                BlockBehaviour.Properties.of()
                    .mapColor(MapColor.GRASS)
                    .sound(new ForgeSoundType(1.0F, 1.0F,
                        () -> ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.fromNamespaceAndPath("minecraft", "block.grass.break")),
                        () -> ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.fromNamespaceAndPath("minecraft", "block.grass.step")),
                        () -> ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.fromNamespaceAndPath("minecraft", "block.grass.place")),
                        () -> ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.fromNamespaceAndPath("minecraft", "block.grass.hit")),
                        () -> ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.fromNamespaceAndPath("minecraft", "block.grass.fall"))))
                    .strength(0.5F, 5.0F)
                    .randomTicks(), ManagementWantedModBlocks.BLACK_TOMB_DIRT));
    }

    @Redirect(method = "<clinit>", at = @At(value = "INVOKE", target = "Lnet/minecraftforge/registries/DeferredRegister;register(Ljava/lang/String;Ljava/util/function/Supplier;)Lnet/minecraftforge/registries/RegistryObject;", ordinal = 1335))
    private static RegistryObject<Block> unfuckFlipSideGrass(DeferredRegister<Block> instance, String s, Supplier<? extends Block> name) {
        UselessTweaks.LOGGER.info("Replacing MW {} block!", s);
        return instance.register(s,
            () -> new FazHillsGrassBlockNew(
                BlockBehaviour.Properties.of()
                    .mapColor(MapColor.GRASS)
                    .sound(new ForgeSoundType(1.0F, 1.0F,
                        () -> ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.fromNamespaceAndPath("minecraft", "block.grass.break")),
                        () -> ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.fromNamespaceAndPath("minecraft", "block.grass.step")),
                        () -> ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.fromNamespaceAndPath("minecraft", "block.grass.place")),
                        () -> ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.fromNamespaceAndPath("minecraft", "block.grass.hit")),
                        () -> ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.fromNamespaceAndPath("minecraft", "block.grass.fall"))))
                    .strength(0.5F, 5.0F)
                    .randomTicks(), ManagementWantedModBlocks.FLIPSIDE_DIRT));
    }
}

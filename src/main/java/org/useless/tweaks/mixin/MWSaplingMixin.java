package org.useless.tweaks.mixin;

import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.grower.AbstractMegaTreeGrower;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.ovdrstudios.mw.ManagementWantedMod;
import net.ovdrstudios.mw.block.FazHillsSaplingBlock;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.function.Supplier;

@Mixin(value = FazHillsSaplingBlock.class, remap = false)
public class MWSaplingMixin extends FlowerBlock {
    @Unique
    private static final float AABB_OFFSET = 6.0F;
    @Unique
    private static final VoxelShape SHAPE = Block.box(2.0D, 0.0D, 2.0D, 14.0D, 12.0D, 14.0D);

    @Unique
    private static final ResourceKey<ConfiguredFeature<?, ?>> FAZ_HILLS_TREE = ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(ManagementWantedMod.MODID, "faz_trees_plain"));
    private static final ResourceKey<ConfiguredFeature<?, ?>> FAZ_HILLS_TREE_MEGA = ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(ManagementWantedMod.MODID, "fazbear_hills_tree"));
    @Unique
    private static final AbstractTreeGrower treeGrower = new AbstractMegaTreeGrower() {
        @Override
        protected @Nullable ResourceKey<ConfiguredFeature<?, ?>> getConfiguredMegaFeature(RandomSource p_222904_) {
            return FAZ_HILLS_TREE_MEGA;
        }

        @Override
        protected @Nullable ResourceKey<ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource p_222910_, boolean p_222911_) {
            return FAZ_HILLS_TREE;
        }

    };

    public MWSaplingMixin(Supplier<MobEffect> effectSupplier, int p_53513_, Properties p_53514_) {
        super(effectSupplier, p_53513_, p_53514_);
    }


    @Inject(method = "<init>", at = @At("TAIL"))
    public void init(CallbackInfo ci) {
        this.registerDefaultState(this.stateDefinition.any().setValue(SaplingBlock.STAGE, Integer.valueOf(0)));
    }

    @Override
    public VoxelShape getShape(BlockState p_56008_, BlockGetter p_56009_, BlockPos p_56010_, CollisionContext p_56011_) {
        return SHAPE;
    }

    @Override
    public void randomTick(BlockState p_222011_, ServerLevel p_222012_, BlockPos p_222013_, RandomSource p_222014_) {
        if (!p_222012_.isAreaLoaded(p_222013_, 1)) return; // Forge: prevent loading unloaded chunks when checking neighbor's light
        if (p_222012_.getMaxLocalRawBrightness(p_222013_.above()) >= 9 && p_222014_.nextInt(7) == 0) {
            this.advanceTree(p_222012_, p_222013_, p_222011_, p_222014_);
        }

    }

    public void advanceTree(ServerLevel p_222001_, BlockPos p_222002_, BlockState p_222003_, RandomSource p_222004_) {
        if (p_222003_.getValue(SaplingBlock.STAGE) == 0) {
            p_222001_.setBlock(p_222002_, p_222003_.cycle(SaplingBlock.STAGE), 4);
        } else {
            treeGrower.growTree(p_222001_, p_222001_.getChunkSource().getGenerator(), p_222002_, p_222003_, p_222004_);
        }

    }

    /**
     * @author Useless
     * @reason Making saplings real
     */
    @Overwrite
    public boolean isBonemealSuccess(Level p_222006_, RandomSource p_222007_, BlockPos p_222008_, BlockState p_222009_) {
        return (double)p_222006_.random.nextFloat() < 0.45D;
    }

    @Inject(method = "performBonemeal", at = @At("HEAD"))
    public void makeSaplingsActuallyWork(ServerLevel world, RandomSource random, BlockPos pos, BlockState blockstate, CallbackInfo ci) {
        this.advanceTree(world, pos, blockstate, random);
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> p_56001_) {
        p_56001_.add(SaplingBlock.STAGE);
    }


}

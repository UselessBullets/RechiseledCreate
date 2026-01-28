package org.useless.tweaks.mixin;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;
import net.ovdrstudios.mw.block.FazHillsLeafBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(value = FazHillsLeafBlock.class, remap = false)
public class MWFazHillsLeavesMixin extends LeavesBlock {
    public MWFazHillsLeavesMixin(Properties p_54422_) {
        super(p_54422_);
    }

    /**
     * @author Useless
     * @reason MW incompetent procedure replaces actually normal game code with dogshit
     */
    @Overwrite
    public boolean onDestroyedByPlayer(BlockState blockstate, Level world, BlockPos pos, Player entity, boolean willHarvest, FluidState fluid) {
        return super.onDestroyedByPlayer(blockstate, world, pos, entity, willHarvest, fluid);
    }
}

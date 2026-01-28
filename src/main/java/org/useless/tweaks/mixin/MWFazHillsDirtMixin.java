package org.useless.tweaks.mixin;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.ovdrstudios.mw.init.ManagementWantedModBlocks;
import net.ovdrstudios.mw.procedures.FazHillsDirtOnTickUpdateProcedure;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(value = FazHillsDirtOnTickUpdateProcedure.class, remap = false)
public class MWFazHillsDirtMixin {
    /**
     * @author Useless
     * @reason Faz dirt cannot become choppy grass normally
     */
    @Overwrite
    public static void execute(LevelAccessor world, double x, double y, double z) {
        if (world.isEmptyBlock(BlockPos.containing(x, y + 1, z))) {

            boolean canHillGrass = false;
            boolean canChoppyGrass = false;

            for (int _x = -1; _x <= 1; _x++) {
                for (int _y = -1; _y <= 1; _y++) {
                    for (int _z = -1; _z <= 1; _z++) {
                        var state = world.getBlockState(BlockPos.containing(x + _x, y + _y, z + _z)).getBlock();
                        canHillGrass |= state == ManagementWantedModBlocks.FAZ_HILLS_GRASS.get();
                        canChoppyGrass |= state == ManagementWantedModBlocks.CHOPPY_GRASS.get();
                    }
                }
            }



            if (canHillGrass && canChoppyGrass) {
                world.setBlock(BlockPos.containing(x, y, z), world.getRandom().nextInt(2) == 0 ? ManagementWantedModBlocks.FAZ_HILLS_GRASS.get().defaultBlockState() : ManagementWantedModBlocks.CHOPPY_GRASS.get().defaultBlockState(), 3);
            } else if (canHillGrass) {
                world.setBlock(BlockPos.containing(x, y, z), ManagementWantedModBlocks.FAZ_HILLS_GRASS.get().defaultBlockState(), 3);
            } else if (canChoppyGrass) {
                world.setBlock(BlockPos.containing(x, y, z), ManagementWantedModBlocks.CHOPPY_GRASS.get().defaultBlockState(), 3);
            }
        }

    }
}

package org.useless.rechiseled.mw;

import com.supermartijn642.rechiseled.Rechiseled;
import net.minecraft.resources.ResourceLocation;

public class Recipes {
    public static final ResourceLocation AMETHYST_BLOCK = location("amethyst_block");


    private static ResourceLocation location(String name){
        return Rechiseled.identifier(name);
    }
}

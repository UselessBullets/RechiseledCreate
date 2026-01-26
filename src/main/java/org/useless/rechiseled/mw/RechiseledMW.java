package org.useless.rechiseled.mw;

import com.supermartijn642.rechiseled.api.registration.RechiseledRegistration;
import net.minecraftforge.fml.common.Mod;

@Mod(RechiseledMW.MODID)
public class RechiseledMW {

    public static final String MODID = "rechiseledmw";
    public static final RechiseledRegistration REGISTRATION = RechiseledRegistration.get(MODID);

    public RechiseledMW(){
        // Make sure the blocks get loaded
//        ChiselingConversionHelper.convert(1, M)

        // Register data providers for generating all the json files
        REGISTRATION.registerDataProviders();
    }

}

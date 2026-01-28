package org.useless.tweaks;

import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.LanguageProvider;

public class UselessLanguageProvider extends LanguageProvider {
    public UselessLanguageProvider(PackOutput output, String modid, String locale) {
        super(output, modid, locale);
    }

    @Override
    protected void addTranslations() {
//        this.add(UselessTweaks.CHOPPY_SAPLING.get(), "Choppy Sapling");
    }
}

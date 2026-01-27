package org.useless.tweaks;

import com.mojang.logging.LogUtils;
import com.simibubi.create.foundation.data.CreateRegistrate;
import com.supermartijn642.rechiseled.api.registration.RechiseledRegistration;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegisterEvent;
import net.minecraftforge.registries.RegistryObject;
import org.slf4j.Logger;

@Mod(UselessTweaks.MODID)
public class UselessTweaks {
    public static final String MODID = "uselesstweaks";
    public static final Logger LOGGER = LogUtils.getLogger();
    public static final RechiseledRegistration RECHISELED_REGISTRATION = RechiseledRegistration.get(MODID);
    public static final CreateRegistrate CREATE_REGISTRATION = CreateRegistrate.create(MODID);

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);

    public static final RegistryObject<Item> ASSORTED_DYE = ITEMS.register("assorted_dye", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> PAPER_STARS = ITEMS.register("paper_stars", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> PAPER_PEOPLE = ITEMS.register("paper_people", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> FLUFF = ITEMS.register("fluff", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> UNTREATED_FELT = ITEMS.register("untreated_felt", () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> RED_FELT = ITEMS.register("red_felt", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ORANGE_FELT = ITEMS.register("orange_felt", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> YELLOW_FELT = ITEMS.register("yellow_felt", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> BLUE_FELT = ITEMS.register("blue_felt", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> GREEN_FELT = ITEMS.register("green_felt", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> LIME_FELT = ITEMS.register("lime_felt", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> LIGHT_BLUE_FELT = ITEMS.register("light_blue_felt", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> LIGHT_GRAY_FELT = ITEMS.register("light_gray_felt", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> GRAY_FELT = ITEMS.register("gray_felt", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> BLACK_FELT = ITEMS.register("black_felt", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> WHITE_FELT = ITEMS.register("white_felt", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> PURPLE_FELT = ITEMS.register("purple_felt", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> MAGENTA_FELT = ITEMS.register("magenta_felt", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> BROWN_FELT = ITEMS.register("brown_felt", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> CYAN_FELT = ITEMS.register("cyan_felt", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> PINK_FELT = ITEMS.register("pink_felt", () -> new Item(new Item.Properties()));

    public UselessTweaks(){
        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        modEventBus.addListener(this::setup);
        modEventBus.addListener(this::creativeTabs);
        ITEMS.register(modEventBus);

        MinecraftForge.EVENT_BUS.register(this);

        // Make sure the blocks get loaded
//        ChiselingConversionHelper.convert(1, M)

        // Register data providers for generating all the json files
        RECHISELED_REGISTRATION.registerDataProviders();
        Recipes.init();


    }

    private void setup(RegisterEvent event) {

    }

    @SubscribeEvent
    public void creativeTabs(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            event.accept(ASSORTED_DYE);
            event.accept(PAPER_STARS);
            event.accept(PAPER_PEOPLE);
            event.accept(FLUFF);
            event.accept(UNTREATED_FELT);
            event.accept(RED_FELT);
            event.accept(ORANGE_FELT);
            event.accept(YELLOW_FELT);
            event.accept(BLUE_FELT);
            event.accept(GREEN_FELT);
            event.accept(LIME_FELT);
            event.accept(LIGHT_BLUE_FELT);
            event.accept(LIGHT_GRAY_FELT);
            event.accept(GRAY_FELT);
            event.accept(BLACK_FELT);
            event.accept(WHITE_FELT);
            event.accept(PURPLE_FELT);
            event.accept(MAGENTA_FELT);
            event.accept(BROWN_FELT);
            event.accept(CYAN_FELT);
            event.accept(PINK_FELT);
        }
    }
}

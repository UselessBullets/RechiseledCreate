package org.useless.rechiseled.mw;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.ItemLike;
import com.supermartijn642.core.registry.Registries;

import java.util.function.Supplier;

import static org.useless.rechiseled.mw.RechiseledMW.REGISTRATION;

public class Recipes {
    public static final ResourceLocation FREDDY_TILES = location("freddy_tiles");
    public static final ResourceLocation FREDDY_CURTAINS = location("freddy_curtains");
    public static final ResourceLocation FREDDY_CARPET = location("freddy_carpet");
    public static final ResourceLocation FREDDY_TABLES = location("freddy_tables");
    public static final ResourceLocation FREDDY_AWNINGS = location("freddy_awnings");
    public static final ResourceLocation FREDDY_MASSIVE_DOORS = location("freddy_massive_doors");
    public static final ResourceLocation FREDDY_BIG_DOORS = location("freddy_big_doors");
    public static final ResourceLocation FREDDY_BLAST_DOORS = location("freddy_blast_doors");
    public static final ResourceLocation FREDDY_SMALL_DOORS = location("freddy_small_doors");
    public static final ResourceLocation FREDDY_STAGES = location("freddy_stages");
    public static final ResourceLocation FREDDY_STAGE_LIGHTS = location("freddy_stage_lights");
    public static final ResourceLocation FREDDY_LIGHTS = location("freddy_lights");
    public static final ResourceLocation FREDDY_WALLS = location("freddy_walls");


    private static ResourceLocation location(String name){
        return new ResourceLocation(RechiseledMW.MODID, name);
    }

    private static Supplier<ItemLike> getBlock(String identifier){
        ResourceLocation location = new ResourceLocation(identifier);
        return () -> {
            if(!Registries.BLOCKS.hasIdentifier(location))
                throw new RuntimeException("Unknown block '" + identifier + "'!");
            return Registries.BLOCKS.getValue(location);
        };
    }

    public static void init() {
        // MW Tile conversions
        regularSet(FREDDY_TILES, "management_wanted:tile", "management_wanted:tile_stairs", "management_wanted:tile_slabs");
        regularBlockOnly(FREDDY_TILES, "management_wanted:confetti_tile");
        regularBlockOnly(FREDDY_TILES, "management_wanted:ruined_white_black_tiles");
        regularSet(FREDDY_TILES, "management_wanted:wall_tiles", "management_wanted:wall_tiles_stairs", "management_wanted:wall_tiles_slabs");
        regularSet(FREDDY_TILES, "management_wanted:blue_black_tiles", "management_wanted:blue_black_tiles_stairs", "management_wanted:blue_black_tiles_slabs");
        regularSet(FREDDY_TILES, "management_wanted:blue_red_tiles", "management_wanted:blue_red_tiles_stairs", "management_wanted:blue_red_tiles_slabs");
        regularSet(FREDDY_TILES, "management_wanted:white_red_tiles", "management_wanted:white_red_tiles_stairs", "management_wanted:white_red_tiles_slabs");
        regularSet(FREDDY_TILES, "management_wanted:black_red_tiles", "management_wanted:black_red_tiles_stairs", "management_wanted:black_red_tiles_slabs");
        regularSet(FREDDY_TILES, "management_wanted:black_green_tiles", "management_wanted:black_green_tiles_stairs", "management_wanted:black_green_tiles_slabs");
        regularSet(FREDDY_TILES, "management_wanted:green_blue_tiles", "management_wanted:green_blue_tiles_stairs", "management_wanted:green_blue_tiles_slabs");
        regularSet(FREDDY_TILES, "management_wanted:lol_tiles", "management_wanted:lol_tiles_stairs", "management_wanted:lol_tiles_slabs");
        regularSet(FREDDY_TILES, "management_wanted:err_tiles", "management_wanted:err_tiles_stairs", "management_wanted:err_tiles_slabs");
        regularSet(FREDDY_TILES, "management_wanted:orange_teal_tile", "management_wanted:orange_teal_tiles_stairs", "management_wanted:orange_teal_tiles_slabs");
        regularBlockOnly(FREDDY_TILES, "management_wanted:fright_tiles");
        regularSet(FREDDY_TILES, "management_wanted:lime_black_small_tiles", "management_wanted:lime_black_small_tiles_stairs", "management_wanted:lime_black_small_tiles_slabs");
        regularBlockOnly(FREDDY_TILES, "management_wanted:fright_wall_tiles");
        regularBlockOnly(FREDDY_TILES, "management_wanted:lime_fright_flooring");
        regularBlockOnly(FREDDY_TILES, "management_wanted:scooper_floor");
        regularBlockOnly(FREDDY_TILES, "management_wanted:dirty_fright_wall_tiles");
        regularBlockOnly(FREDDY_TILES, "management_wanted:outside_fright_wall");
        regularBlockOnly(FREDDY_TILES, "management_wanted:white_tile");
        regularBlockOnly(FREDDY_TILES, "management_wanted:sl_tile");
        regularBlockOnly(FREDDY_TILES, "management_wanted:sl_tile_green");
        regularBlockOnly(FREDDY_TILES, "management_wanted:rewritten_backroom_tile");
        regularBlockOnly(FREDDY_TILES, "management_wanted:rewritten_gray_black_tile");
        regularBlockOnly(FREDDY_TILES, "management_wanted:black_tomb_tiles");

        // MW Curtain conversions
        regularBlockOnly(FREDDY_CURTAINS, "management_wanted:purple_curtain");
        regularBlockOnly(FREDDY_CURTAINS, "management_wanted:purple_curtain_stars");
        regularBlockOnly(FREDDY_CURTAINS, "management_wanted:purple_curtain_trim");
        regularBlockOnly(FREDDY_CURTAINS, "management_wanted:purple_curtain_yellow_stars");
        regularBlockOnly(FREDDY_CURTAINS, "management_wanted:purple_curtain_yellow_trim");

        regularBlockOnly(FREDDY_CURTAINS, "management_wanted:red_curtain");
        regularBlockOnly(FREDDY_CURTAINS, "management_wanted:red_curtain_stars");
        regularBlockOnly(FREDDY_CURTAINS, "management_wanted:red_curtain_trim");
        regularBlockOnly(FREDDY_CURTAINS, "management_wanted:bag_curtain_trim");

        regularBlockOnly(FREDDY_CURTAINS, "management_wanted:blue_curtain");
        regularBlockOnly(FREDDY_CURTAINS, "management_wanted:blue_curtain_stars");
        regularBlockOnly(FREDDY_CURTAINS, "management_wanted:blue_curtain_trim");

        regularBlockOnly(FREDDY_CURTAINS, "management_wanted:green_curtain");
        regularBlockOnly(FREDDY_CURTAINS, "management_wanted:green_curtain_stars");
        regularBlockOnly(FREDDY_CURTAINS, "management_wanted:green_curtain_trim");

        regularBlockOnly(FREDDY_CURTAINS, "management_wanted:lime_curtain");
        regularBlockOnly(FREDDY_CURTAINS, "management_wanted:lime_curtain_stars");
        regularBlockOnly(FREDDY_CURTAINS, "management_wanted:lime_curtain_trim");

        regularBlockOnly(FREDDY_CURTAINS, "management_wanted:orange_curtain");
        regularBlockOnly(FREDDY_CURTAINS, "management_wanted:orange_curtain_stars");
        regularBlockOnly(FREDDY_CURTAINS, "management_wanted:orange_curtain_trim");

        regularBlockOnly(FREDDY_CURTAINS, "management_wanted:yellow_curtain");
        regularBlockOnly(FREDDY_CURTAINS, "management_wanted:yellow_curtain_stars");
        regularBlockOnly(FREDDY_CURTAINS, "management_wanted:yellow_curtain_trim");

        regularBlockOnly(FREDDY_CURTAINS, "management_wanted:cyan_curtain");
        regularBlockOnly(FREDDY_CURTAINS, "management_wanted:cyan_curtain_stars");
        regularBlockOnly(FREDDY_CURTAINS, "management_wanted:cyan_curtain_trim");

        regularBlockOnly(FREDDY_CURTAINS, "management_wanted:light_blue_curtain");
        regularBlockOnly(FREDDY_CURTAINS, "management_wanted:light_blue_curtain_stars");
        regularBlockOnly(FREDDY_CURTAINS, "management_wanted:light_blue_curtain_trim");

        regularBlockOnly(FREDDY_CURTAINS, "management_wanted:pink_curtain");
        regularBlockOnly(FREDDY_CURTAINS, "management_wanted:pink_curtain_stars");
        regularBlockOnly(FREDDY_CURTAINS, "management_wanted:pink_curtain_trim");

        regularBlockOnly(FREDDY_CURTAINS, "management_wanted:magenta_curtain");
        regularBlockOnly(FREDDY_CURTAINS, "management_wanted:magenta_curtain_stars");
        regularBlockOnly(FREDDY_CURTAINS, "management_wanted:magenta_curtain_trim");

        regularBlockOnly(FREDDY_CURTAINS, "management_wanted:brown_curtain");
        regularBlockOnly(FREDDY_CURTAINS, "management_wanted:brown_curtain_stars");
        regularBlockOnly(FREDDY_CURTAINS, "management_wanted:brown_curtain_trim");

        regularBlockOnly(FREDDY_CURTAINS, "management_wanted:light_gray_curtain");
        regularBlockOnly(FREDDY_CURTAINS, "management_wanted:light_gray_curtain_stars");
        regularBlockOnly(FREDDY_CURTAINS, "management_wanted:light_gray_curtain_trim");

        regularBlockOnly(FREDDY_CURTAINS, "management_wanted:gray_curtain");
        regularBlockOnly(FREDDY_CURTAINS, "management_wanted:gray_curtain_stars");
        regularBlockOnly(FREDDY_CURTAINS, "management_wanted:gray_curtain_trim");

        regularBlockOnly(FREDDY_CURTAINS, "management_wanted:black_curtain");
        regularBlockOnly(FREDDY_CURTAINS, "management_wanted:black_curtain_stars");
        regularBlockOnly(FREDDY_CURTAINS, "management_wanted:black_curtain_trim");

        regularBlockOnly(FREDDY_CURTAINS, "management_wanted:white_curtain");

        regularBlockOnly(FREDDY_CURTAINS, "management_wanted:jeffs_curtain");
        regularBlockOnly(FREDDY_CURTAINS, "management_wanted:jeffs_curtain_stars");
        regularBlockOnly(FREDDY_CURTAINS, "management_wanted:jeffs_curtain_trim");

        // MW Carpet Conversions
        regularSet(FREDDY_CARPET, "management_wanted:arcade_carpet_mixed", "management_wanted:arcade_carpet_mixed_stairs", "management_wanted:arcade_carpet_mixed_slabs");
        regularSet(FREDDY_CARPET, "management_wanted:arcade_carpet_blue", "management_wanted:arcade_carpet_blue_stairs", "management_wanted:arcade_carpet_blue_slabs");
        regularSet(FREDDY_CARPET, "management_wanted:arcade_carpet_green", "management_wanted:arcade_carpet_green_stairs", "management_wanted:arcade_carpet_green_slabs");
        regularSet(FREDDY_CARPET, "management_wanted:arcade_carpet_red", "management_wanted:arcade_carpet_red_stairs", "management_wanted:arcade_carpet_red_slabs");
        regularSet(FREDDY_CARPET, "management_wanted:fredbear_carpet", "management_wanted:fredbear_carpet_stairs", "management_wanted:fredbear_carpet_slab");
        regularSet(FREDDY_CARPET, "management_wanted:bedroom_carpet", "management_wanted:bedroom_carpet_stairs", "management_wanted:bedroom_carpet_slab");
        regularBlockOnly(FREDDY_CARPET, "management_wanted:bedroom_blanket");

        // MW Table Conversions
        regularBlockOnly(FREDDY_TABLES, "management_wanted:party_table_single");
        regularBlockOnly(FREDDY_TABLES, "management_wanted:pink_striped_table_single");
        regularBlockOnly(FREDDY_TABLES, "management_wanted:purple_striped_table_single");
        regularBlockOnly(FREDDY_TABLES, "management_wanted:red_checkered_table_single");
        regularBlockOnly(FREDDY_TABLES, "management_wanted:table_party");

        regularBlockOnly(FREDDY_TABLES, "management_wanted:table_fnaf_2_striped_purple");
        regularBlockOnly(FREDDY_TABLES, "management_wanted:table_fnaf_2_striped_pink");
        regularBlockOnly(FREDDY_TABLES, "management_wanted:table_striped_white");
        regularBlockOnly(FREDDY_TABLES, "management_wanted:table_striped_gray");
        regularBlockOnly(FREDDY_TABLES, "management_wanted:table_striped_black");
        regularBlockOnly(FREDDY_TABLES, "management_wanted:table_striped_light_gray");
        regularBlockOnly(FREDDY_TABLES, "management_wanted:table_striped_magenta");
        regularBlockOnly(FREDDY_TABLES, "management_wanted:table_striped_purple");
        regularBlockOnly(FREDDY_TABLES, "management_wanted:table_striped_yellow");
        regularBlockOnly(FREDDY_TABLES, "management_wanted:table_striped_orange");
        regularBlockOnly(FREDDY_TABLES, "management_wanted:table_striped_brown");
        regularBlockOnly(FREDDY_TABLES, "management_wanted:table_striped_light_blue");
        regularBlockOnly(FREDDY_TABLES, "management_wanted:table_striped_cyan");
        regularBlockOnly(FREDDY_TABLES, "management_wanted:table_striped_blue");
        regularBlockOnly(FREDDY_TABLES, "management_wanted:table_striped_red");
        regularBlockOnly(FREDDY_TABLES, "management_wanted:table_striped_lime");
        regularBlockOnly(FREDDY_TABLES, "management_wanted:table_striped_green");
        regularBlockOnly(FREDDY_TABLES, "management_wanted:table_striped_pink");
        regularBlockOnly(FREDDY_TABLES, "management_wanted:table_checkered_white");
        regularBlockOnly(FREDDY_TABLES, "management_wanted:table_checkered_gray");
        regularBlockOnly(FREDDY_TABLES, "management_wanted:table_checkered_light_gray");
        regularBlockOnly(FREDDY_TABLES, "management_wanted:table_checkered_black");
        regularBlockOnly(FREDDY_TABLES, "management_wanted:table_checkered_magenta");
        regularBlockOnly(FREDDY_TABLES, "management_wanted:table_checkered_purple");
        regularBlockOnly(FREDDY_TABLES, "management_wanted:table_checkered_yellow");
        regularBlockOnly(FREDDY_TABLES, "management_wanted:table_checkered_orange");
        regularBlockOnly(FREDDY_TABLES, "management_wanted:table_checkered_brown");
        regularBlockOnly(FREDDY_TABLES, "management_wanted:table_checkered_light_blue");
        regularBlockOnly(FREDDY_TABLES, "management_wanted:table_checkered_blue");
        regularBlockOnly(FREDDY_TABLES, "management_wanted:table_checkered_cyan");
        regularBlockOnly(FREDDY_TABLES, "management_wanted:table_checkered_red");
        regularBlockOnly(FREDDY_TABLES, "management_wanted:table_checkered_lime");
        regularBlockOnly(FREDDY_TABLES, "management_wanted:table_checkered_green");
        regularBlockOnly(FREDDY_TABLES, "management_wanted:table_checkered_pink");
        regularBlockOnly(FREDDY_TABLES, "management_wanted:backstage_table_single");
        regularBlockOnly(FREDDY_TABLES, "management_wanted:wood_table_single");

        // MW Entrance Doors
        regularBlockOnly(FREDDY_MASSIVE_DOORS, "management_wanted:big_entrance_door");
        regularBlockOnly(FREDDY_MASSIVE_DOORS, "management_wanted:big_entrance_door_black");
        regularBlockOnly(FREDDY_MASSIVE_DOORS, "management_wanted:big_entrance_door_blue");
        regularBlockOnly(FREDDY_MASSIVE_DOORS, "management_wanted:big_entrance_door_brown");
        regularBlockOnly(FREDDY_MASSIVE_DOORS, "management_wanted:big_entrance_door_cyan");
        regularBlockOnly(FREDDY_MASSIVE_DOORS, "management_wanted:big_entrance_door_gray");
        regularBlockOnly(FREDDY_MASSIVE_DOORS, "management_wanted:big_entrance_door_light_blue");
        regularBlockOnly(FREDDY_MASSIVE_DOORS, "management_wanted:big_entrance_door_light_gray");
        regularBlockOnly(FREDDY_MASSIVE_DOORS, "management_wanted:big_entrance_door_green");
        regularBlockOnly(FREDDY_MASSIVE_DOORS, "management_wanted:big_entrance_door_lime");
        regularBlockOnly(FREDDY_MASSIVE_DOORS, "management_wanted:big_entrance_door_magenta");
        regularBlockOnly(FREDDY_MASSIVE_DOORS, "management_wanted:big_entrance_door_orange");
        regularBlockOnly(FREDDY_MASSIVE_DOORS, "management_wanted:big_entrance_door_pink");
        regularBlockOnly(FREDDY_MASSIVE_DOORS, "management_wanted:big_entrance_door_purple");
        regularBlockOnly(FREDDY_MASSIVE_DOORS, "management_wanted:big_entrance_door_yellow");
        regularBlockOnly(FREDDY_MASSIVE_DOORS, "management_wanted:big_kitchen_pushdoor");
        regularBlockOnly(FREDDY_MASSIVE_DOORS, "management_wanted:big_diner_pushdoor");

        // MW Big Doors
        regularBlockOnly(FREDDY_BIG_DOORS, "management_wanted:backstage_door");
        regularBlockOnly(FREDDY_BIG_DOORS, "management_wanted:parts_service_door");
        regularBlockOnly(FREDDY_BIG_DOORS, "management_wanted:big_exit_door");
        regularBlockOnly(FREDDY_BIG_DOORS, "management_wanted:big_red_exit_door");
        regularBlockOnly(FREDDY_BIG_DOORS, "management_wanted:big_closet_door");
        regularBlockOnly(FREDDY_BIG_DOORS, "management_wanted:big_bedroom_door_right");
        regularBlockOnly(FREDDY_BIG_DOORS, "management_wanted:big_bedroom_door_left");
        regularBlockOnly(FREDDY_BIG_DOORS, "management_wanted:small_closet_door");
        regularBlockOnly(FREDDY_BIG_DOORS, "management_wanted:fnafsl_door");

        // MW Blast Doors
        regularBlockOnly(FREDDY_BLAST_DOORS, "management_wanted:vent_door");
        regularBlockOnly(FREDDY_BLAST_DOORS, "management_wanted:blastdoor");
        regularBlockOnly(FREDDY_BLAST_DOORS, "management_wanted:deluxe_blast_door");
        regularBlockOnly(FREDDY_BLAST_DOORS, "management_wanted:window_blastdoor");

        // MW Small Doors
        regularBlockOnly(FREDDY_SMALL_DOORS, "management_wanted:pizzeria_door");
        regularBlockOnly(FREDDY_SMALL_DOORS, "management_wanted:staff_door");
        regularBlockOnly(FREDDY_SMALL_DOORS, "management_wanted:kitchen_door");
        regularBlockOnly(FREDDY_SMALL_DOORS, "management_wanted:bedroom_door");
        regularBlockOnly(FREDDY_SMALL_DOORS, "management_wanted:teal_door");
        regularBlockOnly(FREDDY_SMALL_DOORS, "management_wanted:teal_employee_door");
        regularBlockOnly(FREDDY_SMALL_DOORS, "management_wanted:exit_door");
        regularBlockOnly(FREDDY_SMALL_DOORS, "management_wanted:exit_door_red");
        regularBlockOnly(FREDDY_SMALL_DOORS, "management_wanted:jeffs_door");

        // MW Awnings
        regularBlockOnly(FREDDY_AWNINGS, "management_wanted:awning_green");
        regularBlockOnly(FREDDY_AWNINGS, "management_wanted:awning_purple");
        regularBlockOnly(FREDDY_AWNINGS, "management_wanted:awning_blue");
        regularBlockOnly(FREDDY_AWNINGS, "management_wanted:awning_white");
        regularBlockOnly(FREDDY_AWNINGS, "management_wanted:awning_bag");
        regularBlockOnly(FREDDY_AWNINGS, "management_wanted:awning_red");

        // MW Stages
        regularBlockOnly(FREDDY_STAGES, "management_wanted:stage_block");
        regularBlockOnly(FREDDY_STAGES, "management_wanted:deluxe_stage_block");
        regularBlockOnly(FREDDY_STAGES, "management_wanted:deluxe_side_stage_block");
        regularBlockOnly(FREDDY_STAGES, "management_wanted:moderate_stage");
        regularBlockOnly(FREDDY_STAGES, "management_wanted:checkered_stage");

        // MW Stage Lights
        regularBlockOnly(FREDDY_STAGE_LIGHTS, "management_wanted:stage_lights_blue");
        regularBlockOnly(FREDDY_STAGE_LIGHTS, "management_wanted:stage_lights_green");
        regularBlockOnly(FREDDY_STAGE_LIGHTS, "management_wanted:stage_lights_pink");
        regularBlockOnly(FREDDY_STAGE_LIGHTS, "management_wanted:stage_lights_orange");
        regularBlockOnly(FREDDY_STAGE_LIGHTS, "management_wanted:deluxe_stage_light");
        regularBlockOnly(FREDDY_STAGE_LIGHTS, "management_wanted:frightlight");

        // MW Lights
        regularBlockOnly(FREDDY_LIGHTS, "management_wanted:deluxe_light");
        regularBlockOnly(FREDDY_LIGHTS, "management_wanted:normal_light");
        regularBlockOnly(FREDDY_LIGHTS, "management_wanted:wall_light");
        regularBlockOnly(FREDDY_LIGHTS, "management_wanted:wall_light_overhead");

        // MW Walls
        regularSet(FREDDY_WALLS, "management_wanted:stage_bricks_big", "management_wanted:stage_bricks_big_stairs", "management_wanted:stage_bricks_big_slab");
        regularSet(FREDDY_WALLS, "management_wanted:stage_bricks", "management_wanted:stage_bricks_stairs", "management_wanted:stage_bricks_slabs");
        regularSet(FREDDY_WALLS, "management_wanted:stage_brick_tiles", "management_wanted:stage_brick_tiles_stairs", "management_wanted:stage_brick_tiles_slabs");
        regularSet(FREDDY_WALLS, "management_wanted:kitchen_facade_wall", "management_wanted:kitchen_facade_wall_stairs", "management_wanted:kitchen_facade_wall_slab");
        regularBlockOnly(FREDDY_WALLS, "management_wanted:kitchen_facade_wall_tiled");
        regularBlockOnly(FREDDY_WALLS, "management_wanted:kitchen_tiles");
        regularSet(FREDDY_WALLS, "management_wanted:kitchen_bricks", "management_wanted:kitchen_bricks_stairs", "management_wanted:kitchen_bricks_slabs");
        regularSet(FREDDY_WALLS, "management_wanted:kitchen_bricks_big", "management_wanted:kitchen_bricks_big_stairs", "management_wanted:kitchen_bricks_big_slab");
        regularSet(FREDDY_WALLS, "management_wanted:utility_bricks", "management_wanted:utility_bricks_stairs", "management_wanted:utility_bricks_slabs");
        regularSet(FREDDY_WALLS, "management_wanted:lined_utility_bricks", "management_wanted:lined_utility_bricks_stairs", "management_wanted:lined_utility_bricks_slabs");
        regularSet(FREDDY_WALLS, "management_wanted:chiseled_utility_bricks", "management_wanted:chiseled_utility_bricks_stairs", "management_wanted:chiseled_utility_bricks_slabs");
        regularSet(FREDDY_WALLS, "management_wanted:chiseled_utility_bricks_alternate", "management_wanted:chiseled_utility_bricks_alternate_stairs", "management_wanted:chiseled_utility_bricks_alternate_slab");
        regularSet(FREDDY_WALLS, "management_wanted:light_facade_bricks_big", "management_wanted:light_facade_bricks_big_stairs", "management_wanted:light_facade_bricks_big_slab");
        regularSet(FREDDY_WALLS, "management_wanted:light_facade_bricks", "management_wanted:light_facade_brick_stairs", "management_wanted:light_facade_brick_slab");
        regularSet(FREDDY_WALLS, "management_wanted:light_facade_wall", "management_wanted:light_facade_wall_stairs", "management_wanted:light_facade_wall_slab");
        regularBlockOnly(FREDDY_WALLS, "management_wanted:utility_facade_wall_tiled");
        regularBlockOnly(FREDDY_WALLS, "management_wanted:tiled_light_facade_bricks");
        regularBlockOnly(FREDDY_WALLS, "management_wanted:tiled_light_facade_wall");
        regularBlockOnly(FREDDY_WALLS, "management_wanted:light_facade_bricks_big_tiled");
        regularSet(FREDDY_WALLS, "management_wanted:utility_facade_wall", "management_wanted:utility_facade_wall_stairs", "management_wanted:utility_facade_wall_slab");
        regularSet(FREDDY_WALLS, "management_wanted:dark_facade_bricks_big", "management_wanted:dark_facade_bricks_big_stairs", "management_wanted:dark_facade_bricks_big_slab");
        regularSet(FREDDY_WALLS, "management_wanted:dark_facade_bricks", "management_wanted:dark_facade_brick_stairs", "management_wanted:dark_facade_brick_slab");
        regularSet(FREDDY_WALLS, "management_wanted:dark_facade_wall", "management_wanted:dark_facade_wall_stairs", "management_wanted:dark_facade_wall_slab");
        regularBlockOnly(FREDDY_WALLS, "management_wanted:dark_facade_bricks_big_tiled");
        regularBlockOnly(FREDDY_WALLS, "management_wanted:dark_facade_bricks_tiled");
        regularBlockOnly(FREDDY_WALLS, "management_wanted:tiled_dark_facade_wall");
        regularSet(FREDDY_WALLS, "management_wanted:red_facade_bricks_big", "management_wanted:red_facade_bricks_big_stairs", "management_wanted:red_facade_bricks_big_slab");
        regularSet(FREDDY_WALLS, "management_wanted:red_facade_bricks", "management_wanted:red_facade_brick_stairs", "management_wanted:red_facade_brick_slab");
        regularSet(FREDDY_WALLS, "management_wanted:red_facade_wall", "management_wanted:red_facade_wall_stairs", "management_wanted:red_facade_wall_slab");
        regularBlockOnly(FREDDY_WALLS, "management_wanted:red_facade_bricks_big_tiled");
        regularBlockOnly(FREDDY_WALLS, "management_wanted:red_facade_bricks_tiled");
        regularBlockOnly(FREDDY_WALLS, "management_wanted:red_facade_wall_tiled");
        regularSet(FREDDY_WALLS, "management_wanted:green_facade_bricks_big", "management_wanted:green_facade_bricks_big_stairs", "management_wanted:green_facade_bricks_big_slab");
        regularSet(FREDDY_WALLS, "management_wanted:green_facade_bricks", "management_wanted:green_facade_brick_stairs", "management_wanted:green_facade_brick_slab");
        regularSet(FREDDY_WALLS, "management_wanted:green_facade_wall", "management_wanted:green_facade_wall_stairs", "management_wanted:green_facade_wall_slab");
        regularBlockOnly(FREDDY_WALLS, "management_wanted:green_facade_bricks_big_tiled");
        regularBlockOnly(FREDDY_WALLS, "management_wanted:green_facade_bricks_tiled");
        regularBlockOnly(FREDDY_WALLS, "management_wanted:green_facade_wall_tiled");
        regularSet(FREDDY_WALLS, "management_wanted:lime_facade_bricks_big", "management_wanted:lime_facade_bricks_big_stairs", "management_wanted:lime_facade_bricks_big_slab");
        regularSet(FREDDY_WALLS, "management_wanted:lime_facade_bricks", "management_wanted:lime_facade_brick_stairs", "management_wanted:lime_facade_brick_slab");
        regularSet(FREDDY_WALLS, "management_wanted:lime_facade_wall", "management_wanted:lime_facade_wall_stairs", "management_wanted:lime_facade_wall_slab");
        regularBlockOnly(FREDDY_WALLS, "management_wanted:lime_facade_bricks_big_tiled");
        regularBlockOnly(FREDDY_WALLS, "management_wanted:lime_facade_bricks_tiled");
        regularBlockOnly(FREDDY_WALLS, "management_wanted:lime_facade_wall_tiled");
        regularSet(FREDDY_WALLS, "management_wanted:blue_facade_bricks_big", "management_wanted:blue_facade_bricks_big_stairs", "management_wanted:blue_facade_bricks_big_slab");
        regularSet(FREDDY_WALLS, "management_wanted:blue_facade_bricks", "management_wanted:blue_facade_brick_stairs", "management_wanted:blue_facade_brick_slab");
        regularSet(FREDDY_WALLS, "management_wanted:blue_facade_wall", "management_wanted:blue_facade_wall_stairs", "management_wanted:blue_facade_wall_slab");
        regularBlockOnly(FREDDY_WALLS, "management_wanted:blue_facade_bricks_big_tiled");
        regularBlockOnly(FREDDY_WALLS, "management_wanted:blue_facade_bricks_tiled");
        regularBlockOnly(FREDDY_WALLS, "management_wanted:blue_facade_wall_tiled");
        regularSet(FREDDY_WALLS, "management_wanted:cyan_facade_bricks_big", "management_wanted:cyan_facade_bricks_big_stairs", "management_wanted:cyan_facade_bricks_big_slab");
        regularSet(FREDDY_WALLS, "management_wanted:cyan_facade_bricks", "management_wanted:cyan_facade_brick_stairs", "management_wanted:cyan_facade_brick_slab");
        regularSet(FREDDY_WALLS, "management_wanted:cyan_facade_wall", "management_wanted:cyan_facade_wall_stairs", "management_wanted:cyan_facade_wall_slab");
        regularBlockOnly(FREDDY_WALLS, "management_wanted:cyan_facade_bricks_big_tiled");
        regularBlockOnly(FREDDY_WALLS, "management_wanted:cyan_facade_bricks_tiled");
        regularBlockOnly(FREDDY_WALLS, "management_wanted:cyan_facade_wall_tiled");
        regularSet(FREDDY_WALLS, "management_wanted:brown_facade_bricks_big", "management_wanted:brown_facade_bricks_big_stairs", "management_wanted:brown_facade_bricks_big_slab");
        regularSet(FREDDY_WALLS, "management_wanted:brown_facade_bricks", "management_wanted:brown_facade_brick_stairs", "management_wanted:brown_facade_brick_slab");
        regularSet(FREDDY_WALLS, "management_wanted:brown_facade_wall", "management_wanted:brown_facade_wall_stairs", "management_wanted:brown_facade_wall_slab");
        regularBlockOnly(FREDDY_WALLS, "management_wanted:brown_facade_bricks_big_tiled");
        regularBlockOnly(FREDDY_WALLS, "management_wanted:brown_facade_bricks_tiled");
        regularBlockOnly(FREDDY_WALLS, "management_wanted:brown_facade_wall_tiled");
        regularSet(FREDDY_WALLS, "management_wanted:gray_facade_bricks_big", "management_wanted:gray_facade_bricks_big_stairs", "management_wanted:gray_facade_bricks_big_slab");
        regularSet(FREDDY_WALLS, "management_wanted:gray_facade_bricks", "management_wanted:gray_facade_brick_stairs", "management_wanted:gray_facade_brick_slab");
        regularSet(FREDDY_WALLS, "management_wanted:gray_facade_wall", "management_wanted:gray_facade_wall_stairs", "management_wanted:gray_facade_wall_slab");
        regularBlockOnly(FREDDY_WALLS, "management_wanted:gray_facade_bricks_big_tiled");
        regularBlockOnly(FREDDY_WALLS, "management_wanted:gray_facade_bricks_tiled");
        regularBlockOnly(FREDDY_WALLS, "management_wanted:gray_facade_wall_tiled");
        regularSet(FREDDY_WALLS, "management_wanted:dark_gray_facade_bricks_big", "management_wanted:dark_gray_facade_bricks_big_stairs", "management_wanted:dark_gray_facade_bricks_big_slab");
        regularSet(FREDDY_WALLS, "management_wanted:dark_gray_facade_bricks", "management_wanted:dark_gray_facade_brick_stairs", "management_wanted:dark_gray_facade_brick_slab");
        regularSet(FREDDY_WALLS, "management_wanted:dark_gray_facade_wall", "management_wanted:dark_gray_facade_wall_stairs", "management_wanted:dark_gray_facade_wall_slab");
        regularBlockOnly(FREDDY_WALLS, "management_wanted:dark_gray_facade_bricks_big_tiled");
        regularBlockOnly(FREDDY_WALLS, "management_wanted:dark_gray_facade_bricks_tiled");
        regularBlockOnly(FREDDY_WALLS, "management_wanted:dark_gray_facade_wall_tiled");
        regularSet(FREDDY_WALLS, "management_wanted:purple_facade_bricks_big", "management_wanted:purple_facade_bricks_big_stairs", "management_wanted:purple_facade_bricks_big_slab");
        regularSet(FREDDY_WALLS, "management_wanted:purple_facade_bricks", "management_wanted:purple_facade_brick_stairs", "management_wanted:purple_facade_brick_slab");
        regularSet(FREDDY_WALLS, "management_wanted:purple_facade_wall", "management_wanted:purple_facade_wall_stairs", "management_wanted:purple_facade_wall_slab");
        regularBlockOnly(FREDDY_WALLS, "management_wanted:purple_facade_bricks_big_tiled");
        regularBlockOnly(FREDDY_WALLS, "management_wanted:purple_facade_bricks_tiled");
        regularBlockOnly(FREDDY_WALLS, "management_wanted:purple_facade_wall_tiled");
        regularSet(FREDDY_WALLS, "management_wanted:magenta_facade_bricks_big", "management_wanted:magenta_facade_bricks_big_stairs", "management_wanted:magenta_facade_bricks_big_slab");
        regularSet(FREDDY_WALLS, "management_wanted:magenta_facade_bricks", "management_wanted:magenta_facade_brick_stairs", "management_wanted:magenta_facade_brick_slab");
        regularSet(FREDDY_WALLS, "management_wanted:magenta_facade_wall", "management_wanted:magenta_facade_wall_stairs", "management_wanted:magenta_facade_wall_slab");
        regularBlockOnly(FREDDY_WALLS, "management_wanted:magenta_facade_bricks_big_tiled");
        regularBlockOnly(FREDDY_WALLS, "management_wanted:magenta_facade_bricks_tiled");
        regularBlockOnly(FREDDY_WALLS, "management_wanted:magenta_facade_wall_tiled");
        regularSet(FREDDY_WALLS, "management_wanted:orange_facade_bricks_big", "management_wanted:orange_facade_bricks_big_stairs", "management_wanted:orange_facade_bricks_big_slab");
        regularSet(FREDDY_WALLS, "management_wanted:orange_facade_bricks", "management_wanted:orange_facade_brick_stairs", "management_wanted:orange_facade_brick_slab");
        regularSet(FREDDY_WALLS, "management_wanted:orange_facade_wall", "management_wanted:orange_facade_wall_stairs", "management_wanted:orange_facade_wall_slab");
        regularBlockOnly(FREDDY_WALLS, "management_wanted:orange_facade_bricks_big_tiled");
        regularBlockOnly(FREDDY_WALLS, "management_wanted:orange_facade_bricks_tiled");
        regularBlockOnly(FREDDY_WALLS, "management_wanted:orange_facade_wall_tiled");
        regularSet(FREDDY_WALLS, "management_wanted:yellow_facade_bricks_big", "management_wanted:yellow_facade_bricks_big_stairs", "management_wanted:yellow_facade_bricks_big_slab");
        regularSet(FREDDY_WALLS, "management_wanted:yellow_facade_bricks", "management_wanted:yellow_facade_brick_stairs", "management_wanted:yellow_facade_brick_slab");
        regularSet(FREDDY_WALLS, "management_wanted:yellow_facade_wall", "management_wanted:yellow_facade_wall_stairs", "management_wanted:yellow_facade_wall_slab");
        regularBlockOnly(FREDDY_WALLS, "management_wanted:yellow_facade_bricks_big_tiled");
        regularBlockOnly(FREDDY_WALLS, "management_wanted:yellow_facade_bricks_tiled");
        regularBlockOnly(FREDDY_WALLS, "management_wanted:yellow_facade_wall_tiled");
        regularSet(FREDDY_WALLS, "management_wanted:light_blue_facade_bricks_big", "management_wanted:light_blue_facade_bricks_big_stairs", "management_wanted:light_blue_facade_bricks_big_slab");
        regularSet(FREDDY_WALLS, "management_wanted:light_blue_facade_bricks", "management_wanted:light_blue_facade_brick_stairs", "management_wanted:light_blue_facade_brick_slab");
        regularSet(FREDDY_WALLS, "management_wanted:light_blue_facade_wall", "management_wanted:light_blue_facade_wall_stairs", "management_wanted:light_blue_facade_wall_slab");
        regularBlockOnly(FREDDY_WALLS, "management_wanted:light_blue_facade_bricks_big_tiled");
        regularBlockOnly(FREDDY_WALLS, "management_wanted:light_blue_facade_bricks_tiled");
        regularBlockOnly(FREDDY_WALLS, "management_wanted:light_blue_facade_wall_tiled");
        regularSet(FREDDY_WALLS, "management_wanted:pink_facade_bricks_big", "management_wanted:pink_facade_bricks_big_stairs", "management_wanted:pink_facade_bricks_big_slab");
        regularSet(FREDDY_WALLS, "management_wanted:pink_facade_bricks", "management_wanted:pink_facade_brick_stairs", "management_wanted:pink_facade_brick_slab");
        regularSet(FREDDY_WALLS, "management_wanted:pink_facade_wall", "management_wanted:pink_facade_wall_stairs", "management_wanted:pink_facade_wall_slab");
        regularBlockOnly(FREDDY_WALLS, "management_wanted:pink_facade_bricks_big_tiled");
        regularBlockOnly(FREDDY_WALLS, "management_wanted:pink_facade_bricks_tiled");
        regularBlockOnly(FREDDY_WALLS, "management_wanted:pink_facade_wall_tiled");
        regularSet(FREDDY_WALLS, "management_wanted:white_facade_bricks_big", "management_wanted:white_facade_bricks_big_stairs", "management_wanted:white_facade_bricks_big_slab");
        regularSet(FREDDY_WALLS, "management_wanted:white_facade_bricks", "management_wanted:white_facade_brick_stairs", "management_wanted:white_facade_brick_slab");
        regularSet(FREDDY_WALLS, "management_wanted:white_facade_wall", "management_wanted:white_facade_wall_stairs", "management_wanted:white_facade_wall_slab");
        regularBlockOnly(FREDDY_WALLS, "management_wanted:white_facade_bricks_big_tiled");
        regularBlockOnly(FREDDY_WALLS, "management_wanted:white_facade_bricks_tiled");
        regularBlockOnly(FREDDY_WALLS, "management_wanted:white_facade_wall_tiled");
        regularSet(FREDDY_WALLS, "management_wanted:black_facade_bricks_big", "management_wanted:black_facade_bricks_big_stairs", "management_wanted:black_facade_bricks_big_slab");
        regularSet(FREDDY_WALLS, "management_wanted:black_facade_bricks", "management_wanted:black_facade_brick_stairs", "management_wanted:black_facade_brick_slab");
        regularSet(FREDDY_WALLS, "management_wanted:black_facade_wall", "management_wanted:black_facade_wall_stairs", "management_wanted:black_facade_wall_slab");
        regularBlockOnly(FREDDY_WALLS, "management_wanted:black_facade_bricks_big_tiled");
        regularBlockOnly(FREDDY_WALLS, "management_wanted:black_facade_bricks_tiled");
        regularBlockOnly(FREDDY_WALLS, "management_wanted:black_facade_wall_tiled");
        regularSet(FREDDY_WALLS, "management_wanted:rotten_facade_bricks", "management_wanted:rotten_facade_brick_stairs", "management_wanted:rotten_facade_brick_slab");
        regularSet(FREDDY_WALLS, "management_wanted:rotten_facade_wall", "management_wanted:rotten_facade_wall_stairs", "management_wanted:rotten_facade_wall_slab");
        regularBlockOnly(FREDDY_WALLS, "management_wanted:tiled_rotten_facade_bricks");
        regularBlockOnly(FREDDY_WALLS, "management_wanted:rotten_facade_bricks_tiled");
        regularBlockOnly(FREDDY_WALLS, "management_wanted:rotten_facade_wall_tiled");
        regularBlockOnly(FREDDY_WALLS, "management_wanted:many_tiles");
        regularBlockOnly(FREDDY_WALLS, "management_wanted:fnaf_1_wall_top");
        regularBlockOnly(FREDDY_WALLS, "management_wanted:fnaf_1_wall");
        regularBlockOnly(FREDDY_WALLS, "management_wanted:fnaf_1_wall_bottom");
        regularBlockOnly(FREDDY_WALLS, "management_wanted:fnaf_1_tile_bottom");
        regularBlockOnly(FREDDY_WALLS, "management_wanted:backstage_wall_bottom");
        regularBlockOnly(FREDDY_WALLS, "management_wanted:backstage_wall_top");
        regularBlockOnly(FREDDY_WALLS, "management_wanted:rotten_wall_tiles");
        regularBlockOnly(FREDDY_WALLS, "management_wanted:bathroom_trim");
        regularBlockOnly(FREDDY_WALLS, "management_wanted:deluxe_wall_top");
        regularBlockOnly(FREDDY_WALLS, "management_wanted:deluxe_bathroom_trim");
        regularBlockOnly(FREDDY_WALLS, "management_wanted:deluxe_wall");
        regularBlockOnly(FREDDY_WALLS, "management_wanted:deluxe_wall_bottom");
        regularBlockOnly(FREDDY_WALLS, "management_wanted:deluxe_tiles");
        regularBlockOnly(FREDDY_WALLS, "management_wanted:fnac_tiles");
        regularBlockOnly(FREDDY_WALLS, "management_wanted:fnac_many_tiles");
        regularBlockOnly(FREDDY_WALLS, "management_wanted:fnaf_2_top_wall_confetti");
        regularBlockOnly(FREDDY_WALLS, "management_wanted:fnaf_2_top_wall_confetti_full");
        regularBlockOnly(FREDDY_WALLS, "management_wanted:fnaf_2_top_wall");
        regularBlockOnly(FREDDY_WALLS, "management_wanted:fnaf_2_wall");
        regularBlockOnly(FREDDY_WALLS, "management_wanted:fnaf_2_tiles");
        regularBlockOnly(FREDDY_WALLS, "management_wanted:fnaf_2_wall_tile_trim_red_black");
        regularBlockOnly(FREDDY_WALLS, "management_wanted:fnaf_2_wall_tile_trim_green_black");
        regularBlockOnly(FREDDY_WALLS, "management_wanted:fnaf_2_wall_tile_trim_blue_black");
        regularBlockOnly(FREDDY_WALLS, "management_wanted:fnaf_2_bathroom_trim");
        regularBlockOnly(FREDDY_WALLS, "management_wanted:stripped_fnaf_2_wall_top");
        regularBlockOnly(FREDDY_WALLS, "management_wanted:stripped_fnaf_2_wall");

        regularBlockOnly(FREDDY_WALLS, "management_wanted:green_home_wall");
        regularBlockOnly(FREDDY_WALLS, "management_wanted:green_home_wall_top");
        regularBlockOnly(FREDDY_WALLS, "management_wanted:green_home_wall_bottom");
        regularBlockOnly(FREDDY_WALLS, "management_wanted:green_home_wall");
        regularBlockOnly(FREDDY_WALLS, "management_wanted:green_home_wall_top");
        regularBlockOnly(FREDDY_WALLS, "management_wanted:bedroom_wall_bottom");
        regularBlockOnly(FREDDY_WALLS, "management_wanted:bedroom_wall");
        regularBlockOnly(FREDDY_WALLS, "management_wanted:bedroom_wall_top");
        regularBlockOnly(FREDDY_WALLS, "management_wanted:fnaf_6_wall_top");
        regularBlockOnly(FREDDY_WALLS, "management_wanted:fnaf_6_wall_middle");
        regularBlockOnly(FREDDY_WALLS, "management_wanted:fnaf_6_wall_bottom");
        regularBlockOnly(FREDDY_WALLS, "management_wanted:gallery_wall");
        regularBlockOnly(FREDDY_WALLS, "management_wanted:scooper_superior_top_wall");
        regularBlockOnly(FREDDY_WALLS, "management_wanted:scooper_superior_wall");
        regularBlockOnly(FREDDY_WALLS, "management_wanted:scooper_inferior_wall_top");
        regularBlockOnly(FREDDY_WALLS, "management_wanted:scooper_inferior_wall");
        regularBlockOnly(FREDDY_WALLS, "management_wanted:sl_cladding_bottom");
        regularBlockOnly(FREDDY_WALLS, "management_wanted:sl_cladding_middle");
        regularBlockOnly(FREDDY_WALLS, "management_wanted:sl_cladding_top");
        regularBlockOnly(FREDDY_WALLS, "management_wanted:sl_cladding_bottom_white");
        regularBlockOnly(FREDDY_WALLS, "management_wanted:sl_cladding_middle_white");
        regularBlockOnly(FREDDY_WALLS, "management_wanted:sl_cladding_top_white");
        regularBlockOnly(FREDDY_WALLS, "management_wanted:sl_tile");
        regularBlockOnly(FREDDY_WALLS, "management_wanted:sl_tile_green");
        regularBlockOnly(FREDDY_WALLS, "management_wanted:rewritten_bricks");
        regularBlockOnly(FREDDY_WALLS, "management_wanted:rewritten_gray_black_tile");

        regularBlockOnly(FREDDY_WALLS, "management_wanted:yellow_movie_wall_trim");
        regularSet(FREDDY_WALLS, "management_wanted:yellow_movie_wall", "management_wanted:yellow_movie_wall_stairs", "management_wanted:yellow_movie_wall_slab");
        regularBlockOnly(FREDDY_WALLS, "management_wanted:yellow_movie_wall_tile_trim");
        regularBlockOnly(FREDDY_WALLS, "management_wanted:purple_movie_wall_trim");
        regularSet(FREDDY_WALLS, "management_wanted:purple_movie_wall", "management_wanted:purple_movie_wall_stairs", "management_wanted:purple_movie_wall_slab");
        regularBlockOnly(FREDDY_WALLS, "management_wanted:purple_movie_wall_tile_trim");
        regularBlockOnly(FREDDY_WALLS, "management_wanted:cyan_movie_wall_trim");
        regularSet(FREDDY_WALLS, "management_wanted:cyan_movie_wall", "management_wanted:cyan_movie_wall_stairs", "management_wanted:cyan_movie_wall_slab");
        regularBlockOnly(FREDDY_WALLS, "management_wanted:cyan_movie_wall_tile_trim");

        regularBlockOnly(FREDDY_WALLS, "management_wanted:ba_gwall_top");
        regularBlockOnly(FREDDY_WALLS, "management_wanted:ba_gwall_middle");
        regularBlockOnly(FREDDY_WALLS, "management_wanted:ba_gwall_bottom_title");
        regularBlockOnly(FREDDY_WALLS, "management_wanted:ba_gwall_bottom");

        regularBlockOnly(FREDDY_WALLS, "management_wanted:rotton_top_wall");
        regularBlockOnly(FREDDY_WALLS, "management_wanted:rotton_wall");
        regularBlockOnly(FREDDY_WALLS, "management_wanted:rotton_bottom_wall");

        regularBlockOnly(FREDDY_WALLS, "management_wanted:fredbear_wall_tile");
        regularBlockOnly(FREDDY_WALLS, "management_wanted:fredbear_wall");
        regularSet(FREDDY_WALLS, "management_wanted:fredbear_wall", "management_wanted:fredbear_wall_stairs", "management_wanted:fredbear_wall_slab");
        regularSet(FREDDY_WALLS, "management_wanted:fredbear_wall_top", "management_wanted:fredbear_wall_top_stairs", "management_wanted:fredbear_wall_top_slab");

        regularBlockOnly(FREDDY_WALLS, "management_wanted:fredbear_wall_tile_minigame");
        regularSet(FREDDY_WALLS, "management_wanted:fredbear_wall_minigame", "management_wanted:fredbear_wall_minigame_stairs", "management_wanted:fredbear_wall_minigame_slab");
        regularSet(FREDDY_WALLS, "management_wanted:fredbear_wall_top_minigame", "management_wanted:fredbear_wall_top_minigame_stairs", "management_wanted:fredbear_wall_top_minigame_slab");
    }

    private static void regularBlockOnly(ResourceLocation recipe, Supplier<ItemLike> block){
        REGISTRATION.chiselingEntry(recipe, entry -> entry.regularBlock(block.get()));
    }

    private static void regularBlockOnly(ResourceLocation recipe, String blockIdentifier){
        regularBlockOnly(recipe, getBlock(blockIdentifier));
    }

    private static void connectingBlockOnly(ResourceLocation recipe, Supplier<ItemLike> block){
        REGISTRATION.chiselingEntry(recipe, entry -> entry.connectingBlock(block.get()));
    }

    private static void connectingBlockOnly(ResourceLocation recipe, String blockIdentifier){
        connectingBlockOnly(recipe, getBlock(blockIdentifier));
    }

    private static void regularSet(ResourceLocation recipe, String blockIdentifier, String stairsIdentifier, String slabIdentifier){
        Supplier<ItemLike> block = getBlock(blockIdentifier);
        Supplier<ItemLike> stairs = getBlock(stairsIdentifier);
        Supplier<ItemLike> slab = getBlock(slabIdentifier);
        REGISTRATION.chiselingEntry(recipe, entry -> {
            entry.regularBlock(block.get());
            entry.regularStairs(stairs.get());
            entry.regularSlab(slab.get());
        });
    }

    private static void regularSet(ResourceLocation recipe, String identifier){
        regularSet(recipe, identifier, identifier + "_stairs", identifier + "_slab");
    }
}

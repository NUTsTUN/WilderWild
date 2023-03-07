/*
 * Copyright 2022-2023 FrozenBlock
 * This file is part of Wilder Wild.
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program; if not, see <https://www.gnu.org/licenses/>.
 */

package net.frozenblock.wilderwild.world.additions.feature;

import java.util.List;
import net.frozenblock.lib.worldgen.feature.api.FrozenPlacedFeature;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.CaveFeatures;
import net.minecraft.data.worldgen.features.MiscOverworldFeatures;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.BlockPredicateFilter;
import net.minecraft.world.level.levelgen.placement.CountPlacement;
import net.minecraft.world.level.levelgen.placement.EnvironmentScanPlacement;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import net.minecraft.world.level.levelgen.placement.RandomOffsetPlacement;
import net.minecraft.world.level.levelgen.placement.RarityFilter;
import net.minecraft.world.level.levelgen.placement.SurfaceRelativeThresholdFilter;

public final class WilderMiscPlaced {
	private WilderMiscPlaced() {
		throw new UnsupportedOperationException("WilderMiscPlaced contains only static declarations.");
	}
	// SWAMP
	public static final FrozenPlacedFeature DISK_MUD = WilderPlacedFeatures.register("disk_mud", WilderMiscConfigured.DISK_MUD.getHolder(), CountPlacement.of(1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_TOP_SOLID, RandomOffsetPlacement.vertical(ConstantInt.of(-1)), BlockPredicateFilter.forPredicate(BlockPredicate.matchesBlocks(Blocks.GRASS_BLOCK, Blocks.DIRT)), BiomeFilter.biome());
	public static final FrozenPlacedFeature MUD_PATH = WilderPlacedFeatures.register("mud_path", WilderMiscConfigured.MUD_PATH.getHolder(), RarityFilter.onAverageOnceEvery(3), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());
	// TAIGA
	public static final FrozenPlacedFeature COARSE_PATH = WilderPlacedFeatures.register("coarse_dirt_path", WilderMiscConfigured.COARSE_PATH.getHolder(), RarityFilter.onAverageOnceEvery(3), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());
	public static final FrozenPlacedFeature COARSE_PATH_5 = WilderPlacedFeatures.register("coarse_dirt_path_5", WilderMiscConfigured.COARSE_PATH.getHolder(), RarityFilter.onAverageOnceEvery(5), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());
	public static final FrozenPlacedFeature FOREST_ROCK_TAIGA = WilderPlacedFeatures.register("forest_rock_taiga", MiscOverworldFeatures.FOREST_ROCK, RarityFilter.onAverageOnceEvery(7), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());
	// CYPRESS WETLANDS
	public static final FrozenPlacedFeature UNDER_WATER_SAND_PATH = WilderPlacedFeatures.register("under_water_sand_path", WilderMiscConfigured.UNDER_WATER_SAND_PATH.getHolder(), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_TOP_SOLID, BiomeFilter.biome());
	public static final FrozenPlacedFeature UNDER_WATER_GRAVEL_PATH = WilderPlacedFeatures.register("under_water_gravel_path", WilderMiscConfigured.UNDER_WATER_GRAVEL_PATH.getHolder(), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_TOP_SOLID, BiomeFilter.biome());
	public static final FrozenPlacedFeature UNDER_WATER_CLAY_PATH = WilderPlacedFeatures.register("under_water_clay_path", WilderMiscConfigured.UNDER_WATER_CLAY_PATH.getHolder(), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_TOP_SOLID, BiomeFilter.biome());
	// BEACH AND RIVER
	public static final FrozenPlacedFeature UNDER_WATER_CLAY_PATH_BEACH = WilderPlacedFeatures.register("under_water_clay_path_beach", WilderMiscConfigured.UNDER_WATER_CLAY_PATH_BEACH.getHolder(), RarityFilter.onAverageOnceEvery(3), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());
	public static final FrozenPlacedFeature UNDER_WATER_GRAVEL_PATH_RIVER = WilderPlacedFeatures.register("under_water_gravel_path_river", WilderMiscConfigured.UNDER_WATER_GRAVEL_PATH_RIVER.getHolder(), RarityFilter.onAverageOnceEvery(5), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());
	// SAVANNA
	public static final FrozenPlacedFeature PACKED_MUD_PATH = WilderPlacedFeatures.register("packed_mud_path", WilderMiscConfigured.PACKED_MUD_PATH.getHolder(), RarityFilter.onAverageOnceEvery(8), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());
	// JUNGLE
	public static final FrozenPlacedFeature MOSS_PATH = WilderPlacedFeatures.register("moss_path", WilderMiscConfigured.MOSS_PATH.getHolder(), RarityFilter.onAverageOnceEvery(3), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());
	// DESERT
	public static final FrozenPlacedFeature ORE_PACKED_MUD = WilderPlacedFeatures.register("ore_packed_mud", WilderMiscConfigured.ORE_PACKED_MUD.getHolder(), modifiersWithCount(5, HeightRangePlacement.uniform(VerticalAnchor.absolute(42), VerticalAnchor.absolute(250))));
	public static final FrozenPlacedFeature SANDSTONE_PATH = WilderPlacedFeatures.register("sandstone_path", WilderMiscConfigured.SANDSTONE_PATH.getHolder(), RarityFilter.onAverageOnceEvery(3), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());
	public static final FrozenPlacedFeature SCORCHED_SAND = WilderPlacedFeatures.register("scorched_sand", WilderMiscConfigured.SCORCHED_SAND_DISK.getHolder(), RarityFilter.onAverageOnceEvery(64), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());
	public static final FrozenPlacedFeature SCORCHED_SAND_HUGE = WilderPlacedFeatures.register("scorched_sand_huge", WilderMiscConfigured.SCORCHED_SAND_DISK_HUGE.getHolder(), RarityFilter.onAverageOnceEvery(226), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());
	// BADLANDS
	public static final FrozenPlacedFeature COARSE_DIRT_PATH_SMALL = WilderPlacedFeatures.register("coarse_dirt_path_small", WilderMiscConfigured.COARSE_DIRT_PATH_SMALL.getHolder(), RarityFilter.onAverageOnceEvery(6), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());
	public static final FrozenPlacedFeature PACKED_MUD_PATH_BADLANDS = WilderPlacedFeatures.register("packed_mud_path_badlands", WilderMiscConfigured.PACKED_MUD_PATH_BADLANDS.getHolder(), RarityFilter.onAverageOnceEvery(8), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());
	public static final FrozenPlacedFeature SCORCHED_RED_SAND = WilderPlacedFeatures.register("scorched_red_sand", WilderMiscConfigured.SCORCHED_RED_SAND_DISK.getHolder(), RarityFilter.onAverageOnceEvery(64), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());
	public static final FrozenPlacedFeature SCORCHED_RED_SAND_HUGE = WilderPlacedFeatures.register("scorched_red_sand_huge", WilderMiscConfigured.SCORCHED_RED_SAND_DISK_HUGE.getHolder(), RarityFilter.onAverageOnceEvery(226), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());

	// JELLYFISH CAVES
	public static final FrozenPlacedFeature EXTRA_GLOW_LICHEN = WilderPlacedFeatures.register("extra_glow_lichen", CaveFeatures.GLOW_LICHEN, CountPlacement.of(UniformInt.of(104, 157)), PlacementUtils.RANGE_BOTTOM_TO_MAX_TERRAIN_HEIGHT, InSquarePlacement.spread(), SurfaceRelativeThresholdFilter.of(Heightmap.Types.OCEAN_FLOOR_WG, Integer.MIN_VALUE, -13), BiomeFilter.biome());
	public static final FrozenPlacedFeature STONE_POOL = WilderPlacedFeatures.register("stone_pool", WilderMiscConfigured.STONE_POOL.getHolder(), RarityFilter.onAverageOnceEvery(13), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.absolute(5), VerticalAnchor.aboveBottom(108)), EnvironmentScanPlacement.scanningFor(Direction.DOWN, BlockPredicate.solid(), BlockPredicate.ONLY_IN_AIR_PREDICATE, 12), RandomOffsetPlacement.vertical(ConstantInt.of(1)), BiomeFilter.biome());
	public static final FrozenPlacedFeature DEEPSLATE_POOL = WilderPlacedFeatures.register("deepslate_pool", WilderMiscConfigured.DEEPSLATE_POOL.getHolder(), RarityFilter.onAverageOnceEvery(13), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(6), VerticalAnchor.absolute(5)), EnvironmentScanPlacement.scanningFor(Direction.DOWN, BlockPredicate.solid(), BlockPredicate.ONLY_IN_AIR_PREDICATE, 12), RandomOffsetPlacement.vertical(ConstantInt.of(1)), BiomeFilter.biome());
	public static final FrozenPlacedFeature ORE_CALCITE = WilderPlacedFeatures.register("ore_calcite", WilderMiscConfigured.ORE_CALCITE.getHolder(), modifiersWithCount(2, HeightRangePlacement.uniform(VerticalAnchor.absolute(-54), VerticalAnchor.absolute(64))));
	public static final BlockPredicate ONLY_IN_WATER_PREDICATE = BlockPredicate.matchesBlocks(Blocks.WATER);
	public static final FrozenPlacedFeature JELLYFISH_DEEPSLATE_POOL = WilderPlacedFeatures.register("jellyfish_deepslate_pool", WilderMiscConfigured.DEEPSLATE_POOL.getHolder(), CountPlacement.of(30), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.aboveBottom(67)), EnvironmentScanPlacement.scanningFor(Direction.DOWN, BlockPredicate.solid(), BlockPredicate.ONLY_IN_AIR_PREDICATE, 12), RandomOffsetPlacement.vertical(ConstantInt.of(1)), BiomeFilter.biome());
	public static final FrozenPlacedFeature JELLYFISH_STONE_POOL = WilderPlacedFeatures.register("jellyfish_stone_pool", WilderMiscConfigured.STONE_POOL.getHolder(), CountPlacement.of(30), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(68), VerticalAnchor.top()), EnvironmentScanPlacement.scanningFor(Direction.DOWN, BlockPredicate.solid(), BlockPredicate.ONLY_IN_AIR_PREDICATE, 12), RandomOffsetPlacement.vertical(ConstantInt.of(1)), BiomeFilter.biome());
	public static final FrozenPlacedFeature MESOGLEA_PILLAR = WilderPlacedFeatures.register("blue_mesoglea_pillar", WilderMiscConfigured.UPWARDS_MESOGLEA_PILLAR.getHolder(), CountPlacement.of(7), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.top()), EnvironmentScanPlacement.scanningFor(Direction.DOWN, BlockPredicate.solid(), ONLY_IN_WATER_PREDICATE, 12), RandomOffsetPlacement.vertical(ConstantInt.of(1)), BiomeFilter.biome());
	public static final FrozenPlacedFeature PURPLE_MESOGLEA_PILLAR = WilderPlacedFeatures.register("purple_mesoglea_pillar", WilderMiscConfigured.PURPLE_MESOGLEA_PILLAR.getHolder(), CountPlacement.of(7), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.top()), EnvironmentScanPlacement.scanningFor(Direction.DOWN, BlockPredicate.solid(), ONLY_IN_WATER_PREDICATE, 12), RandomOffsetPlacement.vertical(ConstantInt.of(1)), BiomeFilter.biome());
	public static final FrozenPlacedFeature BLUE_MESOGLEA_PATH = WilderPlacedFeatures.register("blue_mesoglea_path", WilderMiscConfigured.BLUE_MESOGLEA_PATH.getHolder(), CountPlacement.of(24), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.top()), BiomeFilter.biome());
	public static final FrozenPlacedFeature PURPLE_MESOGLEA_PATH = WilderPlacedFeatures.register("purple_mesoglea_path", WilderMiscConfigured.PURPLE_MESOGLEA_PATH.getHolder(), CountPlacement.of(24), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.top()), BiomeFilter.biome());
	// OASIS
	public static final FrozenPlacedFeature SAND_POOL = WilderPlacedFeatures.register("sand_pool", WilderMiscConfigured.SAND_POOL.getHolder(), CountPlacement.of(1), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.absolute(63), VerticalAnchor.aboveBottom(256)), EnvironmentScanPlacement.scanningFor(Direction.DOWN, BlockPredicate.solid(), BlockPredicate.ONLY_IN_AIR_PREDICATE, 12), RandomOffsetPlacement.vertical(ConstantInt.of(1)), BiomeFilter.biome());
	public static final FrozenPlacedFeature MESSY_SAND_POOL = WilderPlacedFeatures.register("messy_sand_pool", WilderMiscConfigured.MESSY_SAND_POOL.getHolder(), CountPlacement.of(2), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.absolute(63), VerticalAnchor.aboveBottom(256)), EnvironmentScanPlacement.scanningFor(Direction.DOWN, BlockPredicate.solid(), BlockPredicate.ONLY_IN_AIR_PREDICATE, 12), RandomOffsetPlacement.vertical(ConstantInt.of(1)), BiomeFilter.biome());
	public static final FrozenPlacedFeature GRASS_PATH = WilderPlacedFeatures.register("grass_path", WilderMiscConfigured.GRASS_PATH.getHolder(), CountPlacement.of(4), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());
	public static final FrozenPlacedFeature MOSS_PATH_OASIS = WilderPlacedFeatures.register("moss_path_oasis", WilderMiscConfigured.MOSS_PATH_OASIS.getHolder(), RarityFilter.onAverageOnceEvery(4), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());
	// BIRCH TAIGA
	public static final FrozenPlacedFeature COARSE_PATH_10 = WilderPlacedFeatures.register("coarse_dirt_path_10", WilderMiscConfigured.COARSE_PATH.getHolder(), RarityFilter.onAverageOnceEvery(10), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());
	// ARID SAVANNA
	public static final FrozenPlacedFeature GRASS_PATH_RARE = WilderPlacedFeatures.register("grass_path_rare", WilderMiscConfigured.GRASS_PATH.getHolder(), CountPlacement.of(1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());
	public static final FrozenPlacedFeature ARID_COARSE_PATH = WilderPlacedFeatures.register("arid_coarse_dirt_path", WilderMiscConfigured.ARID_COARSE_PATH.getHolder(), RarityFilter.onAverageOnceEvery(5), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());
	// OLD GROWTH SNOWY TAIGA
	public static final FrozenPlacedFeature PILE_SNOW = WilderPlacedFeatures.register("pile_snow", WilderMiscConfigured.SNOW.getHolder(), RarityFilter.onAverageOnceEvery(10), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());
	// TEMPERATE RAINFOREST & RAINFOREST
	public static final FrozenPlacedFeature MOSS_PILE = WilderPlacedFeatures.register("moss_pile", WilderMiscConfigured.MOSS_PILE.getHolder(), RarityFilter.onAverageOnceEvery(9), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());
	public static final FrozenPlacedFeature BASIN_RAINFOREST = WilderPlacedFeatures.register("basin_rainforest", WilderMiscConfigured.BASIN_RAINFOREST.getHolder(), RarityFilter.onAverageOnceEvery(5), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.absolute(63), VerticalAnchor.aboveBottom(256)), EnvironmentScanPlacement.scanningFor(Direction.DOWN, BlockPredicate.solid(), BlockPredicate.ONLY_IN_AIR_PREDICATE, 12), RandomOffsetPlacement.vertical(ConstantInt.of(1)), BiomeFilter.biome());
	public static final FrozenPlacedFeature MOSS_LAKE = WilderPlacedFeatures.register("moss_lake", WilderMiscConfigured.MOSS_LAKE.getHolder(), CountPlacement.of(1), RarityFilter.onAverageOnceEvery(1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome());
	//SNOW
	public static final FrozenPlacedFeature SNOW_BLANKET = WilderPlacedFeatures.register("snow_blanket", WilderMiscConfigured.SNOW_BLANKET.getHolder(), CountPlacement.of(1), PlacementUtils.HEIGHTMAP);

	private static List<PlacementModifier> modifiers(PlacementModifier countModifier, PlacementModifier heightModifier) {
        return List.of(countModifier, InSquarePlacement.spread(), heightModifier, BiomeFilter.biome());
    }

    private static List<PlacementModifier> modifiersWithCount(int count, PlacementModifier heightModifier) {
        return modifiers(CountPlacement.of(count), heightModifier);
    }

}

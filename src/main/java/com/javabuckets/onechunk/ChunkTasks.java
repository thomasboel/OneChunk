package com.javabuckets.onechunk;

import org.bukkit.StructureType;
import org.bukkit.block.Biome;
import org.bukkit.block.CreatureSpawner;
import org.bukkit.entity.EntityType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ChunkTasks {
    public static List<Task> tasks = new ArrayList<>();

    // TODO: Instead of adding MobTask's to tasks list, add Biome Tasks with the entity as a requirement

    public static void init() {
        // Passive Mobs
        tasks.add(new MobTask(EntityType.AXOLOTL).setBiomes(Arrays.asList(Biome.LUSH_CAVES)));
        tasks.add(new MobTask(EntityType.BAT).setBiomes(BiomeUtil.ALL_OVERWORLD_BIOMES).setCondition("underground, light level < 3, y < 63"));
        tasks.add(new MobTask(EntityType.CAT).setStructures(Arrays.asList(StructureType.VILLAGE, StructureType.SWAMP_HUT)));
        tasks.add(new MobTask(EntityType.CHICKEN).setBiomes(BiomeUtil.GRASS_BIOMES));
        tasks.add(new MobTask(EntityType.COD).setBiomes(Arrays.asList(Biome.OCEAN, Biome.COLD_OCEAN, Biome.LUKEWARM_OCEAN)));
        tasks.add(new MobTask(EntityType.COW).setBiomes(BiomeUtil.GRASS_BIOMES));
        tasks.add(new MobTask(EntityType.DONKEY).setBiomes(Arrays.asList(Biome.PLAINS, Biome.SAVANNA, Biome.SAVANNA_PLATEAU, Biome.MEADOW)));
        tasks.add(new MobTask(EntityType.GLOW_SQUID).setBiomes(BiomeUtil.ALL_OVERWORLD_BIOMES).setCondition("water block, y < 30"));
        tasks.add(new MobTask(EntityType.HORSE).setBiomes(Arrays.asList(Biome.PLAINS, Biome.SAVANNA, Biome.SAVANNA_PLATEAU)));
        tasks.add(new MobTask(EntityType.MUSHROOM_COW).setBiomes(Arrays.asList(Biome.MUSHROOM_FIELDS)));
        tasks.add(new MobTask(EntityType.MULE).setCondition("offspring of horses and donkeys"));
        tasks.add(new MobTask(EntityType.OCELOT).setBiomes(Arrays.asList(Biome.JUNGLE, Biome.BAMBOO_JUNGLE, Biome.SPARSE_JUNGLE)));
        tasks.add(new MobTask(EntityType.PARROT).setBiomes(Arrays.asList(Biome.JUNGLE, Biome.BAMBOO_JUNGLE, Biome.SPARSE_JUNGLE)));
        tasks.add(new MobTask(EntityType.PIG).setBiomes(BiomeUtil.GRASS_BIOMES));
        tasks.add(new MobTask(EntityType.PUFFERFISH).setBiomes(Arrays.asList(Biome.WARM_OCEAN, Biome.LUKEWARM_OCEAN, Biome.DEEP_LUKEWARM_OCEAN)));
        tasks.add(new MobTask(EntityType.RABBIT).setBiomes(Arrays.asList(Biome.DESERT, Biome.SNOWY_PLAINS, Biome.SNOWY_TAIGA, Biome.GROVE, Biome.SNOWY_SLOPES, Biome.FROZEN_OCEAN, Biome.FROZEN_RIVER, Biome.SNOWY_BEACH, Biome.FLOWER_FOREST, Biome.TAIGA, Biome.MEADOW, Biome.OLD_GROWTH_PINE_TAIGA, Biome.OLD_GROWTH_SPRUCE_TAIGA)));
        tasks.add(new MobTask(EntityType.SALMON).setBiomes(Arrays.asList(Biome.COLD_OCEAN, Biome.FROZEN_OCEAN, Biome.RIVER, Biome.FROZEN_RIVER)));
        tasks.add(new MobTask(EntityType.SHEEP).setBiomes(BiomeUtil.GRASS_BIOMES));
        tasks.add(new MobTask(EntityType.SKELETON_HORSE).setCondition("lightning strike - skeleton trap horse"));
        tasks.add(new MobTask(EntityType.SNOWMAN).setCondition("2 snow blocks and pumpkin"));
        tasks.add(new MobTask(EntityType.SQUID).setBiomes(BiomeUtil.ALL_OCEAN_BIOMES));
        tasks.add(new MobTask(EntityType.STRIDER).setBiomes(BiomeUtil.ALL_NETHER_BIOMES).setCondition("lava block below"));
        tasks.add(new MobTask(EntityType.TROPICAL_FISH).setBiomes(Arrays.asList(Biome.LUKEWARM_OCEAN, Biome.WARM_OCEAN, Biome.LUSH_CAVES)));
        tasks.add(new MobTask(EntityType.TURTLE).setBiomes(Arrays.asList(Biome.BEACH)));
        tasks.add(new MobTask(EntityType.VILLAGER).setStructures(Arrays.asList(StructureType.VILLAGE)));

        // Neutral Mobs
        tasks.add(new MobTask(EntityType.BEE).setCondition("bee nests from grown trees"));
        tasks.add(new MobTask(EntityType.CAVE_SPIDER).setSpawner(true).setStructures(Arrays.asList(StructureType.MINESHAFT)));
        tasks.add(new MobTask(EntityType.DOLPHIN).setBiomes(BiomeUtil.ALL_OCEAN_BIOMES_EXCEPT_FROZEN));
        tasks.add(new MobTask(EntityType.ENDERMAN).setBiomes(Arrays.asList()));
    }
}

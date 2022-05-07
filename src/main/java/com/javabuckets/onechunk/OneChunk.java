package com.javabuckets.onechunk;

import org.bukkit.*;
import org.bukkit.block.Biome;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class OneChunk extends JavaPlugin {

  private static ScoreboardManager scoreboardManager;
  private static Scoreboard board;

  public static ArrayList<Player> players = new ArrayList<>();
  public static ArrayList<Chunk> unlockedChunks = new ArrayList<>();
  public static ArrayList<Task> currentTasks = new ArrayList<>();

  public static WorldBorder worldBorder;

  @Override
  public void onEnable() {
    // Plugin startup logic
    this.getCommand("onechunk").setExecutor(new CommandOneChunk());
  }

  @Override
  public void onDisable() {
    // Plugin shutdown logic
  }

  public static void startOneChunk(Chunk startChunk) {
    // TODO: Get current progress from save file if exists and load it, else create new

    ChunkTasks.init();

    unlockedChunks.add(startChunk);
    players.addAll(Bukkit.getOnlinePlayers());

    setupScoreboard(startChunk);

    worldBorder = startChunk.getWorld().getWorldBorder();
    worldBorder.setCenter(getChunkCenter(startChunk));
    worldBorder.setSize(16);
  }

  public static void setupScoreboard(Chunk chunk) {
    scoreboardManager = Bukkit.getScoreboardManager();
    board = scoreboardManager.getNewScoreboard();

    Objective blockObjective = board.registerNewObjective("blocks", "dummy", "Blocks");
    Objective entityObjective = board.registerNewObjective("entities", "dummy", "Entities");
    blockObjective.setDisplaySlot(DisplaySlot.SIDEBAR);

    ArrayList<Task> chunkTasks = getChunkTasks(chunk);
    print("chunkTasks Size: " + chunkTasks.size());

    for (Task task : chunkTasks) {
      if (task instanceof BlockTask) {
        print(((BlockTask) task).getMaterial().name() + " : " + ((BlockTask) task).getBlockCount());
        Score score = blockObjective.getScore(((BlockTask) task).getMaterial().name());
        score.setScore(((BlockTask) task).getBlockCount());
      }
      else if (task instanceof MobTask) {
        Score score = entityObjective.getScore(((MobTask) task).getEntityType().name());
        score.setScore(1);
      }
    }

    for (Player player : players) {
      print("Setting scoreboard on player: " + player.getDisplayName());
      player.setScoreboard(board);
    }
  }

  public static ArrayList<Task> getChunkTasks(Chunk chunk) {
    ArrayList<Task> taskList = new ArrayList<>();

    // ========== Biome Specific Entity Tasks ========== //
    Biome biome = chunk.getWorld().getBiome(getChunkCenter(chunk));

    // TODO: Get BiomeTask from biome

    // ========== Block Tasks ========== //
    HashMap<Material, Integer> chunkBlockMap = getChunkBlockMap(chunk);

    for (Map.Entry<Material, Integer> entry : chunkBlockMap.entrySet()) {
      taskList.add(new BlockTask(entry.getKey()).setBlockCount(entry.getValue()).setChunk(chunk));
    }

    return taskList;
  }

  public static HashMap<Material, Integer> getChunkBlockMap(Chunk chunk) {
    HashMap<Material, Integer> blockMap = new HashMap<>();

    // North West Corner
    int x1 = chunk.getX() << 4;
    int z1 = chunk.getZ() << 4;
    // South East Corner
    int x2 = (chunk.getX() << 4) + 16;
    int z2 = (chunk.getZ() << 4) + 16;

    for (int x = x1; x < x2; x++) {
      for (int z = z1; z < z2; z++) {
        for (int y = -64; y < chunk.getWorld().getHighestBlockYAt(x, z); y++) {
          Material material = chunk.getWorld().getBlockAt(x, y, z).getType();
          Integer currentCount = blockMap.getOrDefault(material, 0);
          blockMap.put(material, currentCount + 1);
          System.out.println("Added: " + material.name() + ", " + (currentCount + 1));
        }
      }
    }
    return blockMap;
  }

  public static Location getChunkCenter(Chunk chunk) {
    Location center = new Location(chunk.getWorld(), chunk.getX() << 4, 64, chunk.getZ() << 4).add(8, 0, 8);
    center.setY(center.getWorld().getHighestBlockYAt(center) + 1);
    return center;
  }

  public static void print(String str) {
    System.out.println(str);
  }
}

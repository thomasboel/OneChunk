package com.javabuckets.onechunk;

import org.bukkit.Bukkit;
import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.WorldBorder;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.*;

import java.util.ArrayList;
import java.util.Objects;

public final class OneChunk extends JavaPlugin {

  private static ScoreboardManager scoreboardManager;
  private static Scoreboard board;
  private static Objective objective;
  private static Team team;

  public static ArrayList<Player> players = new ArrayList<>();
  public static ArrayList<Chunk> unlockedChunks = new ArrayList<>();
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

    initializeTaskList();

    unlockedChunks.add(startChunk);
    players.addAll(Bukkit.getOnlinePlayers());

    worldBorder = startChunk.getWorld().getWorldBorder();
    Location center = new Location(startChunk.getWorld(), startChunk.getX() << 4, 64, startChunk.getZ() << 4).add(8, 0, 8);
    center.setY(center.getWorld().getHighestBlockYAt(center) + 1);
    worldBorder.setCenter(center);
    worldBorder.setSize(16);
  }

  public static void initializeTaskList() {
    scoreboardManager = Bukkit.getScoreboardManager();
    board = scoreboardManager.getNewScoreboard();
    objective = board.registerNewObjective("task name", "task criteria", "Task Display Name");
    objective.setDisplaySlot(DisplaySlot.SIDEBAR);

    for (Player player : players) {
      player.setScoreboard(board);
    }
  }
}

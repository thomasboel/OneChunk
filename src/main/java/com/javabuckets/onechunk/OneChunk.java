package com.javabuckets.onechunk;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.*;

public final class OneChunk extends JavaPlugin {

  private static ScoreboardManager scoreboardManager;
  private static Scoreboard board;
  private static Objective objective;
  private static Team team;

  @Override
  public void onEnable() {
    initializeTaskList();
  }

  @Override
  public void onDisable() {
    // Plugin shutdown logic
  }

  public static void initializeTaskList() {
    scoreboardManager = Bukkit.getScoreboardManager();
    board = scoreboardManager.getNewScoreboard();
    objective = board.registerNewObjective("task name", "task criteria", "Task Display Name");
    objective.setDisplaySlot(DisplaySlot.SIDEBAR);

    for (Player player : Bukkit.getOnlinePlayers()) {
      player.setScoreboard(board);
    }
  }
}

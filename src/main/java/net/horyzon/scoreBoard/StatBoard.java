package net.horyzon.scoreBoard;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.*;

public class StatBoard {
    public StatBoard(Player player) {
        ScoreboardManager sbManager = Bukkit.getScoreboardManager();
        Scoreboard KDABoard = sbManager.getNewScoreboard();

        Objective objective = KDABoard.registerNewObjective("test", "dummy", "PLAYER STATS");
        objective.setDisplaySlot(DisplaySlot.SIDEBAR);
        objective.getScore(ChatColor.YELLOW + "Kills: 0").setScore(2);
        objective.getScore(ChatColor.RED + "Deaths: 0").setScore(1);


        player.setScoreboard(KDABoard);
    }
}
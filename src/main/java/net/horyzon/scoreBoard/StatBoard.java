package net.horyzon.scoreBoard;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.*;

public class StatBoard {
    public StatBoard(Player player, ConfigManager statConfig) {
        ScoreboardManager sbManager = Bukkit.getScoreboardManager();
        Scoreboard KDABoard = sbManager.getNewScoreboard();

        String uuid = player.getUniqueId().toString();
        int kills = statConfig.getConfig().getInt(uuid + ".Kills", 0);
        int deaths = statConfig.getConfig().getInt(uuid + ".Deaths", 0);

        Objective objective = KDABoard.registerNewObjective("test", "dummy", ChatColor.GOLD + "PLAYER STATS");
        objective.setDisplaySlot(DisplaySlot.SIDEBAR);

        Score killScore = objective.getScore(ChatColor.YELLOW + "Kills: " + kills);
        killScore.setScore(2);

        Score deathScore = objective.getScore(ChatColor.RED + "Deaths: " + deaths);
        deathScore.setScore(1);

        player.setScoreboard(KDABoard);
    }
}
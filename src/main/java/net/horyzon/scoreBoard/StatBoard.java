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

        Objective objective = KDABoard.registerNewObjective("test", "dummy", ChatColor.WHITE.toString() + ChatColor.BOLD + " Player Stats ");
        objective.setDisplaySlot(DisplaySlot.SIDEBAR);

        Score line = objective.getScore(ChatColor.DARK_GRAY.toString() + ChatColor.STRIKETHROUGH + "---------------");
        line.setScore(5);

        Score header = objective.getScore(" ");
        header.setScore(4);

        Score killScore = objective.getScore(ChatColor.RED + "Kills: " + ChatColor.DARK_RED + kills);
        killScore.setScore(3);

        Score deathScore = objective.getScore(ChatColor.GOLD + "Deaths: " + ChatColor.WHITE + deaths);
        deathScore.setScore(2);

        float KDR = (float) kills / deaths;
        String KDRString = String.format("%.2f", KDR);
        Score KDRScore = objective.getScore("KDR: " + KDRString);
        KDRScore.setScore(1);

        Score footer = objective.getScore(ChatColor.DARK_GRAY + " ");
        footer.setScore(0);


        player.setScoreboard(KDABoard);
    }
}
package net.horyzon.scoreBoard.listenersForScoreBoard;

import net.horyzon.scoreBoard.ScoreBoard;
import net.horyzon.scoreBoard.StatBoard;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class onJoinListener implements Listener {
    public final ScoreBoard plugin;

    public onJoinListener(ScoreBoard plugin) {
        this.plugin = plugin;
    }
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        new StatBoard(player, plugin.getStatConfig(), plugin.getScoreBoardModifier());
    }
}
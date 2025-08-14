package net.horyzon.scoreBoard.listenersForScoreBoard;

import net.horyzon.scoreBoard.StatBoard;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class onJoinListener implements Listener {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player joiner = event.getPlayer();
        new StatBoard(joiner);
    }
}
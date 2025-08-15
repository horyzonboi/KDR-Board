package net.horyzon.scoreBoard.listenersForScoreBoard;

import net.horyzon.scoreBoard.ConfigManager;
import net.horyzon.scoreBoard.ScoreBoard;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class statListener implements Listener {
    public final ScoreBoard plugin;
    private final ConfigManager setStatConfig;

    public statListener(ScoreBoard plugin) {
        this.setStatConfig = plugin.getStatConfig();
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerKill(PlayerDeathEvent event) {
        //The one to Die
        Player TOTD = event.getEntity();
        Player killer = TOTD.getKiller();


        String victimPath = TOTD.getUniqueId() + ".Deaths";
        int currentDeaths = setStatConfig.getConfig().getInt(victimPath,0);
        setStatConfig.getConfig().set(victimPath, currentDeaths + 1);

        if (killer != null) {
            String killerPath = killer.getUniqueId() + ".Kills";
            int currentKills = setStatConfig.getConfig().getInt(killerPath, 0);
            setStatConfig.getConfig().set(killerPath, currentKills + 1);
        }
        Bukkit.getScheduler().runTaskAsynchronously(plugin, () -> {
            try {
                setStatConfig.saveConfig();
            } catch (Exception e) {
                plugin.getLogger().warning(e.getMessage());
                e.printStackTrace();
            }
        });
    }
}
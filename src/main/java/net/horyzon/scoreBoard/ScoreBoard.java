package net.horyzon.scoreBoard;

import net.horyzon.scoreBoard.listenersForScoreBoard.onJoinListener;
import net.horyzon.scoreBoard.listenersForScoreBoard.statListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class ScoreBoard extends JavaPlugin {
    private ConfigManager statConfig;

    @Override
    public void onEnable() {
        statConfig = new ConfigManager(this, "PlayerData");
        getServer().getPluginManager().registerEvents(new onJoinListener(), this);
        getServer().getPluginManager().registerEvents(new statListener(this), this);
    }
    public ConfigManager getStatConfig() {
        return statConfig;
    }
    @Override
    public void onDisable() {
        // Plugin shutdown
    }
}

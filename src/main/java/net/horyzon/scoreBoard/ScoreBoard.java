package net.horyzon.scoreBoard;

import net.horyzon.scoreBoard.listenersForScoreBoard.onJoinListener;
import net.horyzon.scoreBoard.listenersForScoreBoard.statListener;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;

public final class ScoreBoard extends JavaPlugin {
    private ConfigManager statConfig;
    private ConfigManager scoreBoardModifier;

    @Override
    public void onEnable() {
        statConfig = new ConfigManager(this, "PlayerData.yml");
        saveResource("settings.yml", false);
        scoreBoardModifier = new ConfigManager(this, "settings.yml");
        getServer().getPluginManager().registerEvents(new onJoinListener(this), this);
        getServer().getPluginManager().registerEvents(new statListener(this), this);
    }
    public ConfigManager getStatConfig() {
        return statConfig;
    }
    public ConfigManager getScoreBoardModifier() {
        return scoreBoardModifier;
    }
    @Override
    public void onDisable() {
        // Plugin shutdown
    }
}

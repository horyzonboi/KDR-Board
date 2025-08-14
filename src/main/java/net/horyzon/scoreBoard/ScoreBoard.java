package net.horyzon.scoreBoard;

import net.horyzon.scoreBoard.listenersForScoreBoard.onJoinListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class ScoreBoard extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new onJoinListener(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}

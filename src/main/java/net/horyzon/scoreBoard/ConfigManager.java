package net.horyzon.scoreBoard;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.io.ObjectInputFilter;

public class ConfigManager {
    private File file;
    private FileConfiguration config;

    public ConfigManager(Plugin plugin, String path) {
        this(plugin.getDataFolder().getAbsolutePath() + "/" + path);
    }
    public ConfigManager(String path) {
        this.file = new File(path);
        this.config = YamlConfiguration.loadConfiguration(this.file);
    }
    public boolean saveConfig() {
        try {
            this.config.save(this.file);
            return true;
        } catch (Exception exception) {
            exception.printStackTrace();
            return false;
        }
    }


    public File getFile() {
        return this.file;
    }
    public FileConfiguration getConfig() {
        return this.config;
    }
}
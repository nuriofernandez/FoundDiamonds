package me.nurio.imperial.founddiamonds;

import me.nurio.imperial.founddiamonds.listeners.PlayerMinningOresListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class FoundDiamonds extends JavaPlugin {

    @Override
    public void onEnable() {
        // Register listeners
        Bukkit.getPluginManager().registerEvents(new PlayerMinningOresListener(), this);

        // Send loaded message
        Bukkit.getLogger().info("Found diamonds is installed!");
    }

}

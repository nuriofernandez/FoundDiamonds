package me.nurio.imperial.founddiamonds;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class FoundDiamonds extends JavaPlugin {

    @Override
    public void onEnable() {
        // Send loaded message
        Bukkit.getLogger().info("Found diamonds is installed!");
    }

}

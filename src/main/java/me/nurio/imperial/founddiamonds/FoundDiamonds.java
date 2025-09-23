package me.nurio.imperial.founddiamonds;

import com.google.common.base.Strings;
import me.nurio.imperial.founddiamonds.listeners.PlayerMinningOresListener;
import me.nurio.imperial.founddiamonds.logics.XRayRatioCalculator;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.plugin.java.JavaPlugin;

import java.text.Format;

public class FoundDiamonds extends JavaPlugin {

    @Override
    public void onEnable() {
        // Register listeners
        Bukkit.getPluginManager().registerEvents(new PlayerMinningOresListener(), this);

        // Send loaded message
        Bukkit.getLogger().info("Found diamonds is installed!");

        // Check xRay users
        for (OfflinePlayer offlinePlayer : Bukkit.getOfflinePlayers()) {
            double xRayRatio = XRayRatioCalculator.calculateXRayRatio(offlinePlayer);
            int minedDiamonds = XRayRatioCalculator.minedDiamonds(offlinePlayer);

            Bukkit.getLogger().info(
                    String.format("User '%s' has a XRay ratio of '%.3f' with %d diamonds", offlinePlayer.getName(), xRayRatio, minedDiamonds)
            );
        }
    }

}

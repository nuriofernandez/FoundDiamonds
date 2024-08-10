package me.nurio.imperial.founddiamonds.listeners;

import me.nurio.imperial.founddiamonds.logics.MineralBroadcaster;
import me.nurio.imperial.founddiamonds.logics.Minerals;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class PlayerMinningOresListener implements Listener {

    @EventHandler
    public void blockBreakEvent(BlockBreakEvent eve) {
        // Check if the broken block is a mineral ore.
        Block block = eve.getBlock();
        Material material = block.getType();
        if (!Minerals.shouldBroadcast(material)) {
            return;
        }

        // Use Mineral broadcaster to send the message
        Player player = eve.getPlayer();
        MineralBroadcaster.broadcast(player, block);
    }

}

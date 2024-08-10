package me.nurio.imperial.founddiamonds.logics;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class MineralBroadcaster {

    private static final TextColor playerNameColor = TextColor.color(0, 170, 170);
    private static final TextColor messageColor = TextColor.color(255, 255, 255);

    public static void broadcast(Player player, Block block) {
        Component playerName = Component.text(player.getName()).color(playerNameColor);
        Component foundText = Component.text(" found ").color(messageColor);

        Material material = block.getType();
        Component mineralName = materialName(material).color(Minerals.getMaterialColor(material));

        Component finalDot = Component.text(".").color(messageColor);

        Bukkit.broadcast(
            playerName.append(foundText).append(mineralName).append(finalDot)
        );
    }

    private static Component materialName(Material material) {
        ItemStack itemStack = new ItemStack(material);
        ItemMeta itemMeta = itemStack.getItemMeta();
        if (itemMeta.hasDisplayName()) {
            return itemMeta.displayName();
        }

        return Component.text(
            material.name().replace('_', ' ').toLowerCase()
        );
    }

}

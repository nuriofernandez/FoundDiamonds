package me.nurio.imperial.founddiamonds.logics;

import net.kyori.adventure.text.format.TextColor;
import org.bukkit.Material;

import java.util.HashMap;
import java.util.Map;

public class Minerals {

    private static final Map<Material, TextColor> materials = new HashMap<>(){{
        put(Material.COPPER_ORE, TextColor.color(255,130,0));
        put(Material.DEEPSLATE_COPPER_ORE, TextColor.color(255,130,0));
        put(Material.COAL_ORE, TextColor.color(85,85,85));
        put(Material.DEEPSLATE_COAL_ORE, TextColor.color(85,85,85));
        put(Material.LAPIS_ORE, TextColor.color(85,85,255));
        put(Material.DEEPSLATE_LAPIS_ORE, TextColor.color(85,85,255));
        put(Material.DIAMOND_ORE, TextColor.color(85,255,255));
        put(Material.DEEPSLATE_DIAMOND_ORE, TextColor.color(85,255,255));
        put(Material.GOLD_ORE, TextColor.color(255,255,100));
        put(Material.DEEPSLATE_GOLD_ORE, TextColor.color(255,255,100));
        put(Material.NETHER_GOLD_ORE, TextColor.color(255,255,100));
        put(Material.EMERALD_ORE, TextColor.color(85,255,85));
        put(Material.DEEPSLATE_EMERALD_ORE, TextColor.color(85,255,85));
        put(Material.IRON_ORE, TextColor.color(170,170,170));
        put(Material.DEEPSLATE_IRON_ORE, TextColor.color(170,170,170));
        put(Material.REDSTONE_ORE, TextColor.color(255,85,85));
        put(Material.DEEPSLATE_REDSTONE_ORE, TextColor.color(255,85,85));
        put(Material.NETHER_QUARTZ_ORE, TextColor.color(200,200,200));
    }};

    public static boolean shouldBroadcast(Material material) {
        return materials.containsKey(material);
    }

    public static TextColor getMaterialColor(Material material) {
        return materials.get(material);
    }

}

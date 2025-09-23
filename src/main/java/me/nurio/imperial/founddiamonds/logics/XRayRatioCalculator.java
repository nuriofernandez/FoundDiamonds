package me.nurio.imperial.founddiamonds.logics;

import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.Statistic;

public class XRayRatioCalculator {

    /**
     * Calculates the probability ratio of a player using X-ray based on mined blocks.
     * This advanced formula compares valuable minerals (diamonds, gold, iron, etc.) against
     * common ones (stone, dirt, coal) with specific weighting for each.
     *
     * @param player The OfflinePlayer to analyze.
     * @return A double representing the calculated ratio. A higher ratio indicates a greater
     * probability of using X-ray.
     */
    public static double calculateXRayRatio(OfflinePlayer player) {
        // Retrieve statistics for all relevant minerals and blocks
        double stoneMined = player.getStatistic(Statistic.MINE_BLOCK, Material.STONE);
        double dirtMined = player.getStatistic(Statistic.MINE_BLOCK, Material.DIRT);
        double gravelMined = player.getStatistic(Statistic.MINE_BLOCK, Material.GRAVEL);

        double coalMined = player.getStatistic(Statistic.MINE_BLOCK, Material.COAL_ORE);
        double ironMined = player.getStatistic(Statistic.MINE_BLOCK, Material.IRON_ORE);
        double goldMined = player.getStatistic(Statistic.MINE_BLOCK, Material.GOLD_ORE);
        double lapisMined = player.getStatistic(Statistic.MINE_BLOCK, Material.LAPIS_ORE);
        double redstoneMined = player.getStatistic(Statistic.MINE_BLOCK, Material.REDSTONE_ORE);
        double diamondMined = player.getStatistic(Statistic.MINE_BLOCK, Material.DIAMOND_ORE);
        double deepslateDiamondMined = player.getStatistic(Statistic.MINE_BLOCK, Material.DEEPSLATE_DIAMOND_ORE);
        double emeraldMined = player.getStatistic(Statistic.MINE_BLOCK, Material.EMERALD_ORE);
        double deepslateEmeraldMined = player.getStatistic(Statistic.MINE_BLOCK, Material.DEEPSLATE_EMERALD_ORE);

        // Define weights for each valuable mineral based on rarity.
        // These can be adjusted to fine-tune the detection.
        double diamondWeight = 12.0;
        double emeraldWeight = 10.0;
        double goldWeight = 8.0;
        double lapisWeight = 6.0;
        double redstoneWeight = 5.0;
        double ironWeight = 4.0;
        double coalWeight = 2.0;

        // Calculate the weighted sum of valuable minerals.
        double valuableMineralsScore =
                (diamondMined + deepslateDiamondMined) * diamondWeight +
                        (emeraldMined + deepslateEmeraldMined) * emeraldWeight +
                        goldMined * goldWeight +
                        lapisMined * lapisWeight +
                        redstoneMined * redstoneWeight +
                        ironMined * ironWeight +
                        coalMined * coalWeight;

        // Calculate the total of common blocks mined.
        // We add 1 to the denominator to prevent division by zero.
        double commonBlocksMined = stoneMined + dirtMined + gravelMined + 1.0;

        // Return the final ratio.
        return valuableMineralsScore / commonBlocksMined;
    }

    public static int minedDiamonds(OfflinePlayer player) {
        int diamondMined = player.getStatistic(Statistic.MINE_BLOCK, Material.DIAMOND_ORE);
        int deepslateDiamondMined = player.getStatistic(Statistic.MINE_BLOCK, Material.DEEPSLATE_DIAMOND_ORE);

        return diamondMined + deepslateDiamondMined;
    }
}
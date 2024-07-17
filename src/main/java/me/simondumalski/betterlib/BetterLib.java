package me.simondumalski.betterlib;

import fr.minuskube.inv.InventoryManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class BetterLib {

    public static InventoryManager inventoryManager;

    public static JavaPlugin plugin;

    public static void init(JavaPlugin plugin) {
        BetterLib.plugin = plugin;
        inventoryManager = new InventoryManager(plugin);
        inventoryManager.init();
    }

}

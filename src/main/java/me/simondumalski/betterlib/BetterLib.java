package me.simondumalski.betterlib;

import org.bukkit.plugin.java.JavaPlugin;

public final class BetterLib {

    public static JavaPlugin plugin;

    public static void init(JavaPlugin plugin) {
        BetterLib.plugin = plugin;
    }

}

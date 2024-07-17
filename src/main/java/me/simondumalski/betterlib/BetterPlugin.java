package me.simondumalski.betterlib;

import org.bukkit.plugin.java.JavaPlugin;

public abstract class BetterPlugin extends JavaPlugin {

    /**
     * Registers the plugin event listeners
     */
    protected abstract void registerListeners();

    /**
     * Registers the plugin commands
     */
    protected abstract void registerCommands();

    /**
     * Schedules the plugin tasks
     */
    protected abstract void scheduleTasks();

    /**
     * Reloads the config.yml and other plugin functions
     */
    public abstract void reload();

}

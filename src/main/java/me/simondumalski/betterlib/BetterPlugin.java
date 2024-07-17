package me.simondumalski.betterlib;

import fr.minuskube.inv.InventoryManager;
import org.bukkit.plugin.java.JavaPlugin;

public abstract class BetterPlugin extends JavaPlugin {

    /**
     * SmartInvs API inventory manager
     */
    private final InventoryManager inventoryManager = new InventoryManager(BetterLib.plugin);

    @Override
    public void onEnable() {

        inventoryManager.init();

    }

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

    /**
     * Gets the SmartInvs API inventory manager
     * @return Inventory manager
     */
    public final InventoryManager getInventoryManager() {
        return inventoryManager;
    }

}
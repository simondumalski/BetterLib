package me.simondumalski.betterlib.menus;

import fr.minuskube.inv.SmartInventory;
import fr.minuskube.inv.content.InventoryProvider;
import fr.minuskube.inv.content.SlotPos;
import me.simondumalski.betterlib.BetterLib;
import org.bukkit.plugin.java.JavaPlugin;

public abstract class Menu implements InventoryProvider {

    /**
     * Instance of the plugin class
     */
    protected static JavaPlugin plugin = BetterLib.plugin;

    /**
     * Gets the smart inventory that creates the menu
     * @return Smart inventory
     */
    public abstract SmartInventory getInventory();

    /**
     * Gets the SlotPos of a slot integer
     * @param slot Slot to get the SlotPot of
     * @return SlotPos
     */
    protected SlotPos getSotPot(int slot) {
        return SlotPos.of(slot / 9, slot % 9);
    }

}

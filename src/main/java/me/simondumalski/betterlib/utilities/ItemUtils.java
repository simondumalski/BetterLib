package me.simondumalski.betterlib.utilities;

import dev.lone.itemsadder.api.CustomStack;
import me.clip.placeholderapi.PlaceholderAPI;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextDecoration;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class ItemUtils {

    /**
     * Creates an ItemStack from a configuration section of the following format:
     *   material: ''
     *   amount: 0
     *   display-name: ''
     *   lore:
     *     - ''
     *   glowing: true
     * Supports PlaceholderAPI placeholders in the lore
     * Supports ItemsAdder materials (itemsadder-material_name)
     * Utilizes MiniMessage for text formatting
     *
     * @param section Configuration section that contains the item information
     * @return ItemStack created from the configuration section
     */
    public static ItemStack createItem(ConfigurationSection section) {

        ItemStack item;

        // Create the item and determine what material to use
        // Defaults to a barrier if a valid material cannot be found
        String materialName = section.getString("material");
        int amount = section.getInt("amount");
        amount = amount <= 0 ? 1 : amount;
        if (materialName.contains("itemsadder-")) {
            CustomStack customStack = CustomStack.getInstance(materialName.split("-")[1]);
            if (customStack == null) {
                item = new ItemStack(Material.BARRIER, amount);
            } else {
                item = customStack.getItemStack();
                item.setAmount(amount);
            }
        } else {
            item = new ItemStack(Material.getMaterial(materialName) == null ? Material.BARRIER : Material.getMaterial(materialName), amount);
        }

        ItemMeta meta = item.getItemMeta();

        // Set the item display name
        String displayName = section.getString("display-name");
        if (displayName != null) {
            meta.displayName(MiniMessage.miniMessage().deserialize(displayName).decoration(TextDecoration.ITALIC, false));
        }

        // Set the item lore
        List<Component> lore = new ArrayList<>();
        section.getStringList("lore").forEach(line -> lore.add(MiniMessage.miniMessage().deserialize(PlaceholderAPI.setPlaceholders(null, line))));
        meta.lore(lore);

        // Make the item glow
        if (section.getBoolean("glow")) {
            meta.addEnchant(Enchantment.AQUA_AFFINITY, 1, true);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        }

        item.setItemMeta(meta);

        return item;
    }

}

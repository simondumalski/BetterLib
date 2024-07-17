package me.simondumalski.betterlib.commands;

import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;

public abstract class Subcommand {

    /**
     * Instance of the main plugin class
     */
    protected static JavaPlugin plugin;

    /**
     * Initializes the subcommand class
     * @param plugin Instance of the main plugin class
     */
    public static void init(JavaPlugin plugin) {
        Subcommand.plugin = plugin;
    }

    /**
     * Gets the name of the subcommand
     * @return Subcommand name
     */
    public abstract String getCommand();

    /**
     * Gets the description of the subcommand
     * @return Subcommand description
     */
    public abstract String getDescription();

    /**
     * Gets the usage of the subcommand
     * @return Subcommand usage
     */
    public abstract String getUsage();

    /**
     * Gets the permission node required to use the subcommand
     * @return Permission node
     */
    public abstract String getPermission();

    /**
     * Performs the subcommand logic
     * @param sender Sender who executed the command
     * @param args Arguments sent with the command
     */
    public abstract void perform(CommandSender sender, String[] args);

    /**
     * Performs the tab complete logic for the subcommand
     * @return List of tab complete arguments
     */
    public abstract List<String> tabComplete(CommandSender sender, String[] args);

}

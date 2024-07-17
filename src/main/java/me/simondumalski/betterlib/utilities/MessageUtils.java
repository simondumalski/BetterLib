package me.simondumalski.betterlib.utilities;

import me.simondumalski.betterlib.BetterLib;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.command.CommandSender;

public class MessageUtils {

    /**
     * Sends a message to a command sender
     * @param sender Sender to send the message to
     * @param message Message to send
     */
    public static void sendMessage(CommandSender sender, String message) {
        String prefix = BetterLib.plugin.getConfig().getString("messages.prefix");
        if (prefix != null) {
            message = message.replace("%prefix%", prefix);
        }
        sender.sendMessage(MiniMessage.miniMessage().deserialize(message));
    }

    /**
     * Sends a message to a command sender with arguments
     * @param sender Sender to send the message to
     * @param message Message to send
     * @param args Arguments
     */
    public static void sendMessage(CommandSender sender, String message, String[] args) {
        for (int i = 0; i < args.length; i++) {
            message = message.replace("{" + i + "}", args[i]);
        }
        sendMessage(sender, message);
    }

}

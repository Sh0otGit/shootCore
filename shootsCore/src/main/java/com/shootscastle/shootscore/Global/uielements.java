package com.shootscastle.shootscore.Global;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.Sound;

public class uielements {
    /**
     * Send an error message to a player.
     *
     * @param player event player
     * @param err error message
     */
    public void sendError(Player player, String err){
        player.sendMessage
                (
                        ChatColor.DARK_GRAY + "["
                                + ChatColor.RED+ChatColor.BOLD + "ERROR"
                                + ChatColor.DARK_GRAY+"]"
                                + ChatColor.AQUA+" • "
                                + ChatColor.GRAY+err
                );
        player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_NO, 1, 1);
    }

    public String sendPrefix(String text){
        String prefix =
                (
                    ChatColor.DARK_GRAY+"["
                            + ChatColor.AQUA+ChatColor.BOLD+text
                            + ChatColor.DARK_GRAY+"]"
                            + ChatColor.AQUA+" • "
                            + ChatColor.GRAY
                );

        return prefix;
    }
}

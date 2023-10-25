package com.shootscastle.shootscore.Global.listeners;

import com.shootscastle.shootscore.Global.Game;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import static org.bukkit.Bukkit.getServer;

public class JoinLeaveListener implements Listener {

    private Game game;

    public JoinLeaveListener(Game game){
        this.game = game;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        Player player = e.getPlayer();
        e.setJoinMessage(ChatColor.DARK_GRAY +"["+ ChatColor.GREEN +"+"+ ChatColor.DARK_GRAY+"] " + ChatColor.GRAY+player.getDisplayName());
        this.game.sendToGame(player);
    }

    @EventHandler
    public void onLeave(PlayerQuitEvent e){
        Player player = e.getPlayer();
        e.setQuitMessage(ChatColor.DARK_GRAY +"["+ ChatColor.RED +"-"+ ChatColor.DARK_GRAY+"] " + ChatColor.GRAY+player.getDisplayName());
    }


}

package com.shootscastle.shootscore.Global;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.HashSet;
import java.util.Set;

public class Queue {

    private final Set<Player> players = new HashSet<>();;
    private final int minQueueToStartGame;
    private final int maxQueueSize;

    private final uielements ui = new uielements();

    public Queue(){
        this.minQueueToStartGame = 1;
        this.maxQueueSize = 99;
    }
    public Queue(int maxPlayersToStartGame){
        this.minQueueToStartGame = maxPlayersToStartGame;
        this.maxQueueSize = 99;
    }

    public Queue(int maxPlayersToStartGame, int maxQueueSize){
        this.minQueueToStartGame = maxPlayersToStartGame;
        this.maxQueueSize = maxQueueSize;
    }

    public boolean playerIsQueued(Player player){
        if (this.players.contains(player)){
            return true;
        }
        return false;
    }

    public boolean playerAddQueue(Player player){
        if (this.players.size() >= this.maxQueueSize) {
            ui.sendError(player, "That queue is full!");
            return false;
        }
        if (playerIsQueued(player)){
            ui.sendError(player, "You are already queued!");
            return false;
        }
        player.sendMessage(ui.sendPrefix("SERVER")+"You were "+ChatColor.GREEN+"added"+ ChatColor.GRAY+" to the queue!");
        return true;
    }

    public boolean playerRemoveQueue(Player player){
        if (!playerIsQueued(player)){
            ui.sendError(player, "You are not queued!");
            return false;
        }
        player.sendMessage(ui.sendPrefix("SERVER")+"You were "+ChatColor.RED+"removed"+ ChatColor.GRAY+" from the queue!");
        return true;
    }

}
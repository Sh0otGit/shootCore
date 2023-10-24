package com.shootscastle.shootscore.Global;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.HashSet;
import java.util.Set;

public class Queue {

    private final Set<Player> players = new HashSet<>();
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
        return this.players.contains(player);
    }

    public void playerAddQueue(Player player){
        if (this.players.size() >= this.maxQueueSize) {
            ui.sendError(player, "That queue is full!");
            return;
        }
        if (playerIsQueued(player)){
            ui.sendError(player, "You are already queued!");
            return;
        }
        this.players.add(player);
        player.sendMessage(ui.sendPrefix("SERVER")+"You were "+ChatColor.GREEN+"added"+ ChatColor.GRAY+" to the queue!");
    }

    public void playerRemoveQueue(Player player){
        if (!playerIsQueued(player)){
            ui.sendError(player, "You are not queued!");
            return;
        }
        this.players.remove(player);
        player.sendMessage(ui.sendPrefix("SERVER")+"You were "+ChatColor.RED+"removed"+ ChatColor.GRAY+" from the queue!");
    }

    public Set<Player> getQueued(){
        return this.players;
    }

}
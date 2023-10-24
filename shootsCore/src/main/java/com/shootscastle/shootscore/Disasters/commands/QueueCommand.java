package com.shootscastle.shootscore.Disasters.commands;

import com.shootscastle.shootscore.Global.Queue;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class QueueCommand implements CommandExecutor {

    private Queue queue;
    public QueueCommand(Queue queue){
        this.queue = queue;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, String[] args){
        if (sender instanceof Player){
            Player player = (Player) sender;
            if(this.queue.playerIsQueued(player)){
                this.queue.playerAddQueue(player);
            } else {
                this.queue.playerRemoveQueue(player);
            }
        }
        return true;
    }
}

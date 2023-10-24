package com.shootscastle.shootscore.Global.commands;

import com.shootscastle.shootscore.Global.Game;
import com.shootscastle.shootscore.Global.Queue;
import com.shootscastle.shootscore.Global.uielements;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class QueueCommand implements CommandExecutor {

    private Game game;
    private Queue queue;

    private final uielements ui = new uielements();

    public QueueCommand(Game game){
        this.game = game;
        this.queue = this.game.getQueue();
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, String[] args){
        if (sender instanceof Player){
            Player player = (Player) sender;
            if(this.game.getType() == "none"){
                ui.sendError(player, "There is no current event being hosted.");
                return true;
            }
            if(!this.queue.playerIsQueued(player)){
                this.queue.playerAddQueue(player);
            } else {
                this.queue.playerRemoveQueue(player);
            }
        }
        return true;
    }
}

package com.shootscastle.shootscore.Global.commands;

import com.shootscastle.shootscore.Global.Game;
import com.shootscastle.shootscore.Global.uielements;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class SetGameCommand implements CommandExecutor {

    private final Game game;

    private final uielements ui = new uielements();

    public SetGameCommand(Game game){
        this.game = game;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, String[] args){
        if (sender instanceof Player){
            Player player = (Player) sender;
            if(!player.hasPermission("staff.admin")){
                ui.sendError(player, "You don't have the required permission for that!");
                return true;
            }
            if (args.length == 0){
                ui.sendError(player, "You didn't define a game name!");
                return true;
            }
            switch (args[0].toLowerCase()){
                default:
                    ui.sendError(player, "That is not a valid game name!");
                    return true;
                case "disasters":
                    this.game.setType("Disasters");
            }
            player.sendMessage(ui.sendPrefix("SERVER")+"You set the server's current game to "+ ChatColor.GREEN + this.game.getType() + ChatColor.GRAY + "!");
            return true;
        }
        return true;
    }
}


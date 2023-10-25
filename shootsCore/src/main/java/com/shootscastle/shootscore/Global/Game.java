package com.shootscastle.shootscore.Global;

import com.shootscastle.shootscore.Global.commands.QueueCommand;
import com.shootscastle.shootscore.Global.commands.SetGameCommand;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import static org.bukkit.Bukkit.getServer;

public class Game{

    private final Queue queue;
    private String type;

    public Game(String type) {
        this.type = type;
        this.queue = new Queue(1);

    }
    public Queue getQueue(){return this.queue;}

    public void setType(String type){
        this.type = type;
    }
    public String getType(){
        return this.type;
    }

    public void sendToGame(Player player){
        if (this.type == "none"){
            World world = getServer().getWorld("default");
            Location loc = new Location(world, 0, 65, 0);
            player.teleport(loc);
        } else if (this.type == "disasters"){
            World world = getServer().getWorld("disasters");
            Location loc = new Location(world, 0, 109, -23);
            player.teleport(loc);
        }
    }
}

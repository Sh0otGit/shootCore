package com.shootscastle.shootscore.Global;

import com.shootscastle.shootscore.Global.commands.QueueCommand;
import com.shootscastle.shootscore.Global.commands.SetGameCommand;
import org.bukkit.plugin.java.JavaPlugin;

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
}

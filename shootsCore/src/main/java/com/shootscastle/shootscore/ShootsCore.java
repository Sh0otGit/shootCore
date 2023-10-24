package com.shootscastle.shootscore;

import com.shootscastle.shootscore.Disasters.commands.QueueCommand;
import com.shootscastle.shootscore.Global.Queue;
import org.bukkit.plugin.java.JavaPlugin;

public final class ShootsCore extends JavaPlugin {

    public String currentGame;
    private Queue queue;

    @Override
    public void onEnable() {
        this.queue = new Queue(1);
        this.currentGame = "Disasters";
        if(currentGame == "Disasters"){
            getCommand("queue").setExecutor(new QueueCommand(this.queue));
        }

        // Plugin startup logic

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}

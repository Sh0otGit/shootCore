package com.shootscastle.shootscore;

import com.shootscastle.shootscore.Global.Game;
import com.shootscastle.shootscore.Global.commands.QueueCommand;
import com.shootscastle.shootscore.Global.commands.SetGameCommand;
import com.shootscastle.shootscore.Global.listeners.JoinLeaveListener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class ShootsCore extends JavaPlugin {

    public String currentGame;
    private Game game;

    @Override
    public void onEnable() {
        this.game = new Game("none");
        getLogger().info("Initialized new game!");

        getServer().getPluginManager().registerEvents(new JoinLeaveListener(game), this);
        getLogger().info("Registered events successfully.");

        Objects.requireNonNull(getCommand("queue")).setExecutor(new QueueCommand(game));
        Objects.requireNonNull(getCommand("setgame")).setExecutor(new SetGameCommand(game));
        getLogger().info("Registered commands successfully.");
        // Plugin startup logic

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}

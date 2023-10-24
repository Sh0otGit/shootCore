package com.shootscastle.shootscore;

import com.shootscastle.shootscore.Global.Game;
import com.shootscastle.shootscore.Global.commands.QueueCommand;
import com.shootscastle.shootscore.Global.commands.SetGameCommand;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class ShootsCore extends JavaPlugin {

    public String currentGame;
    private Game game;

    @Override
    public void onEnable() {
        this.game = new Game("none");

        Objects.requireNonNull(getCommand("queue")).setExecutor(new QueueCommand(game));
        Objects.requireNonNull(getCommand("setgame")).setExecutor(new SetGameCommand(game));
        // Plugin startup logic

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}

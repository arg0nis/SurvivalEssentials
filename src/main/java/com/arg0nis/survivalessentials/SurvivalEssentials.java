package com.arg0nis.survivalessentials;

import com.arg0nis.survivalessentials.commands.SpawnCommand;
import com.arg0nis.survivalessentials.listeners.PlayerRespawnListener;
import org.bukkit.Location;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.UUID;

public final class SurvivalEssentials extends JavaPlugin {
    public HashMap<UUID, Location> spawnLocations = new HashMap<UUID, Location>();
    private static SurvivalEssentials plugin;
    public static SurvivalEssentials getInstance() {
        return  plugin;
    }

    @Override
    public void onEnable() {
        plugin = this;
        getServer().getPluginManager().registerEvents(new PlayerRespawnListener(), this);
        getCommand("setspawn").setExecutor(new SpawnCommand());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}

package com.arg0nis.survivalessentials.listeners;

import com.arg0nis.survivalessentials.SurvivalEssentials;
import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;

public class PlayerRespawnListener implements Listener {
    @EventHandler
    public void onPlayerDeath(PlayerRespawnEvent e) {
        SurvivalEssentials plugin = SurvivalEssentials.getInstance();
        Location spawnLoc = plugin.spawnLocations.get(e.getPlayer().getUniqueId());
        if(spawnLoc == null)
            return;
        e.setRespawnLocation(spawnLoc);
    }
}

package com.arg0nis.survivalessentials.commands;

import com.arg0nis.survivalessentials.SurvivalEssentials;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SpawnCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(!(commandSender instanceof Player)) {
            commandSender.sendMessage("Only Players can use this command!");
            return false;
        }
        Player player = (Player) commandSender;
        Location playerLocation = player.getLocation();
        SurvivalEssentials plugin = SurvivalEssentials.getInstance();

        if(playerLocation.getBlock().getRelative(BlockFace.DOWN).isEmpty()) {
            player.sendMessage("Cannot set spawn on this location!");
            return false;
        }

        if(!(plugin.spawnLocations.get(player.getUniqueId()) == null)) {
            plugin.spawnLocations.remove(player.getUniqueId());
        }

        plugin.spawnLocations.put(player.getUniqueId(), playerLocation);
        player.sendMessage("Successfully set spawn location: x:" + Math.round(playerLocation.getX())
                + " y:" + Math.round(playerLocation.getY())
                + " z:" + Math.round(playerLocation.getZ()));
        return true;
    }
}

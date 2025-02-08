package me.touchie771.explodingMobs.commands;

import me.touchie771.explodingMobs.ExplodingMobs;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class ExploadableMobSpawner implements CommandExecutor {

    final private ExplodingMobs plugin;

    public ExploadableMobSpawner(ExplodingMobs plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String @NotNull [] args) {
        if (sender instanceof Player player) { // The command was executed by a player
            @NotNull String @NotNull [] mob = args;
            String mobName = plugin.getConfig().getString("explosiveMobName", "Exploadable Mob");
            var entity = player.getWorld().spawnEntity(player.getLocation(), EntityType.valueOf(mob[0].toUpperCase()));
            entity.customName(Component.text(mobName).color(NamedTextColor.DARK_BLUE));
            player.sendMessage(Component.text("We spawned a " + mob[0]).color(NamedTextColor.GREEN));
        }
        else { // The command was executed by the console
            @NotNull String @NotNull [] mob = args;
            String mobName = plugin.getConfig().getString("explosiveMobName", "Exploadable Mob");

            // Fetch the location from config
            String locationString = plugin.getConfig().getString("consoleSpawnLocation", "0,0,0");
            String[] locParts = locationString.split(",");
            double x = Double.parseDouble(locParts[0]);
            double y = Double.parseDouble(locParts[1]);
            double z = Double.parseDouble(locParts[2]);
            var location = new Location(plugin.getServer().getWorlds().getFirst(), x, y, z);

            var entity = location.getWorld().spawnEntity(location, EntityType.valueOf(mob[0].toUpperCase()));
            entity.customName(Component.text(mobName).color(NamedTextColor.DARK_BLUE));
            sender.sendMessage(Component.text("We spawned a " + mob[0]).color(NamedTextColor.GREEN));
        }
        return true;
    }
}
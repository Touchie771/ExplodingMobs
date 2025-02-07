package me.touchie771.explodingMobs.commands;

import me.touchie771.explodingMobs.ExplodingMobs;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
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
        if (sender instanceof Player player) {
            @NotNull String @NotNull [] mob = args;
            String mobName = plugin.getConfig().getString("explosiveMobName", "Exploadable Mob");
            var entity = player.getWorld().spawnEntity(player.getLocation(), EntityType.valueOf(mob[0].toUpperCase()));
            entity.customName(Component.text(mobName).color(NamedTextColor.DARK_BLUE));
            player.sendMessage(Component.text("We spawned a " + mob[0]).color(NamedTextColor.GREEN));
        }
        else {
            sender.sendMessage(Component.text("Only players can use this command!").color(NamedTextColor.RED));
        }
        return true;
    }
}
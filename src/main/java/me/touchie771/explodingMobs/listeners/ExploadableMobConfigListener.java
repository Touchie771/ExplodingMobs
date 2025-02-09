package me.touchie771.explodingMobs.listeners;

import io.papermc.paper.event.player.AsyncChatEvent;
import me.touchie771.explodingMobs.ExplodingMobs;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.serializer.plain.PlainTextComponentSerializer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.jetbrains.annotations.NotNull;

import java.util.HashSet;
import java.util.Set;

public class ExploadableMobConfigListener implements Listener {
    private final ExplodingMobs plugin;
    private final Set<Player> nameTagClickers = new HashSet<>();
    private final Set<Player> explosionEffectClickers = new HashSet<>();
    private final Set<Player> explosionRadiusClickers = new HashSet<>();
    private final Set<Player> consoleCommandLocationClickers = new HashSet<>();

    public ExploadableMobConfigListener(ExplodingMobs plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onInventoryClick(@NotNull InventoryClickEvent event) {
        if (event.getView().title().equals(Component.text("Exploadable Mob Config").color(NamedTextColor.DARK_BLUE))) {
            // Check if the player clicked the close button
            if (event.getWhoClicked() instanceof Player player) {
                if (event.getCurrentItem() != null) {
                    switch (event.getCurrentItem().getType()) {
                        case BARRIER:
                            player.closeInventory();
                            break;
                        case NAME_TAG:
                            player.closeInventory();
                            player.sendMessage(Component.text("Please type the new name for the explodable mobs:").color(NamedTextColor.YELLOW));
                            nameTagClickers.add(player);
                            break;
                        case BLAZE_POWDER: // Explosion effect
                            player.closeInventory();
                            player.sendMessage(Component.text("Please type the new explosion effect (e.g., NONE, FIRE, SMOKE):").color(NamedTextColor.YELLOW));
                            explosionEffectClickers.add(player);
                            break;
                        case FIREWORK_ROCKET: // Explosion radius
                            player.closeInventory();
                            player.sendMessage(Component.text("Please type the new explosion radius:").color(NamedTextColor.YELLOW));
                            explosionRadiusClickers.add(player);
                            break;
                        case BEACON:
                            player.closeInventory();
                            player.sendMessage(Component.text("Please type the new console command spawn location in the format x, y, z:").color(NamedTextColor.YELLOW));
                            consoleCommandLocationClickers.add(player);
                            break;
                    }
                }
            }
        }
    }

    @EventHandler
    public void onPlayerChat(@NotNull AsyncChatEvent event) {
        Player player = event.getPlayer();
        if (nameTagClickers.contains(player)) {
            event.setCancelled(true); // Cancel the chat message
            String newName = PlainTextComponentSerializer.plainText().serialize(event.message());
            plugin.getConfig().set("explosiveMobName", newName);
            plugin.saveConfig();
            player.sendMessage(Component.text("Explodable mobs' name has been updated to: " + newName).color(NamedTextColor.GREEN));
            nameTagClickers.remove(player);
        } else if (explosionEffectClickers.contains(player)) {
            event.setCancelled(true); // Cancel the chat message
            String newEffect = PlainTextComponentSerializer.plainText().serialize(event.message()).toUpperCase();
            plugin.getConfig().set("explosionEffect", newEffect);
            plugin.saveConfig();
            player.sendMessage(Component.text("Explosion effect has been updated to: " + newEffect).color(NamedTextColor.GREEN));
            explosionEffectClickers.remove(player);
        } else if (explosionRadiusClickers.contains(player)) {
            event.setCancelled(true); // Cancel the chat message
            String newRadiusStr = PlainTextComponentSerializer.plainText().serialize(event.message());
            try {
                int newRadius = Integer.parseInt(newRadiusStr);
                plugin.getConfig().set("explosionRadius", newRadius);
                plugin.saveConfig();
                player.sendMessage(Component.text("Explosion radius has been updated to: " + newRadius).color(NamedTextColor.GREEN));
            } catch (NumberFormatException e) {
                player.sendMessage(Component.text("Invalid number format. Please type a valid integer for the explosion radius.").color(NamedTextColor.RED));
            }
            explosionRadiusClickers.remove(player);
        } else if (consoleCommandLocationClickers.contains(player)) {
            event.setCancelled(true); // Cancel the chat message
            String newLocation = PlainTextComponentSerializer.plainText().serialize(event.message());
            plugin.getConfig().set("consoleSpawnLocation", newLocation);
            plugin.saveConfig();
            player.sendMessage(Component.text("Console command spawn location has been updated to: " + newLocation).color(NamedTextColor.GREEN));
            consoleCommandLocationClickers.remove(player);
        }
    }
}
package me.touchie771.explodingMobs.listeners;

import me.touchie771.explodingMobs.ExplodingMobs;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class ExploadableMobListener implements Listener {

    final private ExplodingMobs plugin;

    public ExploadableMobListener(ExplodingMobs plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onMobHit(@NotNull EntityDamageByEntityEvent event) {
        if (event.getDamager() instanceof Player) {
            String mobName = plugin.getConfig().getString("explosiveMobName", "Exploadable Mob");
            if (Objects.equals(event.getEntity().customName(), Component.text(mobName).color(NamedTextColor.DARK_BLUE))) {
                int radius = plugin.getConfig().getInt("explosionRadius");
                event.getEntity().getWorld().createExplosion(event.getEntity().getLocation(), radius);
            }
        }
    }

}
package me.touchie771.explodingMobs.listeners;

import me.touchie771.explodingMobs.ExplodingMobs;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class ExploadableMobSpawnListener implements Listener {

    final private ExplodingMobs plugin;

    public ExploadableMobSpawnListener(ExplodingMobs plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onMobHit(@NotNull EntityDamageByEntityEvent event) {
        if (event.getDamager() instanceof Player) {
            String mobName = plugin.getConfig().getString("explosiveMobName", "Exploadable Mob");
            if (Objects.equals(event.getEntity().customName(), Component.text(mobName).color(NamedTextColor.DARK_BLUE))) {
                String effect = plugin.getConfig().getString("explosionEffect", "NONE").toUpperCase();
                int radius = plugin.getConfig().getInt("explosionRadius");
                if (effect.equals("NONE")) {
                    event.getEntity().getWorld().createExplosion(event.getEntity().getLocation(), radius);
                }
                else {
                    switch (effect) {
                        case "FIRE":
                            event.getEntity().getWorld().spawnParticle(Particle.FLAME, event.getEntity().getLocation(), 10);
                            break;
                        case "SMOKE":
                            event.getEntity().getWorld().spawnParticle(Particle.LARGE_SMOKE, event.getEntity().getLocation(), 10);
                            break;
                    }
                }
            }
        }
    }

}
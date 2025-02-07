package me.touchie771.explodingMobs;

import me.touchie771.explodingMobs.commands.ExploadableMobSpawner;
import me.touchie771.explodingMobs.listeners.ExploadableMobListener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class ExplodingMobs extends JavaPlugin {

    @Override
    public void onEnable() {
        // Implement commands.
        Objects.requireNonNull(getCommand("spawnMob")).setExecutor(new ExploadableMobSpawner(this));
        // Implement listeners.
        getServer().getPluginManager().registerEvents(new ExploadableMobListener(this), this);
        // Save files and resources.
        saveDefaultConfig();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}

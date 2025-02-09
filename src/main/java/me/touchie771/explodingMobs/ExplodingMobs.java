package me.touchie771.explodingMobs;

import me.touchie771.explodingMobs.commands.ExploadableMobConfig;
import me.touchie771.explodingMobs.commands.ExploadableMobSpawner;
import me.touchie771.explodingMobs.listeners.ExploadableMobConfigListener;
import me.touchie771.explodingMobs.listeners.ExploadableMobSpawnListener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public class ExplodingMobs extends JavaPlugin {

    @Override
    public void onEnable() {
        // Implement commands.
        Objects.requireNonNull(getCommand("spawnMob")).setExecutor(new ExploadableMobSpawner(this));
        Objects.requireNonNull(getCommand("configMob")).setExecutor(new ExploadableMobConfig());
        // Implement listeners.
        getServer().getPluginManager().registerEvents(new ExploadableMobSpawnListener(this), this);
        getServer().getPluginManager().registerEvents(new ExploadableMobConfigListener(this), this);

        // Save files and resources.
        saveDefaultConfig();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

}
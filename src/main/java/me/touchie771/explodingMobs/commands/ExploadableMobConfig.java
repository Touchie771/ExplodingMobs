package me.touchie771.explodingMobs.commands;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

public class ExploadableMobConfig implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String @NotNull [] args) {
        if (sender instanceof Player player) {
            Inventory configMenu = Bukkit.createInventory(null, 27, Component.text("Exploadable Mob Config").color(NamedTextColor.DARK_BLUE));
            // Create the close button
            ItemStack closeButton = new ItemStack(Material.BARRIER);
            ItemMeta closeButtonMeta = closeButton.getItemMeta();
            closeButtonMeta.displayName(Component.text("Close config menu").color(NamedTextColor.RED));
            closeButton.setItemMeta(closeButtonMeta);
            // Add the close button to the menu
            configMenu.setItem(8, closeButton);
            // Add the set explodable mob name button
            ItemStack setMobNameButton = new ItemStack(Material.NAME_TAG);
            ItemMeta setMobNameButtonMeta = setMobNameButton.getItemMeta();
            setMobNameButtonMeta.displayName(Component.text("Set explodable mobs name").color(NamedTextColor.GREEN));
            setMobNameButton.setItemMeta(setMobNameButtonMeta);
            // Add the set explodable mob name button to the menu
            configMenu.setItem(10, setMobNameButton);
            // Add the set explosion effect button
            ItemStack setExplosionEffectButton = new ItemStack(Material.BLAZE_POWDER);
            ItemMeta setExplosionEffectButtonMeta = setExplosionEffectButton.getItemMeta();
            setExplosionEffectButtonMeta.displayName(Component.text("Set explosion effect").color(NamedTextColor.AQUA));
            setExplosionEffectButton.setItemMeta(setExplosionEffectButtonMeta);
            // Add the set explosion effect button to the menu
            configMenu.setItem(12, setExplosionEffectButton);
            // Add the set explosion radius button
            ItemStack setExplosionRadiusButton = new ItemStack(Material.FIREWORK_ROCKET);
            ItemMeta setExplosionRadiusButtonMeta = setExplosionRadiusButton.getItemMeta();
            setExplosionRadiusButtonMeta.displayName(Component.text("Set explosion radius").color(NamedTextColor.AQUA));
            setExplosionRadiusButton.setItemMeta(setExplosionRadiusButtonMeta);
            // Add the set explosion radius button to the menu
            configMenu.setItem(14, setExplosionRadiusButton);
            // Add the set console command spawn location button
            ItemStack setConsoleCommandLocationButton = new ItemStack(Material.BEACON);
            ItemMeta setConsoleCommandLocationButtonMeta = setConsoleCommandLocationButton.getItemMeta();
            setConsoleCommandLocationButtonMeta.displayName(Component.text("Set console command spawn location").color(NamedTextColor.LIGHT_PURPLE));
            setConsoleCommandLocationButton.setItemMeta(setConsoleCommandLocationButtonMeta);
            // Add the set console command spawn location button to the menu
            configMenu.setItem(16, setConsoleCommandLocationButton);

            // Open the inventory for the player
            player.openInventory(configMenu);
        }
        return true;
    }
}
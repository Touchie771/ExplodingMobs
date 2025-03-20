# 💥 ExplodingMobs 💥

<div align="center">
  
![ExplodingMobs Banner](https://via.placeholder.com/800x200?text=ExplodingMobs+Banner)

[![Version](https://img.shields.io/github/v/release/Touchie771/ExplodingMobs?include_prereleases&style=for-the-badge&logo=github&color=F05032)](https://github.com/Touchie771/ExplodingMobs/releases)
[![Downloads](https://img.shields.io/github/downloads/Touchie771/ExplodingMobs/total?style=for-the-badge&logo=github&color=4CAF50)](https://github.com/Touchie771/ExplodingMobs/releases)
[![License](https://img.shields.io/github/license/Touchie771/ExplodingMobs?style=for-the-badge&logo=github&color=007396)](LICENSE)
[![Status](https://img.shields.io/badge/Status-No%20Longer%20Maintained-red?style=for-the-badge)](https://github.com/Touchie771/ExplodingMobs)

*A powerful Minecraft plugin that transforms ordinary mobs into explosive entities, adding an exciting twist to your gameplay!*

[Features](#-features) • 
[Requirements](#-requirements) • 
[Installation](#-installation) • 
[Commands](#-commands) • 
[Configuration](#%EF%B8%8F-configuration) • 
[FAQ](#-frequently-asked-questions) • 
[Status](#-project-status)

</div>

---

## ⚠️ Project Status: Archived

**IMPORTANT NOTICE:** This plugin is no longer being maintained or updated. The current version is the final release. Feel free to use and modify the plugin for your own servers, but there will be no official support or future updates.

## 🌟 What is ExplodingMobs?

[ExplodingMobs](https://github.com/Touchie771/ExplodingMobs) is a free, open-source plugin built for the Paper API that adds explosive capabilities to mobs in your Minecraft server! When these special mobs die, they detonate with customizable explosion effects, creating exciting and unpredictable gameplay experiences.

### 🎬 Demo

<div align="center">
  
![ExplodingMobs Demo](https://via.placeholder.com/640x360?text=ExplodingMobs+Demo+Video)
  
*Explosive zombie in action! Replace with actual screenshots or GIFs of your plugin.*
</div>

## ✨ Features

### Core Features
- 🧨 **Explosive Mobs**: Turn ordinary mobs into walking bombs that explode on death
- 🎯 **Targeted Spawning**: Spawn explosive mobs at specific locations with simple commands
- 🌈 **Visual Effects**: Customize explosion effects with fire, smoke, or no particles
- 📊 **Damage Control**: Fine-tune explosion radius to balance gameplay

### Advanced Features
- ⚙️ **Fully Customizable**: Extensive configuration options for server admins
- 🎮 **In-Game GUI**: Easy configuration menu accessible in-game
- 🏷️ **Custom Naming**: Give your explosive mobs unique names
- 🔌 **Developer API**: Integrate ExplodingMobs into your own plugins (coming soon!)

## 💻 Requirements

- **Server Type**: Paper, Spigot, or compatible fork
- **Minecraft Version**: 1.16.5 or higher
- **Java**: Java 16 or higher
- **RAM**: Minimal impact on server performance
- **Dependencies**: None required!

## 📋 Installation

1. **Download** the latest version of ExplodingMobs from the [GitHub Releases](https://github.com/Touchie771/ExplodingMobs/releases)
2. **Place** the JAR file in your server's `plugins` folder
3. **Restart** your server
4. **Verify** installation by checking the server console for the ExplodingMobs startup message
5. **Configure** the plugin by editing the config file (optional)
6. **Enjoy** explosive gameplay!

## 🎮 Commands

| Command | Description | Parameters | Permission |
|---------|-------------|------------|------------|
| `/spawnmob <MobType>` | Spawns an explosive mob | `<MobType>`: Type of mob to spawn | `explodingmobs.spawn` |
| `/configmob` | Opens the in-game configuration menu | None | `explodingmobs.config` |
| `/explodingmobs reload` | Reloads the configuration | None | `explodingmobs.admin` |
| `/explodingmobs help` | Shows help information | None | `explodingmobs.help` |

> 📝 **Note**: When executed from the console, the `/spawnmob` command will spawn the mob at a location set via the config file.

## ⚙️ Configuration

ExplodingMobs comes with a comprehensive configuration system. Here's the default configuration file:

```yaml
# ExplodingMobs Configuration
# Last Updated: March 2025

# 1. Explosion Customization
# --------------------------

explosionRadius: 5 # The radius of the explosion (1-10)
explosiveMobName: Explodable Mob # The name of the mob
explosionEffect: NONE # The effect of the explosion

# 2. Console Customization
# -----------------------

consoleSpawnLocation: 0, 0, 0 # The location where the mob should spawn if the command is executed by the console
```

### 🎯 Configuration Options Explained

#### Explosion Radius
- **Default**: 5
- **Range**: 1-10
- **Impact**: Controls how far the explosion reaches and how much damage it causes

#### Explosion Effect Types
| Effect | Description | Visual Impact |
|--------|-------------|---------------|
| NONE | No visual effects | Clean explosion |
| FIRE | Adds fire particles | Fiery explosion with chance to ignite blocks |
| SMOKE | Adds smoke particles | Smoky explosion with visibility effects |

> ⚠️ **Warning:** The explosion effect can only be one of the following:
> - NONE
> - FIRE
> - SMOKE
> - If anything else is provided, it won't work.

## 🖥️ In-Game Configuration

For server admins who prefer a graphical interface, ExplodingMobs provides an intuitive in-game configuration menu.

```
/configmob
```

<div align="center">
  
![Configuration Menu](https://via.placeholder.com/400x300?text=Configuration+Menu)
  
*Example of the in-game configuration menu*
</div>

The in-game menu provides an intuitive interface for adjusting:
- 💣 **Explosion Radius**: Slide to adjust explosion power
- 🏷️ **Custom Mob Names**: Enter custom names for your explosive mobs
- 🔥 **Explosion Effects**: Toggle between different visual effects
- 📍 **Console Spawn Location**: Set default spawn coordinates

## 🔧 Supported Mob Types

ExplodingMobs supports all vanilla Minecraft mobs, including:

| Common Mobs | Hostile Mobs | Passive Mobs |
|-------------|--------------|--------------|
| Zombie | Creeper | Cow |
| Skeleton | Spider | Sheep |
| Slime | Enderman | Pig |
| Witch | Blaze | Chicken |
| Drowned | Phantom | Horse |

To spawn a specific mob type, use the mob name as shown in the Minecraft wiki:

```
/spawnmob zombie
/spawnmob creeper
/spawnmob cow
```

## ❓ Frequently Asked Questions

<details>
<summary><b>🔍 Will this plugin affect server performance?</b></summary>
ExplodingMobs is designed to be lightweight and will have minimal impact on your server performance.
</details>

<details>
<summary><b>🔍 Can I customize which mobs can explode?</b></summary>
Yes! You can specify which mob types can explode by using the appropriate mob type with the /spawnmob command.
</details>

<details>
<summary><b>🔍 Is this plugin compatible with other mob plugins?</b></summary>
ExplodingMobs is designed to be compatible with most other plugins. If you encounter any conflicts, you'll need to troubleshoot on your own as there is no support available.
</details>

<details>
<summary><b>🔍 Can players trigger the explosions manually?</b></summary>
Currently, explosions are triggered when the mob dies. No new features will be added as the plugin is no longer maintained.
</details>

<details>
<summary><b>🔍 Will there be any more updates to this plugin?</b></summary>
No. This plugin has reached its final state and will not receive any further updates or support.
</details>

## 🛑 Support Status

**This plugin has NO active support or contact methods available.**

- ⛔ There is no official support for this plugin
- ⛔ The developer cannot be contacted for assistance
- ⛔ No bug fixes or updates will be provided
- ✅ You are free to fork the repository and modify it for your own use
- ✅ You may distribute modified versions according to the license terms

## 📜 License

ExplodingMobs is licensed under the [MIT License](LICENSE).

---

<div align="center">
  
Made by [Touchie771](https://github.com/Touchie771)
  
</div>
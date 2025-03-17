# ExplodingMobs

[ExplodingMobs](https://github.com/Touchie771/ExplodingMobs) is a free, open-source plugin built for the Paper API. It makes some mobs explode. You can spawn one of those mobs using the following command:

```
/spawnmob <MobType>
```

Note that when executed from the console, it will spawn the mob at a location set via the config file.

## Configuration

This is the default configuration file provided. Modify it as needed:

```yaml
# This is the configuration file for the ExplodingMobs plugin.
# It contains the configuration for the plugin.
# It is a YAML file, and it is used to configure the plugin.

# 1. For explosion customization.

explosionRadius: 5 # The radius of the explosion.
explosiveMobName: Explodable Mob # The name of the mob.
explosionEffect: NONE # The effect of the explosion.

# 2. For console customization.

consoleSpawnLocation: 0, 0, 0 # The location of where the mob should spawn if the command is executed by the console.
```

> ⚠️ **Warning:** The explosion effect can only be one of the following:
> - NONE
> - FIRE
> - SMOKE
> - If anything else is provided, it won't work.

## In-Game Configuration

You can also edit the config file directly in-game! Use the following command to open a menu that allows you to edit the configuration in-game:

```
/configmob
```

> ⚠️ **Warning:** The explosion effect can only be one of the following:
> - NONE
> - FIRE
> - SMOKE
> - If anything else is provided, it won't work.

# ManHunt

[SpigotMC page](https://www.spigotmc.org/resources/manhunt.90409/)

## Minecraft Manhunt
### _It was originally a plugin developed in about 30 mins to play with my friends!_

The speed runner has to find 3 golden blocks placed randomly in a 250 block radius.

## Mechanics:
1. If the speed runner dies the hunters win.
2. If the speed runner finds all golden blocks he wins.
3. If a hunter dies he will respawn and get a new compass.

_The speed runner has a compass which points to the golden block. The Hunters have a compass pointing towards the speed runner._

## How to start the game:
1. The Admin types "/init" to place 3 golden blocks randomly in the world.
2. All players are giving themselves a role:
- speed runner - ONLY 1 PLAYER - /speedrunner
- hunter - /hunter
3. The admin starts the game with /start
- A 20 sec cool down starts and the speed runner can run away
- The hunters are unable to move

## Installation:
Place the plugin in the "plugins" directory

## config.yml
```yaml
#####################
# Minecraft manhunt #
#####################

# Language
lang: de

vars:
  # Countdown in sec
  countdown: 20
  # Radius in which gold blocks are placed
  radius: 250

# messages english
message_en:
  hunter_won: "§aThe hunters have won!"
  role:
    hunter: "§aYou are now a hunter!"
    speedrunner: "§aYou a now a speed runner!"
  found_block: "§a§lThe speed runner has found a gold block!"
  found_all_blocks: "§a§lThe speed runner has found all gold blocks and wins!"
  init_success: "§aAll gold blocks have been placed"
  start: "§aLet's begin!"
  countdown: "I'm counting to "

# messages german
message_de:
  hunter_won: "§aDie Hunter haben gewonnen!"
  role:
    hunter: "§aDu bist nun ein Hunter!"
    speedrunner: "§aDu bist nun ein Speedrunner!"
  found_block: "§a§lDer Speedrunner hat einen Goldblock gefunden!"
  found_all_blocks: "§a§lDer Speedrunner hat alle Goldblöcke gefunden und gewinnt!"
  init_success: "§aAlle Goldblöcke wurde erfolgreich plaziert"
  start: "§aLos geht's!"
  countdown: "Ich zähle bis "
```


Support:
[![Discord](https://discord.com/api/guilds/810244027239759952/widget.png)](https://discord.gg/MjDvFsK2NG)

package de.base2code.manhunt.listener;

import de.base2code.manhunt.commands.CMDInit;
import de.base2code.manhunt.commands.CMDStart;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BlockBreak implements Listener {
    @EventHandler
    public static void onBreak (BlockBreakEvent e){
        if (e.getBlock().getType().equals(Material.GOLD_BLOCK)){
            if (CMDInit.blocks.contains(e.getBlock())){
                CMDInit.blocks.remove(e.getBlock());
                Bukkit.broadcastMessage("§cDer Speedrunner hat einen Goldblock abgebaut");
                if (CMDInit.blocks.isEmpty()){
                    CMDStart.started = false;
                    Bukkit.broadcastMessage("§cDer Speedrunner hat alle Goldblöcke abgebaut und hat gewonnen");
                    for (Player p : Bukkit.getOnlinePlayers()){
                        p.setGameMode(GameMode.SPECTATOR);
                    }
                }
            }
        }
    }
}

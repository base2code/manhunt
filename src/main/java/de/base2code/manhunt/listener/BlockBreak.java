package de.base2code.manhunt.listener;

import de.base2code.manhunt.commands.CMDInit;
import de.base2code.manhunt.commands.CMDStart;
import de.base2code.manhunt.utils.Utils;
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
                for (Player p : Bukkit.getOnlinePlayers()){
                    Utils.sendMessage(p, "found_block");
                }
                if (CMDInit.blocks.isEmpty()){
                    CMDStart.started = false;
                    for (Player p : Bukkit.getOnlinePlayers()){
                        p.setGameMode(GameMode.SPECTATOR);
                        Utils.sendMessage(p, "found_all_blocks");
                    }
                }
            }
        }
    }
}

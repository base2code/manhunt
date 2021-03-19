package de.base2code.manhunt.listener;

import de.base2code.manhunt.GameAction;
import de.base2code.manhunt.commands.CMDStart;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class Move implements Listener {
    @EventHandler
    public static void onMove (PlayerMoveEvent e){
        if (CMDStart.countdown){
            if (GameAction.hunter.contains(e.getPlayer())){
                e.setCancelled(true);
            }
        }
    }
}

package de.base2code.manhunt.listener;

import de.base2code.manhunt.GameAction;
import de.base2code.manhunt.commands.CMDInit;
import de.base2code.manhunt.commands.CMDStart;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class Death implements Listener {
    @EventHandler
    public static void onDeath (PlayerDeathEvent e){
        if (CMDStart.started){
            if (GameAction.speedrunner.contains(e.getEntity())){
                CMDStart.started = false;
                Bukkit.broadcastMessage("§aDie Hunter haben gewonnen!");
                for (Player p : Bukkit.getOnlinePlayers()){
                    p.setGameMode(GameMode.SPECTATOR);
                }
            }
        }
    }
}

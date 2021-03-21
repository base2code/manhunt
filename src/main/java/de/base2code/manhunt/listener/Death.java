package de.base2code.manhunt.listener;

import de.base2code.manhunt.GameAction;
import de.base2code.manhunt.commands.CMDInit;
import de.base2code.manhunt.commands.CMDStart;
import de.base2code.manhunt.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;

public class Death implements Listener {
    @EventHandler
    public static void onDeath (PlayerDeathEvent e){
        if (CMDStart.started){
            if (GameAction.speedrunner.contains(e.getEntity())){
                CMDStart.started = false;
                for (Player p : Bukkit.getOnlinePlayers()){
                    p.setGameMode(GameMode.SPECTATOR);
                    Utils.sendMessage(p, "hunter_won");
                }
            }
            if (GameAction.hunter.contains(e.getEntity())){
                e.getEntity().getInventory().addItem(new ItemStack(Material.COMPASS, 1));
            }
        }
    }
}

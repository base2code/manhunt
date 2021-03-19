package de.base2code.manhunt;

import de.base2code.manhunt.commands.CMDInit;
import de.base2code.manhunt.commands.CMDStart;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class GameAction {
    public static ArrayList<Player> hunter = new ArrayList<>();
    public static ArrayList<Player> speedrunner = new ArrayList<>();

    public static void initialize () {
        Bukkit.getScheduler().scheduleSyncRepeatingTask(Manhunt.getInstance(), new Runnable() {
            @Override
            public void run() {
                if (CMDStart.started){
                    for (Player p : Bukkit.getOnlinePlayers()){
                        if (hunter.contains(p)){
                            p.setCompassTarget(speedrunner.get(0).getLocation());
                        }else{
                            p.setCompassTarget(CMDInit.blocks.get(0).getLocation());
                        }
                    }
                }
            }
        }, 0, 10);
    }
}

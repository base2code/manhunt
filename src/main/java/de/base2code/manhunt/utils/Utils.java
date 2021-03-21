package de.base2code.manhunt.utils;

import de.base2code.manhunt.Manhunt;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class Utils {

    public static void sendMessage (Player p, String path){
        if (Manhunt.getInstance().getConfig().getString("lang").equalsIgnoreCase("de")){
            p.sendMessage(Manhunt.getInstance().getConfig().getString("message_de." + path));
        }else{
            p.sendMessage(Manhunt.getInstance().getConfig().getString("message_en." + path));
        }
    }

    public static void broadcastMessage (String path){
        for (Player p : Bukkit.getOnlinePlayers()){
            sendMessage(p, path);
        }
    }

}

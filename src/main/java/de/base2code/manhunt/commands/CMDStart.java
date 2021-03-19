package de.base2code.manhunt.commands;

import de.base2code.manhunt.Manhunt;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class CMDStart implements CommandExecutor {
    public static boolean started = false;
    public static boolean countdown = false;

    public static int i = 0;
    public static int id;
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player){
            Location start = Bukkit.getWorld("world").getHighestBlockAt(0,0).getLocation().add(0, 2, 0);
            for (Player p : Bukkit.getOnlinePlayers()){
                p.teleport(start);
                p.getInventory().addItem(new ItemStack(Material.COMPASS, 1));
                p.setHealth(20);
                p.setFoodLevel(10);
            }
            started = true;
            countdown = true;
            Bukkit.broadcastMessage("Ich zähle bis 20");
            id = Bukkit.getScheduler().scheduleSyncRepeatingTask(Manhunt.getInstance(), new Runnable() {
                @Override
                public void run() {
                    i++;
                    Bukkit.broadcastMessage(i + "");
                    if (i >= 20){
                        countdown = false;
                        Bukkit.broadcastMessage("§aEs geht los!");
                        Bukkit.getScheduler().cancelTask(id);
                    }
                }
            },0,20);
        }
        return false;
    }
}

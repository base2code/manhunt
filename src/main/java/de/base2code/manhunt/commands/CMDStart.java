package de.base2code.manhunt.commands;

import de.base2code.manhunt.GameAction;
import de.base2code.manhunt.Manhunt;
import de.base2code.manhunt.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class CMDStart implements CommandExecutor {
    public static boolean started = false;
    public static boolean countdown = false;

    public static int i = 0;
    public static int id;
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player){
            Location start = getNormal((Player) sender).getHighestBlockAt(0,0).getLocation().add(0, 2, 0);
            for (Player p : Bukkit.getOnlinePlayers()){
                p.teleport(start);
                p.getInventory().addItem(new ItemStack(Material.COMPASS, 1));
                p.setHealth(20);
                p.setFoodLevel(20);
            }
            started = true;
            countdown = true;
            Utils.broadcastMessage("countdown");

            for (Player p : GameAction.hunter){
                p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 20, 255));
            }

            id = Bukkit.getScheduler().scheduleSyncRepeatingTask(Manhunt.getInstance(), new Runnable() {
                @Override
                public void run() {
                    i++;
                    Bukkit.broadcastMessage(i + "");
                    if (i >= Manhunt.getInstance().getConfig().getInt("vars.countdown")){
                        countdown = false;
                        Utils.broadcastMessage("start");
                        Bukkit.getScheduler().cancelTask(id);
                    }
                }
            },0,20);
        }
        return false;
    }

    public static World getNormal(Player player) {
        World world = player.getWorld();
        String[] normals = world.getName().split("_");
        return Bukkit.getServer().getWorld(normals[0]);
    }
}

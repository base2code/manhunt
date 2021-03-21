package de.base2code.manhunt.commands;

import de.base2code.manhunt.Manhunt;
import de.base2code.manhunt.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ThreadLocalRandom;

public class CMDInit implements CommandExecutor {
    public static ArrayList<Block> blocks = new ArrayList<>();
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player){
            int radius = Manhunt.getInstance().getConfig().getInt("vars.radius");
            for (int i = 0; i <= 2; i++){
                int x = ThreadLocalRandom.current().nextInt(-1 * radius, radius);
                int z = ThreadLocalRandom.current().nextInt(-1 * radius, radius);
                Bukkit.getWorld("world").getHighestBlockAt(x, z).setType(Material.GOLD_BLOCK);
                blocks.add(Bukkit.getWorld("world").getHighestBlockAt(x, z));
                System.out.println(i + "-" + " x: " + x + " z: " + z);
            }
            Utils.sendMessage((Player) sender, "init_success");
        }
        return false;
    }
}

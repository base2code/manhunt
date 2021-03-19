package de.base2code.manhunt.commands;

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
            for (int i = 0; i <= 2; i++){
                int x = ThreadLocalRandom.current().nextInt(-300, 300);
                int z = ThreadLocalRandom.current().nextInt(-300, 300);
                Bukkit.getWorld("world").getHighestBlockAt(x, z).setType(Material.GOLD_BLOCK);
                blocks.add(Bukkit.getWorld("world").getHighestBlockAt(x, z));
                System.out.println(i + "-" + " x: " + x + " z: " + z);
            }
            sender.sendMessage("§aSuccess");
        }
        return false;
    }
}

package de.base2code.manhunt.commands;

import de.base2code.manhunt.GameAction;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CMDSpeedrunner implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player){
            GameAction.speedrunner.add((Player) sender);
            if (GameAction.hunter.contains((Player) sender)){
                GameAction.hunter.remove((Player) sender);
            }
            sender.sendMessage("§aDu bist nun einer Speedrunner!");
        }
        return false;
    }
}

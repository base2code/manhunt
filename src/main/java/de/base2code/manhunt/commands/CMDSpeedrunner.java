package de.base2code.manhunt.commands;

import de.base2code.manhunt.GameAction;
import de.base2code.manhunt.utils.Utils;
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
            Utils.sendMessage((Player) sender, "role.speedrunner");
        }
        return false;
    }
}

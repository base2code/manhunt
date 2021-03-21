package de.base2code.manhunt.commands;

import de.base2code.manhunt.GameAction;
import de.base2code.manhunt.utils.Utils;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CMDHunter implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player){
            GameAction.hunter.add((Player) sender);
            if (GameAction.speedrunner.contains((Player) sender)){
                GameAction.speedrunner.remove((Player) sender);
            }
            Utils.sendMessage((Player) sender, "role.hunter");
        }
        return false;
    }
}

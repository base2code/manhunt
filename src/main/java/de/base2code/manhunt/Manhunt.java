package de.base2code.manhunt;

import de.base2code.manhunt.commands.CMDHunter;
import de.base2code.manhunt.commands.CMDInit;
import de.base2code.manhunt.commands.CMDSpeedrunner;
import de.base2code.manhunt.commands.CMDStart;
import de.base2code.manhunt.listener.BlockBreak;
import de.base2code.manhunt.listener.Death;
import de.base2code.manhunt.listener.Move;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class Manhunt extends JavaPlugin {

    public static Manhunt instance;

    @Override
    public void onEnable() {
        instance = this;
        PluginManager pm = Bukkit.getPluginManager();

        pm.registerEvents(new BlockBreak(), this);
        pm.registerEvents(new Death(), this);
        pm.registerEvents(new Move(), this);

        this.getCommand("init").setExecutor(new CMDInit());
        this.getCommand("hunter").setExecutor(new CMDHunter());
        this.getCommand("speedrunner").setExecutor(new CMDSpeedrunner());
        this.getCommand("start").setExecutor(new CMDStart());

        GameAction.initialize();

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static Manhunt getInstance(){
        return instance;
    }
}

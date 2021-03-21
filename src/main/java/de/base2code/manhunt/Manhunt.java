package de.base2code.manhunt;

import de.base2code.manhunt.commands.CMDHunter;
import de.base2code.manhunt.commands.CMDInit;
import de.base2code.manhunt.commands.CMDSpeedrunner;
import de.base2code.manhunt.commands.CMDStart;
import de.base2code.manhunt.listener.BlockBreak;
import de.base2code.manhunt.listener.Death;
import org.bstats.bukkit.Metrics;
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

        this.getCommand("init").setExecutor(new CMDInit());
        this.getCommand("hunter").setExecutor(new CMDHunter());
        this.getCommand("speedrunner").setExecutor(new CMDSpeedrunner());
        this.getCommand("start").setExecutor(new CMDStart());

        GameAction.initialize();

        Metrics metrics = new Metrics(this, 10763);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static Manhunt getInstance(){
        return instance;
    }
}

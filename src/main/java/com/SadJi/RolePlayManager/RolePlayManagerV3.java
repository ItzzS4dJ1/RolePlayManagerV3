package com.SadJi.RolePlayManager;

import com.SadJi.RolePlayManager.Commands.GetSeason;
import com.SadJi.RolePlayManager.Commands.NameChanger;
import com.SadJi.RolePlayManager.Commands.SetSeason;
import com.SadJi.RolePlayManager.Events.ChatListener;
import com.SadJi.RolePlayManager.Events.MyPlayerListener;

import com.SadJi.RolePlayManager.Events.bandageUse;
import com.SadJi.RolePlayManager.Tasks.CycleTask;
import com.SadJi.RolePlayManager.Tasks.DelayedTask;
import com.SadJi.RolePlayManager.Utility.JobCommand;
import com.SadJi.RolePlayManager.Utility.Menu;
import com.SadJi.RolePlayManager.Utility.SeasonExpansion;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;
import java.util.logging.Logger;


public class RolePlayManagerV3 extends JavaPlugin implements Listener {
    Logger log = getLogger();



    private static RolePlayManagerV3 plugin;
    public static RolePlayManagerV3 getPlugin() {
        return plugin;
    }
    @Override
    public void onEnable ( ) {
        getConfig().options().copyDefaults();
        saveConfig();
        plugin = this;

        if (Bukkit.getPluginManager().isPluginEnabled("PlaceholderAPI")) {
            new SeasonExpansion(this, plugin).register();
        }

        log.info("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
        log.info("    SadJi's RolePlay Manager");
        log.info("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
        log.info("  Plugin Enabled Successfully");
        log.info("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
        log.info("     Plugin version: TEST");
        log.info("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");

        getServer().getPluginManager().registerEvents(new MyPlayerListener(), this);
        getServer().getPluginManager().registerEvents(new ChatListener(), this);
        getServer().getPluginManager().registerEvents(new bandageUse(), this);
        getCommand("name").setExecutor(new NameChanger());
        getCommand("menu").setExecutor(new Menu());
        getCommand("job").setExecutor(new JobCommand());
        getCommand("setseason").setExecutor(new SetSeason());
        getCommand("setseason").setDescription("Ставит сезон");
        getCommand("getseason").setExecutor(new GetSeason());

        new DelayedTask(this);
        BukkitTask cycleTask = new CycleTask(this).runTaskTimer(this, 0L, 40L);
    }
    @Override
    public void onDisable () {
        saveConfig();
        log.info("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
        log.info("   SadJi's RolePlay Manager");
        log.info("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
        log.info(" Plugin disabled Successfully");
        log.info("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
        log.info("For support: contact @ItzzS4dJ1");
        log.info("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
    }
}






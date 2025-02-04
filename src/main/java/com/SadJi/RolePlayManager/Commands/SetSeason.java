package com.SadJi.RolePlayManager.Commands;

import com.SadJi.RolePlayManager.RolePlayManagerV3;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class SetSeason implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if (args.length == 1){
            final RolePlayManagerV3 plugin = RolePlayManagerV3.getPlugin();
            plugin.getConfig().set("current-season", args[0]);
        } else{
            sender.sendMessage("Больше одного аргумента");
        }

        return true;
    }
}

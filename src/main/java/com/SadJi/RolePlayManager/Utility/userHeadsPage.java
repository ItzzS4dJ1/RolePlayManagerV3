package com.SadJi.RolePlayManager.Utility;

import com.SadJi.RolePlayManager.RolePlayManagerV3;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.metadata.FixedMetadataValue;

public class userHeadsPage implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (!(commandSender instanceof Player)){
            commandSender.sendMessage("Only for players.");
            return true;
        }

        Player p =  (Player) commandSender;
        Inventory inventory = Bukkit.createInventory(p, 9*6, "Коммуникатор-0");
        p.openInventory(inventory);
        p.setMetadata("OpenedMenu", new FixedMetadataValue(RolePlayManagerV3.getPlugin(), inventory));
        return true;


    }
}

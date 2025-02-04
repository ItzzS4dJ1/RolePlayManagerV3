package com.SadJi.RolePlayManager.Utility;

import com.SadJi.RolePlayManager.RolePlayManagerV3;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.metadata.FixedMetadataValue;

import java.util.ArrayList;
import java.util.List;

public class JobCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if (!(commandSender instanceof Player)){
            commandSender.sendMessage("ONLY FOR PLAYERS");
        }
        Player p = (Player) commandSender;

        ItemStack pickaxeButton = new ItemStack(Material.IRON_PICKAXE);
        ItemMeta MinerMeta = pickaxeButton.getItemMeta();
        MinerMeta.setDisplayName(ChatColor.DARK_AQUA + "Шахтер");
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.WHITE + "Нейтрализует дебаффы подземничества.");
        lore.add(ChatColor.GRAY + "Копайтесь в шахте и не заходите ну уж слишком глубоко.");
        MinerMeta.setLore(lore);
        pickaxeButton.setItemMeta(MinerMeta);

        ItemStack bricksButton = new ItemStack(Material.BRICKS);
        ItemMeta BuilderMeta = bricksButton.getItemMeta();
        BuilderMeta.setDisplayName(ChatColor.GOLD + "Строитель");
        bricksButton.setItemMeta(BuilderMeta);
        List<String> lore0 = new ArrayList<>();
        lore0.add(ChatColor.WHITE + "Строитель. Одна из важнейших профессий нового мира");
        lore0.add(ChatColor.GRAY + "Дает полное право строить постройки, в т.ч. на заказ");
        BuilderMeta.setLore(lore0);
        bricksButton.setItemMeta(BuilderMeta);

        ItemStack Scientist = new ItemStack(Material.COMMAND_BLOCK);
        ItemMeta ScienceMeta = bricksButton.getItemMeta();
        ScienceMeta.setDisplayName(ChatColor.WHITE + "Учёный");
        List<String> lore1 = new ArrayList<>();
        lore1.add(ChatColor.WHITE + "Будь гением мира сего и восстанавливай труды человечества.");
        lore1.add(ChatColor.GRAY + "(В будущем планируется мини-игра)");
        ScienceMeta.setLore(lore1);
        Scientist.setItemMeta(ScienceMeta);

        ItemStack Mechanic = new ItemStack(Material.COMMAND_BLOCK_MINECART);
        ItemMeta mechMeta = Mechanic.getItemMeta();
        mechMeta.setDisplayName(ChatColor.AQUA + "Механик");
        Mechanic.setItemMeta(BuilderMeta);
        List<String> lore2 = new ArrayList<>();
        lore2.add(ChatColor.WHITE + "Механик. способен собрать машины.");
        lore2.add(ChatColor.GRAY + "Вы сможете продавать эти же машины");
        mechMeta.setLore(lore2);
        Mechanic.setItemMeta(mechMeta);

        ItemStack Brewer = new ItemStack(Material.BREWING_STAND);
        ItemMeta brewMeta = Brewer.getItemMeta();
        brewMeta.setDisplayName(ChatColor.RED + "Бармен");
        Brewer.setItemMeta(brewMeta);
        List<String> lore3 = new ArrayList<>();
        lore3.add(ChatColor.WHITE + "Вы сможете варить напитки. В т.ч. алкоголь");
        lore3.add(ChatColor.GRAY + "Алкогольные напитки, наркотик прошлого дожил и до будущего.");
        brewMeta.setLore(lore3);
        Brewer.setItemMeta(brewMeta);






        Inventory inventory = Bukkit.createInventory(p, 9, "Выбор работы");



        inventory.setItem(1, pickaxeButton);
        inventory.setItem(3, bricksButton);
        inventory.setItem(5, Scientist);
        //inventory.setItem(6, Mechanic);
        inventory.setItem(7, Brewer);
        p.openInventory(inventory);
        p.setMetadata("OpenedJobs", new FixedMetadataValue(RolePlayManagerV3.getPlugin(), inventory));
        return true;
    }
}

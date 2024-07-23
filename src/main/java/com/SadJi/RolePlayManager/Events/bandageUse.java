package com.SadJi.RolePlayManager.Events;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class bandageUse implements Listener {
    @EventHandler
    public void bandageUsed(PlayerInteractEntityEvent event) {
        Player player = event.getPlayer();
        ItemStack itemInHand = player.getItemInHand();

        if (itemInHand != null && itemInHand.getType() == Material.PAPER) {
            ItemMeta itemMeta = itemInHand.getItemMeta();

            if (itemMeta != null && itemMeta.hasDisplayName() && itemMeta.getDisplayName().equalsIgnoreCase("bandage")) {
                Entity clickedEntity = event.getRightClicked();

                if (clickedEntity instanceof Player) {
                    Player clickedPlayer = (Player) clickedEntity;
                    clickedPlayer.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 120, 0));
                    clickedPlayer.sendMessage("You were healed by " + ChatColor.GREEN + player.getName() + ".");
                    player.sendMessage("You healed " + ChatColor.of("") + clickedPlayer.getName());
                }
            }
        }
    }
    @EventHandler
    public void OnAirBandage(PlayerInteractEvent event){
        Action action = event.getAction();
        ItemStack itemInHand = event.getItem();
        if (action == Action.RIGHT_CLICK_AIR){
            if (itemInHand != null && itemInHand.getType() == Material.PAPER) {
                ItemMeta itemMeta = itemInHand.getItemMeta();

                if (itemMeta != null && itemMeta.hasDisplayName() && itemMeta.getDisplayName().equalsIgnoreCase("bandage")) {
                    event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 120, 0));
                }
            }

        }
    }
}


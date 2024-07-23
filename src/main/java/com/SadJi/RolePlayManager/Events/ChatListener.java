package com.SadJi.RolePlayManager.Events;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.awt.*;

public final class ChatListener implements Listener {

    @EventHandler
    public void RP_Check(AsyncPlayerChatEvent event) {
        String message = event.getMessage(); // получи Сообщение
        Player player = event.getPlayer(); // Получи отправителя
        String plname = player.getDisplayName(); // Получи имя игрока
        Location playerLocation = event.getPlayer().getLocation();
        int NRPdistance = 40;
        int ActionDistance = 35;
        int EnvironmentDistance = 50;
        int ShoutDistance = 35;
        int WhisperDistance = 5;
        int Distance = 20;



        if (message.startsWith("%")) {
            String[] R_Message = message.split("%", 2);
            for (Player pl : event.getRecipients()) {
                if (pl.getLocation().distance(playerLocation) <= NRPdistance) {
                    pl.sendMessage(ChatColor.of(new Color(126, 126, 126)) + "NRP: " + plname + ": " + R_Message[1]);
                    event.setCancelled(true);
                } else event.setCancelled(true);
                player.sendMessage("Никто вас не услышал");
            }

        } else if (message.startsWith("!!")) {
            String[] R_Message = message.split("!!", 2);
            Bukkit.broadcastMessage(ChatColor.of(new Color(255, 171, 236)) + plname + " " + R_Message[1]);
            event.setCancelled(true);

        } else if (message.startsWith("--")) {
            String[] R_Message = message.split("--", 3);
            for (Player pl : event.getRecipients()) {
                if (pl.getLocation().distance(playerLocation) <= ActionDistance) {
                    pl.sendMessage(ChatColor.of(new Color(248, 255, 171)) + "*" + plname + " " + R_Message[1] + "*");
                    event.setCancelled(true);
                } else {
                    event.setCancelled(true);
                }
            }
        } else if (message.startsWith("-")) {
            String[] R_Message = message.split("-", 2);
            for (Player pl : event.getRecipients()) {
                if (pl.getLocation().distance(playerLocation) <= EnvironmentDistance) {
                    pl.sendMessage(ChatColor.of(new Color(246, 246, 246)) + "**" + R_Message[1] + "**" + " " + "(" + plname + ")" );
                    event.setCancelled(true);
                } else {
                    event.setCancelled(true);
                }
            }
        } else if (message.startsWith("!")) {
            String[] R_Message = message.split("!", 2);
            for (Player pl : event.getRecipients()) {
                if (pl.getLocation().distance(playerLocation) <= ShoutDistance) {
                    pl.sendMessage(ChatColor.of("#ff5353") + "[" + "\u041a\u0440\u0438\u043a" + "]" + " " + plname + ": " + R_Message[1]);
                    event.setCancelled(true);
                } else {
                    event.setCancelled(true);
                }
            }
        } else if (message.startsWith("=")) {
            String[] R_Message = message.split("=", 2);
            for (Player pl : event.getRecipients()) {
                if (pl.getLocation().distance(playerLocation) <= WhisperDistance) {
                    pl.sendMessage(ChatColor.of("#313733") + "[" + "\u0428\u0435\u043f\u043e\u0442" + "]" + " " + plname + ": " + R_Message[1]);
                    event.setCancelled(true);
                } else {
                    event.setCancelled(true);
                }
            }
        } else {
            for (Player pl : event.getRecipients()) {
                if (pl.getLocation().distance(playerLocation) <= Distance) {
                    pl.sendMessage(ChatColor.of("#b5d2d8") + "<" + plname + ">" + ChatColor.of("#b8cbcf") + " " + message);
                    event.setCancelled(true);
                } else {
                    event.setCancelled(true);
                }
            }
        }
    }
}
/*
 * The MIT License
 *
 * Copyright 2019 Adrian.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.keinett.fishnett;

import com.keinett.fishnett.listeners.PlayerFishListener;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.ChatColor;
import org.bukkit.plugin.PluginDescriptionFile;

/**
 *
 * @author Adrian
 */
public class FishNett extends JavaPlugin {
    private final PlayerFishListener fishListener = new PlayerFishListener(this);
    
    /* TODO
    Config
    */
    private final String prefix = ChatColor.translateAlternateColorCodes('&', "&8[&3Fish&7Nett&8]");
    
    public void onEnable() {
       PluginManager pm = getServer().getPluginManager();
       pm.registerEvents(fishListener, this);
       
       PluginDescriptionFile pdfFile = this.getDescription();
       getLogger().info(ChatColor.YELLOW + pdfFile.getName() + " version " + pdfFile.getVersion() + " enabled");
    }

    public void onDisable() {
       PluginDescriptionFile pdfFile = this.getDescription();
       getLogger().info(ChatColor.YELLOW + pdfFile.getName() + " version " + pdfFile.getVersion() + " disabled");
    }
    
    public String getPrefix() {
        return this.prefix;
    }
}

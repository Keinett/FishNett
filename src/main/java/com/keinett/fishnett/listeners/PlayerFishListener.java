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
package com.keinett.fishnett.listeners;

import com.keinett.fishnett.FishNett;
import org.bukkit.entity.FishHook;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.event.player.PlayerFishEvent.State;

/**
 *
 * @author Adrian
 */
public class PlayerFishListener implements Listener {
    private final FishNett plugin;

    public PlayerFishListener(FishNett instance) {
        plugin = instance;
    }

    @EventHandler
    public void onPlayerFishEvent(PlayerFishEvent event) {
        Player p = event.getPlayer();
        
        FishHook fh = event.getHook();
        
        //Make that shit go far
        fh.setVelocity(fh.getVelocity().multiply(1.0 + Math.max(0.99, (0.25*5))));
        
        State fishstate = event.getState();
        
        switch(fishstate){
            case BITE:
                p.sendMessage(this.plugin.getPrefix() + "Something bit your lure onaynay");
                break;
            case CAUGHT_ENTITY:
                break;
            case CAUGHT_FISH:
                break;
            case FAILED_ATTEMPT:
                break;
            case FISHING:
                p.sendMessage(this.plugin.getPrefix() + "You cast the reel");
                break;
            case IN_GROUND:
                break;
            case REEL_IN:
                break;
        }
        
        plugin.getLogger().info(event.getPlayer().getName() + " did fishing stuffs onaynay");
    }

}

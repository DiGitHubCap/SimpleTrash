/*
 * A simple trash plugin for Bukkit.
 * Copyright (C) 2012 Andrew Stevanus (Hoot215) <hoot893@gmail.com>
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package me.Hoot215.SimpleTrash;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.java.JavaPlugin;

public class SimpleTrash extends JavaPlugin
  {
    public boolean onCommand (CommandSender sender, Command cmd,
      String commandLabel, String[] args)
      {
        if (cmd.getName().equals("trash"))
          {
            if ( ! (sender instanceof Player))
              {
                sender.sendMessage(ChatColor.RED + "This command can only "
                    + "be run by a player!");
                return true;
              }
            Player player = (Player) sender;
            
            if (sender.hasPermission(cmd.getPermission()))
              {
                Inventory inv =
                    this.getServer().createInventory(player, 27, "Trash");
                player.openInventory(inv);
                return true;
              }
            player.sendMessage(cmd.getPermissionMessage());
            return true;
          }
        return false;
      }
    
    @Override
    public void onDisable ()
      {
        this.getLogger().info("Is now disabled");
      }
    
    @Override
    public void onEnable ()
      {
        this.getLogger().info("Is now enabled");
      }
  }

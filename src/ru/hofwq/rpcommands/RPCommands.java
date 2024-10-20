package ru.hofwq.rpcommands;

import java.util.logging.Logger;

import org.bukkit.plugin.java.JavaPlugin;

import net.md_5.bungee.api.ChatColor;
import ru.hofwq.rpcommands.commands.ActionHandler;
import ru.hofwq.rpcommands.commands.DoCommand;
import ru.hofwq.rpcommands.commands.GetUUID;
import ru.hofwq.rpcommands.commands.MeCommand;
import ru.hofwq.rpcommands.commands.TryCommand;
import ru.hofwq.rpcommands.config.Config;

public class RPCommands extends JavaPlugin{
	public Logger log = getLogger(); 
	private static RPCommands plugin;
	
	@Override
	public void onEnable() {
		plugin = this;
		
		//Initializing config
		Config createConfig = new Config();
		createConfig.checkConfig();
		
		//Registering commands
		getCommand("me").setExecutor(new MeCommand());
		getCommand("do").setExecutor(new DoCommand());
		getCommand("try").setExecutor(new TryCommand());
		getCommand("action").setExecutor(new ActionHandler());
		getCommand("getuuid").setExecutor(new GetUUID());
		
		log.info(ChatColor.GREEN + "RPCommands enabled.");
	}
	
	@Override
	public void onDisable() {
		plugin = null;
		
		log.info(ChatColor.GREEN + "RPCommands disabled.");
	}
	
	public static RPCommands getPlugin() {
		return plugin;
	}
}

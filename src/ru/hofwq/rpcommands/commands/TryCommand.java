package ru.hofwq.rpcommands.commands;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;
import ru.hofwq.rpcommands.RPCommands;
import ru.hofwq.rpcommands.utils.Utils;

public class TryCommand implements CommandExecutor{
	public static RPCommands plugin = RPCommands.getPlugin();
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		int commandDistance = plugin.getConfig().getInt("TryCommand.Distance");
		String commandText = plugin.getConfig().getString("TryCommand.Text");
		
		Random random = new Random();
		String select = random.nextBoolean() ? "§2[§aУдачно§2] §r" : "§4[§cНеудачно§4] §r";
		
		if(!(sender instanceof Player)) {
			sender.sendMessage(ChatColor.RED + "Доступно только игрокам!");
			return true;
		}
		
		Player player = (Player) sender;
		
		if(args.length == 0) {
			player.sendMessage(ChatColor.RED + "Вы ничего не написали!");
			return true;
		}
		
		String message = String.join(" ", args);
		
		commandText = commandText.replace("&", "§");
		commandText = commandText.replace("%LPprefix%", Utils.getPlayerPrefix(player));
		commandText = commandText.replace("%player%", player.getName());
		commandText = commandText.replace("%select%", select);
		commandText = commandText.replace("%msg%", message);
		
		for(Player p : Bukkit.getOnlinePlayers()) {
			if(p.getLocation().distance(player.getLocation()) <= commandDistance) {
				p.sendMessage(commandText);
			}
		}
		
		return true;
	}
}

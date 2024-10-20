package ru.hofwq.rpcommands.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GetUUID implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] args) {
        if (cmd.getName().equalsIgnoreCase("getuuid") && args.length == 1) {
            String playerName = args[0];
            Player player = Bukkit.getServer().getPlayer(playerName);

            if (player != null) {
                String uuid = player.getUniqueId().toString();
                sender.sendMessage("UUID игрока " + playerName + ": " + uuid);
            } else {
                sender.sendMessage("Игрок с именем " + playerName + " не найден.");
            }
            return true;
        }
		return true;
	}

}

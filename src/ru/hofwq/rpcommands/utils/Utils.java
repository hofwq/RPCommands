package ru.hofwq.rpcommands.utils;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.RegisteredServiceProvider;

import net.luckperms.api.LuckPerms;
import net.luckperms.api.model.user.User;

public class Utils {
	public static String getPlayerPrefix(Player player) {
		RegisteredServiceProvider<LuckPerms> provider = Bukkit.getServicesManager().getRegistration(LuckPerms.class);

		if (provider != null) {
		    LuckPerms api = provider.getProvider();

		    User user = api.getUserManager().getUser(player.getName());

		    String prefix = user.getCachedData().getMetaData().getPrefix().replace("&", "§");
		    return prefix;
		}
		return null;
	}
}

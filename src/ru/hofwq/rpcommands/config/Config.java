package ru.hofwq.rpcommands.config;

import java.io.File;
import java.io.IOException;
import java.util.EventListener;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import ru.hofwq.rpcommands.RPCommands;

public class Config implements EventListener{
	RPCommands plugin = RPCommands.getPlugin();
	private FileConfiguration config;
	
	public void checkConfig() {
	    File configFolder = plugin.getDataFolder();
	    if (!configFolder.exists()) {
	        configFolder.mkdirs();
	    }
	    
	    File configFile = new File(configFolder, "config.yml");

	    config = new YamlConfiguration();
	    
	    if(!configFile.exists()) {
	        plugin.log.info("Config is not exists, creating.");
	        
	        try {
	            configFile.createNewFile();
	        } catch (IOException ex) {
	            ex.printStackTrace();
	        }
	    }
	    
	    try {
	        config.load(configFile);
	    } catch (IOException | InvalidConfigurationException e) {
	        e.printStackTrace();
	    }
	    
	    createStringLists();
	}
	
	private void createStringLists() {
		File configFile = new File(plugin.getDataFolder(), "config.yml");
		
		if(!config.contains("MeCommand.Distance")){
		    config.set("MeCommand.Distance", 50);
		}
		
		if(!config.contains("MeCommand.Text")){
		    config.set("MeCommand.Text", "&2%LPprefix%%player% &a");
		}

		if(!config.contains("DoCommand.Distance")){
		    config.set("DoCommand.Distance", 50);
		}
		
		if(!config.contains("DoCommand.Text")){
		    config.set("DoCommand.Text", "&a- &e%msg% &a(&2%player%&a)");
		}
		
		if(!config.contains("TryCommand.Distance")){
		    config.set("TryCommand.Distance", 50);
		}
		
		if(!config.contains("TryCommand.Text")){
		    config.set("TryCommand.Text", "&a(Попытка) &2%player% &e%msg%&a %select%");
		}
		
		saveConfig(configFile);
	}
	
    private void saveConfig(File configFile) {
        try {
            config.save(configFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

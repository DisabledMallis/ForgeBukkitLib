package com.DisabledMallis.KettleLib;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{
	@Override
	public void onEnable() {
		new Log("Loading KettleLib...");
		try {
			Class.forName("net.minecraftforge.common.ForgeVersion");
			new Log("Found Forge!");
			new Log("Checking for Kettle...");
			try {
				Class.forName("kettlefoundation.kettle.KettleVersionCommand");
				new Log("Kettle found!");
			}
			catch(ClassNotFoundException ex) {
				new Log("Couldn't find Kettle. Disabling...");
				Bukkit.getPluginManager().disablePlugin(this);
			}
		}
		catch(ClassNotFoundException ex) {
			new Log("Couldn't find Forge. Disabling...");
			Bukkit.getPluginManager().disablePlugin(this);
		}
	}
	
	@Override
	public void onDisable() {
		new Log("if the plugin was disabled due to an error, please report it here: https://github.com/DisabledMallis/KettleLib/issues");
	}
}

package com.DisabledMallis.FBLib;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{
	boolean Kettle;
	boolean Lava;
	@Override
	public void onEnable() {
		new Log("Loading ForgeBukkitLib...");
		try {
			Class.forName("net.minecraftforge.common.ForgeVersion");
			new Log("Found Forge!");
			new Log("Checking for Kettle...");
			try {
				Class.forName("kettlefoundation.kettle.KettleVersionCommand");
				new Log("Kettle found!");
			}
			catch(ClassNotFoundException ex) {
				new Log("Couldn't find Kettle.");
				Kettle = false;
			}
			try {
				Class.forName("org.lavapowered.lava.LavaInternal");
				new Log("LavaPowered found!");
			}
			catch(ClassNotFoundException ex) {
				new Log("Couldn't find LavaPowered.");
				Lava = false;
			}
			if(Kettle == false && Lava == false) {
				new Log("Unknown Forge Bukkit hybrid. Disabling...");
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

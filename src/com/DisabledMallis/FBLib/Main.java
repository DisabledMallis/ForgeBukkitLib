package com.DisabledMallis.FBLib;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{
	public static boolean Kettle;
	public static boolean Lava14;
	public static boolean Lava;
	@Override
	public void onEnable() {
		new Log("Loading ForgeBukkitLib...");
		new Log("Server version: " + Bukkit.getVersion());
		new Log("Bukkit version: " + Bukkit.getBukkitVersion());
		try {
			Class.forName("net.minecraftforge.common.ForgeVersion");
			new Log("Found Forge!");
			new Log("Checking for Kettle...");
			try {
				Class.forName("kettlefoundation.kettle.KettleVersionCommand");
				new Log("Kettle found!");
				Kettle = true;
			}
			catch(ClassNotFoundException ex) {
				new Log("Couldn't find Kettle.");
				Kettle = false;
			}
			new Log("Checking for LavaPowered 1.14.4...");
			try {
				Class.forName("org.lavapowered.lava.LavaInternal");
				new Log("LavaPowered 1.14.4 found!");
				Lava14 = true;
			}
			catch(ClassNotFoundException ex) {
				new Log("Couldn't find LavaPowered 1.14.4.");
				Lava14 = false;
			}
			new Log("Checking for Lava...");
			if(Bukkit.getVersion().contains("Lava")) {
				new Log("LavaPowered found!");
				Lava = true;
			} else {
				new Log("Couldn't find LavaPowered.");
				Lava = false;
			}
			if(Kettle == false && Lava14 == false && Lava == false) {
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

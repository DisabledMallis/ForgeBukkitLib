package com.DisabledMallis.FBLib.API;

import com.DisabledMallis.FBLib.Main;

public class FBL {
	public FBL() {
	}
	
	public boolean isKettle() {
		return Main.Kettle;
	}
	public boolean isLava(LavaVersion version) {
		if(version == LavaVersion.MC1_12_2) {
			return Main.Lava;
		} else if (version == LavaVersion.MC1_14_4) {
			return Main.Lava14;
		}
		return false;
	}
}

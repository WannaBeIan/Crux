package com.upfault.crux.client;

import com.upfault.crux.keybindings.CruxKeybindings;
import net.fabricmc.api.ClientModInitializer;

public class CruxClient implements ClientModInitializer {

	@Override
	public void onInitializeClient() {
		new CruxKeybindings().onInitializeClient();
	}
}

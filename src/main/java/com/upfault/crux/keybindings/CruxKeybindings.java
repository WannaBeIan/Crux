package com.upfault.crux.keybindings;

import com.upfault.crux.config.CruxConfigManager;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

public class CruxKeybindings implements ClientModInitializer {

	private KeyBinding openConfigKey;

	@Override
	public void onInitializeClient() {
		openConfigKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
				"key.crux.config", InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_O, "key.category.crux"
		));

		ClientTickEvents.END_CLIENT_TICK.register(client -> {
			while (openConfigKey.wasPressed()) {
				client.setScreen(CruxConfigManager.createGUI(client.currentScreen));
			}
		});
	}
}

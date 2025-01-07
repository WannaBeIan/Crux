package com.upfault.crux;

import com.upfault.crux.config.CruxConfigManager;
import com.upfault.crux.features.*;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;

public class Crux implements ModInitializer {

	private CoordinatesHUD coordinatesHUDFeature;
	private ArmorHUD armorHUD;
	private XPProgressHUD xpProgressHUD;
	private ToolDurabilityHUD toolDurabilityHUD;
	private PotionEffectsHUD potionEffectsHUD;
	private FoodSaturationHUD foodSaturationHUD;

	@Override
	public void onInitialize() {
		CruxConfigManager.init();
		coordinatesHUDFeature = new CoordinatesHUD();
		armorHUD = new ArmorHUD();
		xpProgressHUD = new XPProgressHUD();
		toolDurabilityHUD = new ToolDurabilityHUD();
		potionEffectsHUD = new PotionEffectsHUD();
		foodSaturationHUD = new FoodSaturationHUD();

		HudRenderCallback.EVENT.register((context, tickDelta) -> {
			coordinatesHUDFeature.render(context);
			armorHUD.render(context);
			xpProgressHUD.render(context);
			toolDurabilityHUD.render(context);
			potionEffectsHUD.render(context);
			foodSaturationHUD.render(context);
		});

	}
}

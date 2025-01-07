package com.upfault.crux;

import com.upfault.crux.config.CruxConfigManager;
import com.upfault.crux.features.CoordinatesFeature;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;

public class Crux implements ModInitializer {

	private CoordinatesFeature coordinatesFeature;

	@Override
	public void onInitialize() {
		CruxConfigManager.init();
		coordinatesFeature = new CoordinatesFeature(CruxConfigManager.getConfig());

		HudRenderCallback.EVENT.register((context, tickDelta) -> coordinatesFeature.render(context));

	}
}

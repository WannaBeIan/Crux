package com.upfault.crux.features;

import com.upfault.crux.config.configs.CoordinatesConfig;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.util.math.BlockPos;

public class CoordinatesFeature {

	private final CoordinatesConfig config;

	public CoordinatesFeature(CoordinatesConfig config) {
		this.config = config;
	}

	public void render(DrawContext context) {
		MinecraftClient client = MinecraftClient.getInstance();
		if (client.player != null) {
			BlockPos pos = client.player.getBlockPos();
			String coordinates = "X: " + pos.getX() + " Y: " + pos.getY() + " Z: " + pos.getZ();
			context.drawText(client.textRenderer, coordinates, 10, config.getYPosition(), 0xFFFFFF, true);
		}
	}
}

package com.upfault.crux.features;

import com.upfault.crux.config.CruxConfigManager;
import com.upfault.crux.config.configs.XPProgressHUDConfig;
import com.upfault.crux.utils.ColorUtils;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;

public class XPProgressHUD {

	XPProgressHUDConfig config = CruxConfigManager.getXPProgressHUDConfig();

	public void render(DrawContext context) {
		MinecraftClient client = MinecraftClient.getInstance();
		var player = client.player;

		if (player != null) {
			int level = player.experienceLevel;
			float progress = player.experienceProgress * 100;

			String xpText = "Level: " + level + " (" + String.format("%.1f", progress) + "%)";

			float scale = 1.0F + (config.getScale() - 1.0F) / 10.0F;
			int xpTextColor = config.isRainbowEffect()
					? ColorUtils.getRainbowColor(System.currentTimeMillis())
					: config.getXpTextColor() | 0xFF000000;

			context.getMatrices().push();
			context.getMatrices().scale(scale, scale, 1.0F);

			int maxX = (int) (client.getWindow().getScaledWidth() / scale);
			int maxY = (int) (client.getWindow().getScaledHeight() / scale);

			int x = Math.max(0, Math.min(config.getXPosition(), maxX - client.textRenderer.getWidth(xpText)));
			int y = Math.max(0, Math.min(config.getYPosition(), maxY - client.textRenderer.fontHeight));

			context.drawText(client.textRenderer, xpText, x, y, xpTextColor, true);
			context.getMatrices().pop();
		}
	}
}

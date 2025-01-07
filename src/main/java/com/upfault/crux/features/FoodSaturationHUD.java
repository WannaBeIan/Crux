package com.upfault.crux.features;

import com.upfault.crux.config.CruxConfigManager;
import com.upfault.crux.config.configs.FoodSaturationHUDConfig;
import com.upfault.crux.utils.ColorUtils;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;

public class FoodSaturationHUD {

	private final FoodSaturationHUDConfig config = CruxConfigManager.getFoodSaturationHUDConfig();
	public void render(DrawContext context) {

		MinecraftClient client = MinecraftClient.getInstance();

		var player = client.player;

		int barColor = config.isRainbowEffect()
				? ColorUtils.getRainbowColor(System.currentTimeMillis())
				: config.getSaturationBarColor() | 0xFF000000;

		if (player != null) {
			float saturation = player.getHungerManager().getSaturationLevel();
			int barWidth = (int) (81 * (saturation / 20));

			int x = client.getWindow().getScaledWidth() / 2 + 10;
			int y = client.getWindow().getScaledHeight() - 40;

			context.fill(x, y - 2, x + 80, y, 0xFF000000);
			context.fill(x, y - 2, x + barWidth, y, barColor);
		}
	}
}

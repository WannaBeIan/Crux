package com.upfault.crux.features;

import com.upfault.crux.config.CruxConfigManager;
import com.upfault.crux.config.configs.ToolDurabilityHUDConfig;
import com.upfault.crux.utils.ColorUtils;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.item.ItemStack;

public class ToolDurabilityHUD {

	private final ToolDurabilityHUDConfig config = CruxConfigManager.getToolDurabilityHUDConfig();

	public void render(DrawContext context) {
		MinecraftClient client = MinecraftClient.getInstance();
		var player = client.player;

		if (player != null) {

			ItemStack heldItem = player.getMainHandStack();

			if (!heldItem.isEmpty() && heldItem.isDamageable()) {

				float scale = 1.0F + (config.getScale() - 1.0F) / 10.0F;
				int durability = heldItem.getMaxDamage() - heldItem.getDamage();
				int maxDurability = heldItem.getMaxDamage();
				int barWidth = (int) (13 * ((float) durability / maxDurability) * scale);


				int durabilityBarColor = config.isRainbowEffect()
						? ColorUtils.getRainbowColor(System.currentTimeMillis())
						: config.getDurabilityBarColor() | 0xFF000000;

				int scaledIconSize = (int) (16 * scale);
				int scaledPadding = (int) (2 * scale);
				int scaledBarHeight = (int) (2 * scale);
				int scaledBarLength = (int) (13 * scale);

				int maxY = client.getWindow().getScaledHeight();
				int maxX = client.getWindow().getScaledWidth();

				int baseX = Math.min(config.getXPosition(), maxX - scaledIconSize - scaledBarLength);
				int baseY = Math.min(config.getYPosition(), maxY - scaledIconSize - scaledBarHeight);

				context.getMatrices().push();
				context.getMatrices().translate(baseX, baseY, 0);
				context.getMatrices().scale(scale, scale, 1.0F);
				context.drawItem(heldItem, 0, 0);
				context.getMatrices().pop();

				int barX = baseX + scaledIconSize + scaledPadding;
				int barY = baseY + (scaledIconSize / 2) - (scaledBarHeight / 2);

				context.fill(barX + 1, barY + 1, barX + (int) (13 * scale) + 1, barY + scaledBarHeight + 1, 0xAA000000);

				context.fill(barX, barY, barX + barWidth, barY + scaledBarHeight, durabilityBarColor);

			}
		}
	}
}

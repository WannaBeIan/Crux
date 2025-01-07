package com.upfault.crux.features;

import com.upfault.crux.config.CruxConfigManager;
import com.upfault.crux.config.configs.ArmorHUDConfig;
import com.upfault.crux.utils.ColorUtils;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.item.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class ArmorHUD {

	ArmorHUDConfig config = CruxConfigManager.getArmorHUDConfig();

	public void render(DrawContext context) {
		MinecraftClient client = MinecraftClient.getInstance();
		var player = client.player;

		if (player != null) {
			int iconSize = 16;
			int padding = 2;
			int barHeight = 2;

			float scale = 1.0F + (config.getScale() - 1.0F) / 10.0F;

			int scaledIconSize = (int) (iconSize * scale);
			int scaledPadding = (int) (padding * scale);
			int scaledBarHeight = (int) (barHeight * scale);

			int durabilityBarColor = config.isRainbowEffect()
					? ColorUtils.getRainbowColor(System.currentTimeMillis())
					: config.getDurabilityBarColor() | 0xFF000000;

			int maxY = client.getWindow().getScaledHeight();
			int maxX = client.getWindow().getScaledWidth();

			List<ItemStack> armorList = new ArrayList<>();
			player.getArmorItems().forEach(armorList::add);
			java.util.Collections.reverse(armorList);

			int equippedArmorCount = 0;
			for (ItemStack armor : armorList) {
				if (!armor.isEmpty()) {
					equippedArmorCount++;
				}
			}

			int totalHeight = (scaledIconSize + scaledPadding) * equippedArmorCount - scaledPadding;

			int maxBaseY = maxY - totalHeight;
			int baseX = Math.min(config.getXPosition(), maxX - scaledIconSize - (int) (18 * scale));

			int currentY = Math.min(config.getYPosition(), maxBaseY);
			for (ItemStack armor : armorList) {
				if (!armor.isEmpty()) {
					int durability = armor.getMaxDamage() - armor.getDamage();
					int barWidth = (int) (13 * ((float) durability / armor.getMaxDamage()) * scale);

					context.getMatrices().push();
					context.getMatrices().translate(baseX, currentY, 0);
					context.getMatrices().scale(scale, scale, 1.0F);

					context.drawItem(armor, 0, 0);

					context.getMatrices().pop();

					int barX = baseX + (int) (18 * scale);

					int barY = currentY + (scaledIconSize / 2) - (scaledBarHeight / 2);

					context.fill(barX + 1, barY + 1, barX + (int) (13 * scale) + 1, barY + scaledBarHeight + 1, 0xAA000000);

					context.fill(barX, barY, barX + barWidth, barY + scaledBarHeight, durabilityBarColor);

					currentY += scaledIconSize + scaledPadding;
				}
			}
		}
	}

}

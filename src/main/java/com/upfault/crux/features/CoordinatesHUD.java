package com.upfault.crux.features;

import com.upfault.crux.config.CruxConfigManager;
import com.upfault.crux.config.configs.CoordinatesConfig;
import com.upfault.crux.utils.ColorUtils;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.util.math.BlockPos;

import java.util.ArrayList;
import java.util.List;

public class CoordinatesHUD {

	private final CoordinatesConfig config = CruxConfigManager.getCoordinatesConfig();

	public void render(DrawContext context) {
		MinecraftClient client = MinecraftClient.getInstance();

		if (client.player != null) {
			BlockPos pos = client.player.getBlockPos();
			String coordinates = "X: " + pos.getX() + " Y: " + pos.getY() + " Z: " + pos.getZ();

			float scale = 1.0F + (config.getScale() - 1.0F) / 10.0F;
			int coordinatesColor = config.isRainbowEffect()
					? ColorUtils.getRainbowColor(System.currentTimeMillis())
					: config.getCoordinateColor() | 0xFF000000;

			context.getMatrices().push();
			context.getMatrices().scale(scale, scale, 1.0F);

			int maxX = (int) (client.getWindow().getScaledWidth() / scale);
			int maxY = (int) (client.getWindow().getScaledHeight() / scale);

			List<String> lines = wrapText(client.textRenderer, coordinates, maxX - config.getXPosition());
			int totalTextHeight = lines.size() * client.textRenderer.fontHeight;

			int x = Math.max(0, Math.min(config.getXPosition(), maxX - client.textRenderer.getWidth(coordinates)));
			int y = Math.max(0, Math.min(config.getYPosition(), maxY - totalTextHeight));

			for (String line : lines) {
				int lineWidth = client.textRenderer.getWidth(line);
				int adjustedX = Math.min(x, maxX - lineWidth);

				context.drawText(client.textRenderer, line, adjustedX, y, coordinatesColor, true);
				y += client.textRenderer.fontHeight;
			}

			context.getMatrices().pop();
		}
	}

	private List<String> wrapText(net.minecraft.client.font.TextRenderer textRenderer, String text, int maxWidth) {
		List<String> lines = new ArrayList<>();
		String[] words = text.split(" ");
		StringBuilder currentLine = new StringBuilder();

		for (String word : words) {
			String testLine = currentLine.isEmpty() ? word : currentLine + " " + word;
			if (textRenderer.getWidth(testLine) <= maxWidth) {
				currentLine.append(currentLine.isEmpty() ? word : " " + word);
			} else {
				lines.add(currentLine.toString());
				currentLine = new StringBuilder(word);
			}
		}
		if (!currentLine.isEmpty()) {
			lines.add(currentLine.toString());
		}

		return lines;
	}
}

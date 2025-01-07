package com.upfault.crux.features;

import com.upfault.crux.config.CruxConfigManager;
import com.upfault.crux.utils.ColorUtils;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;

import java.util.HashMap;
import java.util.Map;

public class PotionEffectsHUD {

	private static final Map<StatusEffect, ItemStack> effectIcons = new HashMap<>();

	static {
		initializeEffectIcons();
	}

	private static void initializeEffectIcons() {
		effectIcons.put(StatusEffects.REGENERATION.value(), new ItemStack(Items.GOLDEN_APPLE));
		effectIcons.put(StatusEffects.SPEED.value(), new ItemStack(Items.SUGAR));
		effectIcons.put(StatusEffects.STRENGTH.value(), new ItemStack(Items.BLAZE_POWDER));
		effectIcons.put(StatusEffects.RESISTANCE.value(), new ItemStack(Items.IRON_INGOT));
		effectIcons.put(StatusEffects.FIRE_RESISTANCE.value(), new ItemStack(Items.MAGMA_CREAM));
		effectIcons.put(StatusEffects.WATER_BREATHING.value(), new ItemStack(Items.TURTLE_HELMET));
		effectIcons.put(StatusEffects.INVISIBILITY.value(), new ItemStack(Items.GLASS_BOTTLE));
		effectIcons.put(StatusEffects.NIGHT_VISION.value(), new ItemStack(Items.SPIDER_EYE));
		effectIcons.put(StatusEffects.WEAKNESS.value(), new ItemStack(Items.FERMENTED_SPIDER_EYE));
		effectIcons.put(StatusEffects.POISON.value(), new ItemStack(Items.POISONOUS_POTATO));
		effectIcons.put(StatusEffects.HASTE.value(), new ItemStack(Items.GOLDEN_PICKAXE));

		Registries.STATUS_EFFECT.streamEntries().forEach(entry -> {
			StatusEffect effect = entry.value();
			effectIcons.putIfAbsent(effect, new ItemStack(Items.POTION));
		});
	}

	public void render(DrawContext context) {
		MinecraftClient client = MinecraftClient.getInstance();
		var player = client.player;

		if (player != null) {
			var config = CruxConfigManager.getPotionEffectsHUDConfig();

			float scale = 1.0F + (config.getScale() - 1.0F) / 10.0F;
			int scaledIconSize = (int) (16 * scale);
			int scaledPadding = (int) (2 * scale);
			int textOffsetX = (int) (18 * scale);
			int textOffsetY = (int) (4 * scale);
			int ySpacing = scaledIconSize + scaledPadding;

			int maxX = client.getWindow().getScaledWidth();
			int maxY = client.getWindow().getScaledHeight();
			int x = Math.min(config.getXPosition(), maxX - scaledIconSize - textOffsetX);
			int y = Math.min(config.getYPosition(), maxY - ySpacing * player.getStatusEffects().size());

			var effects = player.getStatusEffects().stream()
					.sorted((a, b) -> {
						if (config.isRenderStatusAZ()) {
							return a.getEffectType().value().getTranslationKey()
									.compareTo(b.getEffectType().value().getTranslationKey());
						}
						if (config.isRenderStatusZA()) {
							return b.getEffectType().value().getTranslationKey()
									.compareTo(a.getEffectType().value().getTranslationKey());
						}
						return 0;
					})
					.toList();

			for (StatusEffectInstance effect : effects) {
				StatusEffect statusEffect = effect.getEffectType().value();
				ItemStack icon = effectIcons.getOrDefault(statusEffect, new ItemStack(Items.POTION));

				context.getMatrices().push();
				context.getMatrices().translate(x, y, 0);
				context.getMatrices().scale(scale, scale, 1.0F);
				context.drawItem(icon, 0, 0);
				context.getMatrices().pop();

				int durationTicks = effect.getDuration();
				String duration = durationTicks < 0
						? "∞"
						: String.format("%d:%02d", durationTicks / 1200, (durationTicks / 20) % 60);

				int textColor = config.isRainbowEffect()
						? ColorUtils.getRainbowColor(System.currentTimeMillis())
						: config.getTextColor();

				context.getMatrices().push();
				context.getMatrices().translate(x + textOffsetX, y + textOffsetY, 0);
				context.getMatrices().scale(scale, scale, 1.0F);
				context.drawText(client.textRenderer, duration, 0, 0, textColor, true);
				context.getMatrices().pop();

				y += ySpacing;
			}
		}
	}
}

package com.upfault.crux.config;

import com.upfault.crux.config.category.UIAndVisualCategory;
import com.upfault.crux.config.configs.*;
import com.upfault.crux.features.FoodSaturationHUD;
import com.upfault.crux.features.XPProgressHUD;
import dev.isxander.yacl3.api.YetAnotherConfigLib;
import dev.isxander.yacl3.config.v2.api.ConfigClassHandler;
import dev.isxander.yacl3.config.v2.api.serializer.GsonConfigSerializerBuilder;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;

import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

public class CruxConfigManager {

	private static final Path CONFIG_PATH = FabricLoader.getInstance().getConfigDir().resolve("crux.json");

	private static final ConfigClassHandler<CoordinatesConfig> COORDINATES_HANDLER = ConfigClassHandler.createBuilder(CoordinatesConfig.class)
			.serializer(config -> GsonConfigSerializerBuilder.create(config).setPath(CONFIG_PATH).build())
			.build();

	private static final ConfigClassHandler<ArmorHUDConfig> ARMOR_HUD_HANDLER = ConfigClassHandler.createBuilder(ArmorHUDConfig.class)
			.serializer(config -> GsonConfigSerializerBuilder.create(config).setPath(CONFIG_PATH).build())
			.build();

	private static final ConfigClassHandler<XPProgressHUDConfig> XP_HUD_HANDLER = ConfigClassHandler.createBuilder(XPProgressHUDConfig.class)
			.serializer(config -> GsonConfigSerializerBuilder.create(config).setPath(CONFIG_PATH).build())
			.build();

	private static final ConfigClassHandler<ToolDurabilityHUDConfig> TOOL_DURABILITY_HUD_HANDLER = ConfigClassHandler.createBuilder(ToolDurabilityHUDConfig.class)
			.serializer(config -> GsonConfigSerializerBuilder.create(config).setPath(CONFIG_PATH).build())
			.build();

	private static final ConfigClassHandler<PotionEffectsHUDConfig> POTION_EFFECTS_HUD_HANDLER = ConfigClassHandler.createBuilder(PotionEffectsHUDConfig.class)
			.serializer(config -> GsonConfigSerializerBuilder.create(config).setPath(CONFIG_PATH).build())
			.build();

	private static final ConfigClassHandler<FoodSaturationHUDConfig> FOOD_SATURATION_HUD_HANDLER = ConfigClassHandler.createBuilder(FoodSaturationHUDConfig.class)
			.serializer(config -> GsonConfigSerializerBuilder.create(config).setPath(CONFIG_PATH).build())
			.build();

	public static CoordinatesConfig getCoordinatesConfig() {
		return COORDINATES_HANDLER.instance();
	}

	public static ArmorHUDConfig getArmorHUDConfig() {
		return ARMOR_HUD_HANDLER.instance();
	}

	public static XPProgressHUDConfig getXPProgressHUDConfig() {
		return XP_HUD_HANDLER.instance();
	}

	public static ToolDurabilityHUDConfig getToolDurabilityHUDConfig() {
		return TOOL_DURABILITY_HUD_HANDLER.instance();
	}

	public static PotionEffectsHUDConfig getPotionEffectsHUDConfig() {
		return POTION_EFFECTS_HUD_HANDLER.instance();
	}

	public static FoodSaturationHUDConfig getFoodSaturationHUDConfig() {
		return FOOD_SATURATION_HUD_HANDLER.instance();
	}

	public static void init() {
		COORDINATES_HANDLER.load();
		ARMOR_HUD_HANDLER.load();
		XP_HUD_HANDLER.load();
		TOOL_DURABILITY_HUD_HANDLER.load();
		POTION_EFFECTS_HUD_HANDLER.load();
		FOOD_SATURATION_HUD_HANDLER.load();
	}

	public static void save() {
		COORDINATES_HANDLER.save();
		ARMOR_HUD_HANDLER.save();
		XP_HUD_HANDLER.save();
		TOOL_DURABILITY_HUD_HANDLER.save();
		POTION_EFFECTS_HUD_HANDLER.save();
		FOOD_SATURATION_HUD_HANDLER.save();
	}

	public static Screen createGUI(Screen parent) {
		var coordinatesDefaults = new CoordinatesConfig();
		var coordinatesConfig = getCoordinatesConfig();
		var armorHUDDefaults = new ArmorHUDConfig();
		var armorHUDConfig = getArmorHUDConfig();
		var xpProgressHUDDefaults = new XPProgressHUDConfig();
		var xpProgressHUDConfig = getXPProgressHUDConfig();
		var toolDurabilityDefaults = new ToolDurabilityHUDConfig();
		var toolDurabilityConfig = getToolDurabilityHUDConfig();
		var potionEffectsDefaults = new PotionEffectsHUDConfig();
		var potionEffectsConfig = getPotionEffectsHUDConfig();
		var foodSaturationHUDDefaults = new FoodSaturationHUDConfig();
		var foodSaturationHUDConfig = getFoodSaturationHUDConfig();

		var groups = Arrays.asList(
				ConfigBuilders.buildCoordinatesGroup(coordinatesDefaults, coordinatesConfig),
				ConfigBuilders.buildArmorHUDGroup(armorHUDDefaults, armorHUDConfig),
				ConfigBuilders.buildXPProgressHUD(xpProgressHUDDefaults, xpProgressHUDConfig),
				ConfigBuilders.buildToolDurabilityHUD(toolDurabilityDefaults, toolDurabilityConfig),
				ConfigBuilders.buildPotionEffectsHUDGroup(potionEffectsDefaults, potionEffectsConfig),
				ConfigBuilders.buildFoodSaturationHUDGroup(foodSaturationHUDDefaults, foodSaturationHUDConfig)
		);

		return YetAnotherConfigLib.create(COORDINATES_HANDLER, (defaultInstance, currentConfig, builder) -> {
			builder.title(Text.of("Crux Configuration"))
					.category(UIAndVisualCategory.create(groups));
			return builder;
		}).generateScreen(parent);
	}
}

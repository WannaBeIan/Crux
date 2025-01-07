package com.upfault.crux.config;

import com.upfault.crux.config.category.UIAndVisualCategory;
import com.upfault.crux.config.configs.*;
import com.upfault.crux.config.controllers.IntegerColorControllerBuilder;
import dev.isxander.yacl3.api.Option;
import dev.isxander.yacl3.api.OptionDescription;
import dev.isxander.yacl3.api.StateManager;
import dev.isxander.yacl3.api.controller.BooleanControllerBuilder;
import dev.isxander.yacl3.api.controller.IntegerSliderControllerBuilder;
import net.minecraft.client.MinecraftClient;
import net.minecraft.text.Text;

public class ConfigBuilders {

	public static UIAndVisualCategory.ConfigGroup buildCoordinatesGroup(CoordinatesConfig defaults, CoordinatesConfig config) {
		var group = new UIAndVisualCategory.ConfigGroup("config.category.uiAndVisual.coordinatesDisplay");

		group.getBuilder()
				.option(Option.<Integer>createBuilder()
						.name(Text.translatable("config.category.uiAndVisual.coordinatesDisplay.xPos"))
						.description(OptionDescription.of(Text.translatable("config.category.uiAndVisual.coordinatesDisplay.xPos.@Tooltip")))
						.stateManager(StateManager.createInstant(defaults.getXPosition(), config::getXPosition, config::setXPosition))
						.controller(opt -> {
							int maxX = MinecraftClient.getInstance().getWindow().getScaledWidth();
							return IntegerSliderControllerBuilder.create(opt).range(0, maxX).step(1);
						})
						.build())

				.option(Option.<Integer>createBuilder()
						.name(Text.translatable("config.category.uiAndVisual.coordinatesDisplay.yPos"))
						.description(OptionDescription.of(Text.translatable("config.category.uiAndVisual.coordinatesDisplay.yPos.@Tooltip")))
						.stateManager(StateManager.createInstant(defaults.getYPosition(), config::getYPosition, config::setYPosition))
						.controller(opt -> {
							int maxY = MinecraftClient.getInstance().getWindow().getScaledHeight();
							return IntegerSliderControllerBuilder.create(opt).range(0, maxY).step(1);
						})
						.build())

				.option(Option.<Integer>createBuilder()
						.name(Text.translatable("config.category.uiAndVisual.coordinatesDisplay.scale"))
						.description(OptionDescription.of(Text.translatable("config.category.uiAndVisual.coordinatesDisplay.scale.@Tooltip")))
						.stateManager(StateManager.createInstant(defaults.getScale(), config::getScale, config::setScale))
						.controller(opt -> {
							int maxScale = 10;
							return IntegerSliderControllerBuilder.create(opt).range(1, maxScale).step(1);
						})
						.build())

				.option(Option.<Integer>createBuilder()
						.name(Text.translatable("config.category.uiAndVisual.coordinatesDisplay.coordinatesColor"))
						.description(OptionDescription.of(Text.translatable("config.category.uiAndVisual.coordinatesDisplay.coordinatesColor.@Tooltip")))
						.stateManager(StateManager.createInstant(
								defaults.getCoordinateColor(),
								config::getCoordinateColor,
								config::setCoordinateColor))
						.controller(IntegerColorControllerBuilder::create)
						.build())
				.option(Option.<Boolean>createBuilder()
						.name(Text.translatable("config.category.uiAndVisual.coordinatesDisplay.rainbowEffect"))
						.description(OptionDescription.of(Text.translatable("config.category.uiAndVisual.coordinatesDisplay.rainbowEffect.@Tooltip")))
						.stateManager(StateManager.createInstant(defaults.isRainbowEffect(), config::isRainbowEffect, config::setRainbowEffect))
						.controller(BooleanControllerBuilder::create)
						.build());
		return group;
	}

	public static UIAndVisualCategory.ConfigGroup buildArmorHUDGroup(ArmorHUDConfig defaults, ArmorHUDConfig config) {
		var group = new UIAndVisualCategory.ConfigGroup("config.category.uiAndVisual.armorHUD");

		group.getBuilder()
				.option(Option.<Integer>createBuilder()
						.name(Text.translatable("config.category.uiAndVisual.armorHUD.xPos"))
						.description(OptionDescription.of(Text.translatable("config.category.uiAndVisual.armorHUD.xPos.@Tooltip")))
						.stateManager(StateManager.createInstant(defaults.getXPosition(), config::getXPosition, config::setXPosition))
						.controller(opt -> {
							int maxX = MinecraftClient.getInstance().getWindow().getScaledWidth();
							return IntegerSliderControllerBuilder.create(opt).range(0, maxX).step(1);
						})
						.build())
				.option(Option.<Integer>createBuilder()
						.name(Text.translatable("config.category.uiAndVisual.armorHUD.yPos"))
						.description(OptionDescription.of(Text.translatable("config.category.uiAndVisual.armorHUD.yPos.@Tooltip")))
						.stateManager(StateManager.createInstant(defaults.getYPosition(), config::getYPosition, config::setYPosition))
						.controller(opt -> {
							int maxX = MinecraftClient.getInstance().getWindow().getScaledHeight();
							return IntegerSliderControllerBuilder.create(opt).range(0, maxX).step(1);
						})
						.build())
				.option(Option.<Integer>createBuilder()
						.name(Text.translatable("config.category.uiAndVisual.armorHUD.scale"))
						.description(OptionDescription.of(Text.translatable("config.category.uiAndVisual.armorHUD.scale.@Tooltip")))
						.stateManager(StateManager.createInstant(defaults.getScale(), config::getScale, config::setScale))
						.controller(opt -> {
							int maxScale = 10;
							return IntegerSliderControllerBuilder.create(opt).range(1, maxScale).step(1);
						})
						.build())
				.option(Option.<Integer>createBuilder()
						.name(Text.translatable("config.category.uiAndVisual.armorHUD.durabilityBarColor"))
						.description(OptionDescription.of(Text.translatable("config.category.uiAndVisual.armorHUD.durabilityBarColor.@Tooltip")))
						.stateManager(StateManager.createInstant(
								defaults.getDurabilityBarColor(),
								config::getDurabilityBarColor,
								config::setDurabilityBarColor))
						.controller(IntegerColorControllerBuilder::create)
						.build())
				.option(Option.<Boolean>createBuilder()
						.name(Text.translatable("config.category.uiAndVisual.armorHUD.rainbowEffect"))
						.description(OptionDescription.of(Text.translatable("config.category.uiAndVisual.armorHUD.rainbowEffect.@Tooltip")))
						.stateManager(StateManager.createInstant(defaults.isRainbowEffect(), config::isRainbowEffect, config::setRainbowEffect))
						.controller(BooleanControllerBuilder::create)
						.build());
		return group;
	}

	public static UIAndVisualCategory.ConfigGroup buildXPProgressHUD(XPProgressHUDConfig defaults, XPProgressHUDConfig config) {
		var group = new UIAndVisualCategory.ConfigGroup("config.category.uiAndVisual.xpProgressHUD");

		group.getBuilder()
				.option(Option.<Integer>createBuilder()
						.name(Text.translatable("config.category.uiAndVisual.xpProgressHUD.xPos"))
						.description(OptionDescription.of(Text.translatable("config.category.uiAndVisual.xpProgressHUD.xPos.@Tooltip")))
						.stateManager(StateManager.createInstant(defaults.getXPosition(), config::getXPosition, config::setXPosition))
						.controller(opt -> {
							int maxX = MinecraftClient.getInstance().getWindow().getScaledWidth();
							return IntegerSliderControllerBuilder.create(opt).range(0, maxX).step(1);
						})
						.build())
				.option(Option.<Integer>createBuilder()
						.name(Text.translatable("config.category.uiAndVisual.xpProgressHUD.yPos"))
						.description(OptionDescription.of(Text.translatable("config.category.uiAndVisual.xpProgressHUD.yPos.@Tooltip")))
						.stateManager(StateManager.createInstant(defaults.getYPosition(), config::getYPosition, config::setYPosition))
						.controller(opt -> {
							int maxX = MinecraftClient.getInstance().getWindow().getScaledHeight();
							return IntegerSliderControllerBuilder.create(opt).range(0, maxX).step(1);
						})
						.build())
				.option(Option.<Integer>createBuilder()
						.name(Text.translatable("config.category.uiAndVisual.xpProgressHUD.scale"))
						.description(OptionDescription.of(Text.translatable("config.category.uiAndVisual.xpProgressHUD.scale.@Tooltip")))
						.stateManager(StateManager.createInstant(defaults.getScale(), config::getScale, config::setScale))
						.controller(opt -> {
							int maxScale = 10;
							return IntegerSliderControllerBuilder.create(opt).range(1, maxScale).step(1);
						})
						.build())
				.option(Option.<Integer>createBuilder()
						.name(Text.translatable("config.category.uiAndVisual.xpProgressHUD.setXpTextColor"))
						.description(OptionDescription.of(Text.translatable("config.category.uiAndVisual.xpProgressHUD.setXpTextColor.@Tooltip")))
						.stateManager(StateManager.createInstant(
								defaults.getXpTextColor(),
								config::getXpTextColor,
								config::setXpTextColor))
						.controller(IntegerColorControllerBuilder::create)
						.build())
				.option(Option.<Boolean>createBuilder()
						.name(Text.translatable("config.category.uiAndVisual.xpProgressHUD.rainbowEffect"))
						.description(OptionDescription.of(Text.translatable("config.category.uiAndVisual.xpProgressHUD.rainbowEffect.@Tooltip")))
						.stateManager(StateManager.createInstant(defaults.isRainbowEffect(), config::isRainbowEffect, config::setRainbowEffect))
						.controller(BooleanControllerBuilder::create)
						.build());
		return group;
	}

	public static UIAndVisualCategory.ConfigGroup buildToolDurabilityHUD(ToolDurabilityHUDConfig defaults, ToolDurabilityHUDConfig config) {
		var group = new UIAndVisualCategory.ConfigGroup("config.category.uiAndVisual.toolDurabilityHUD");

		group.getBuilder()
				.option(Option.<Integer>createBuilder()
						.name(Text.translatable("config.category.uiAndVisual.toolDurabilityHUD.xPos"))
						.description(OptionDescription.of(Text.translatable("config.category.uiAndVisual.toolDurabilityHUD.xPos.@Tooltip")))
						.stateManager(StateManager.createInstant(defaults.getXPosition(), config::getXPosition, config::setXPosition))
						.controller(opt -> {
							int maxX = MinecraftClient.getInstance().getWindow().getScaledWidth();
							return IntegerSliderControllerBuilder.create(opt).range(0, maxX).step(1);
						})
						.build())
				.option(Option.<Integer>createBuilder()
						.name(Text.translatable("config.category.uiAndVisual.toolDurabilityHUD.yPos"))
						.description(OptionDescription.of(Text.translatable("config.category.uiAndVisual.toolDurabilityHUD.yPos.@Tooltip")))
						.stateManager(StateManager.createInstant(defaults.getYPosition(), config::getYPosition, config::setYPosition))
						.controller(opt -> {
							int maxY = MinecraftClient.getInstance().getWindow().getScaledHeight();
							return IntegerSliderControllerBuilder.create(opt).range(0, maxY).step(1);
						})
						.build())
				.option(Option.<Integer>createBuilder()
						.name(Text.translatable("config.category.uiAndVisual.toolDurabilityHUD.scale"))
						.description(OptionDescription.of(Text.translatable("config.category.uiAndVisual.toolDurabilityHUD.scale.@Tooltip")))
						.stateManager(StateManager.createInstant(defaults.getScale(), config::getScale, config::setScale))
						.controller(opt -> IntegerSliderControllerBuilder.create(opt).range(1, 10).step(1))
						.build())
				.option(Option.<Integer>createBuilder()
						.name(Text.translatable("config.category.uiAndVisual.toolDurabilityHUD.durabilityBarColor"))
						.description(OptionDescription.of(Text.translatable("config.category.uiAndVisual.toolDurabilityHUD.durabilityBarColor.@Tooltip")))
						.stateManager(StateManager.createInstant(
								defaults.getDurabilityBarColor(),
								config::getDurabilityBarColor,
								config::setDurabilityBarColor))
						.controller(IntegerColorControllerBuilder::create)
						.build())
				.option(Option.<Boolean>createBuilder()
						.name(Text.translatable("config.category.uiAndVisual.toolDurabilityHUD.rainbowEffect"))
						.description(OptionDescription.of(Text.translatable("config.category.uiAndVisual.toolDurabilityHUD.rainbowEffect.@Tooltip")))
						.stateManager(StateManager.createInstant(defaults.isRainbowEffect(), config::isRainbowEffect, config::setRainbowEffect))
						.controller(BooleanControllerBuilder::create)
						.build());

		return group;
	}
	public static UIAndVisualCategory.ConfigGroup buildPotionEffectsHUDGroup(PotionEffectsHUDConfig defaults, PotionEffectsHUDConfig config) {
		var group = new UIAndVisualCategory.ConfigGroup("config.category.uiAndVisual.potionEffectsHUD");

		group.getBuilder()
				.option(Option.<Integer>createBuilder()
						.name(Text.translatable("config.category.uiAndVisual.potionEffectsHUD.xPos"))
						.description(OptionDescription.of(Text.translatable("config.category.uiAndVisual.potionEffectsHUD.xPos.@Tooltip")))
						.stateManager(StateManager.createInstant(defaults.getXPosition(), config::getXPosition, config::setXPosition))
						.controller(opt -> IntegerSliderControllerBuilder.create(opt)
								.range(0, MinecraftClient.getInstance().getWindow().getScaledWidth()).step(1))
						.build())
				.option(Option.<Integer>createBuilder()
						.name(Text.translatable("config.category.uiAndVisual.potionEffectsHUD.yPos"))
						.description(OptionDescription.of(Text.translatable("config.category.uiAndVisual.potionEffectsHUD.yPos.@Tooltip")))
						.stateManager(StateManager.createInstant(defaults.getYPosition(), config::getYPosition, config::setYPosition))
						.controller(opt -> IntegerSliderControllerBuilder.create(opt)
								.range(0, MinecraftClient.getInstance().getWindow().getScaledHeight()).step(1))
						.build())
				.option(Option.<Integer>createBuilder()
						.name(Text.translatable("config.category.uiAndVisual.potionEffectsHUD.scale"))
						.description(OptionDescription.of(Text.translatable("config.category.uiAndVisual.potionEffectsHUD.scale.@Tooltip")))
						.stateManager(StateManager.createInstant(defaults.getScale(), config::getScale, config::setScale))
						.controller(opt -> IntegerSliderControllerBuilder.create(opt).range(1, 10).step(1))
						.build())
				.option(Option.<Integer>createBuilder()
						.name(Text.translatable("config.category.uiAndVisual.potionEffectsHUD.textColor"))
						.description(OptionDescription.of(Text.translatable("config.category.uiAndVisual.potionEffectsHUD.textColor.@Tooltip")))
						.stateManager(StateManager.createInstant(
								defaults.getTextColor(),
								config::getTextColor,
								config::setTextColor))
						.controller(IntegerColorControllerBuilder::create)
						.build())
				.option(Option.<Boolean>createBuilder()
						.name(Text.translatable("config.category.uiAndVisual.potionEffectsHUD.rainbowEffect"))
						.description(OptionDescription.of(Text.translatable("config.category.uiAndVisual.potionEffectsHUD.rainbowEffect.@Tooltip")))
						.stateManager(StateManager.createInstant(defaults.isRainbowEffect(), config::isRainbowEffect, config::setRainbowEffect))
						.controller(BooleanControllerBuilder::create)
						.build())
				.option(Option.<Boolean>createBuilder()
						.name(Text.translatable("config.category.uiAndVisual.potionEffectsHUD.statusAZ"))
						.description(OptionDescription.of(Text.translatable("config.category.uiAndVisual.potionEffectsHUD.statusAZ.@Tooltip")))
						.stateManager(StateManager.createInstant(defaults.isRenderStatusAZ(), config::isRenderStatusAZ, config::setRenderStatusAZ))
						.controller(BooleanControllerBuilder::create)
						.build())
				.option(Option.<Boolean>createBuilder()
						.name(Text.translatable("config.category.uiAndVisual.potionEffectsHUD.statusZA"))
						.description(OptionDescription.of(Text.translatable("config.category.uiAndVisual.potionEffectsHUD.statusZA.@Tooltip")))
						.stateManager(StateManager.createInstant(defaults.isRenderStatusZA(), config::isRenderStatusZA, config::setRenderStatusZA))
						.controller(BooleanControllerBuilder::create)
						.build());

		return group;
	}

	public static UIAndVisualCategory.ConfigGroup buildFoodSaturationHUDGroup(FoodSaturationHUDConfig defaults, FoodSaturationHUDConfig config) {
		var group = new UIAndVisualCategory.ConfigGroup("config.category.uiAndVisual.foodSaturationHUD");

		group.getBuilder()
				.option(Option.<Boolean>createBuilder()
						.name(Text.translatable("config.category.uiAndVisual.foodSaturationHUD.rainbowEffect"))
						.description(OptionDescription.of(Text.translatable("config.category.uiAndVisual.foodSaturationHUD.rainbowEffect.@Tooltip")))
						.stateManager(StateManager.createInstant(defaults.isRainbowEffect(), config::isRainbowEffect, config::setRainbowEffect))
						.controller(BooleanControllerBuilder::create)
						.build())
				.option(Option.<Integer>createBuilder()
						.name(Text.translatable("config.category.uiAndVisual.foodSaturationHUD.saturationBarColor"))
						.description(OptionDescription.of(Text.translatable("config.category.uiAndVisual.foodSaturationHUD.saturationBarColor.@Tooltip")))
						.stateManager(StateManager.createInstant(
								defaults.getSaturationBarColor(),
								config::getSaturationBarColor,
								config::setSaturationBarColor))
						.controller(IntegerColorControllerBuilder::create)
						.build());

		return group;
	}
}

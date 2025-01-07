package com.upfault.crux.config;

import com.upfault.crux.config.category.UIAndVisualCategory;
import com.upfault.crux.config.configs.CoordinatesConfig;
import dev.isxander.yacl3.api.YetAnotherConfigLib;
import dev.isxander.yacl3.config.v2.api.ConfigClassHandler;
import dev.isxander.yacl3.config.v2.api.serializer.GsonConfigSerializerBuilder;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;

import java.nio.file.Path;

public class CruxConfigManager {

	private static final Path CONFIG_PATH = FabricLoader.getInstance().getConfigDir().resolve("crux.json");
	private static final ConfigClassHandler<CoordinatesConfig> HANDLER = ConfigClassHandler.createBuilder(CoordinatesConfig.class)
			.serializer(config -> GsonConfigSerializerBuilder.create(config)
					.setPath(CONFIG_PATH)
					.build())
			.build();

	public static CoordinatesConfig getConfig() {
		return HANDLER.instance();
	}

	public static void init() {
		HANDLER.load();
	}

	public static void save() {
		HANDLER.save();
	}

	public static Screen createGUI(Screen parent) {
		CoordinatesConfig defaults = new CoordinatesConfig();
		CoordinatesConfig config = getConfig();

		return YetAnotherConfigLib.create(HANDLER, (defaultInstance, currentConfig, builder) -> {
			builder.title(Text.of("Crux Configuration"))
					.category(UIAndVisualCategory.create(defaults, currentConfig));
			return builder;
		}).generateScreen(parent);
	}
}

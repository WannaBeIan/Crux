package com.upfault.crux.config.category;

import dev.isxander.yacl3.api.ConfigCategory;
import dev.isxander.yacl3.api.OptionGroup;
import net.minecraft.text.Text;

import java.util.List;

public class UIAndVisualCategory {

	public static ConfigCategory create(List<ConfigGroup> groups) {
		var builder = ConfigCategory.createBuilder()
				.name(Text.translatable("config.category.uiAndVisual"));

		for (ConfigGroup group : groups) {
			builder.group(group.buildGroup());
		}

		return builder.build();
	}

	public static class ConfigGroup {
		private final OptionGroup.Builder builder;

		public ConfigGroup(String nameKey) {
			this.builder = OptionGroup.createBuilder().name(Text.translatable(nameKey));
		}

		public OptionGroup.Builder getBuilder() {
			return builder;
		}

		public OptionGroup buildGroup() {
			return builder.build();
		}
	}
}

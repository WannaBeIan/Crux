package com.upfault.crux.config.category;

import com.upfault.crux.config.configs.CoordinatesConfig;
import dev.isxander.yacl3.api.ConfigCategory;
import dev.isxander.yacl3.api.Option;
import dev.isxander.yacl3.api.OptionDescription;
import dev.isxander.yacl3.api.OptionGroup;
import dev.isxander.yacl3.api.controller.IntegerSliderControllerBuilder;
import net.minecraft.text.Text;
public class UIAndVisualCategory {

	public static ConfigCategory create(CoordinatesConfig defaults, CoordinatesConfig config) {
		return ConfigCategory.createBuilder()
				.name(Text.of("UI and Visual"))
				.group(
						OptionGroup.createBuilder()
								.name(Text.of("Coordinates Display"))
								.option(
										Option.<Integer>createBuilder()
												.name(Text.of("Y Position"))
												.description(OptionDescription.of(Text.of("Adjust the Y position of the coordinates display.")))
												.binding(defaults.getYPosition(), config::getYPosition, config::setYPosition)
												.controller(opt -> IntegerSliderControllerBuilder.create(opt).range(0, 200).step(1))
												.build()
								)
								.build()
				)
				.build();
	}
}

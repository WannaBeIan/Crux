package com.upfault.crux.config.controllers;

import dev.isxander.yacl3.api.Option;
import dev.isxander.yacl3.api.controller.IntegerSliderControllerBuilder;
import net.minecraft.text.Text;

public class IntegerColorControllerBuilder {

	public static IntegerSliderControllerBuilder create(Option<Integer> option) {
		return IntegerSliderControllerBuilder.create(option)
				.range(0x000000, 0xFFFFFF)
				.step(1)
				.formatValue(value -> Text.of(String.format("#%06X", value)));
	}

}

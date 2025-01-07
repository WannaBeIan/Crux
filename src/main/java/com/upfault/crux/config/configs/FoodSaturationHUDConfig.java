package com.upfault.crux.config.configs;

import dev.isxander.yacl3.config.v2.api.SerialEntry;

public class FoodSaturationHUDConfig {

	@SerialEntry
	private int saturationBarColor = 0xff9a00;

	@SerialEntry
	private boolean rainbowEffect = false;



	public int getSaturationBarColor() {
		return saturationBarColor;
	}

	public void setSaturationBarColor(int saturationBarColor) {
		this.saturationBarColor = saturationBarColor;
	}

	public boolean isRainbowEffect() {
		return rainbowEffect;
	}

	public void setRainbowEffect(boolean rainbowEffect) {
		this.rainbowEffect = rainbowEffect;
	}
}

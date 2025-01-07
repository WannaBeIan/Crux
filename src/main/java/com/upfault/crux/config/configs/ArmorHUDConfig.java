package com.upfault.crux.config.configs;

import dev.isxander.yacl3.config.v2.api.SerialEntry;

public class ArmorHUDConfig {

	@SerialEntry
	private int xPosition = 0;

	@SerialEntry
	private int yPosition = 135;

	@SerialEntry
	private int scale = 1;

	@SerialEntry
	private int durabilityBarColor = 0x5bff01;

	@SerialEntry
	private boolean rainbowEffect = false;

	public int getXPosition() {
		return xPosition;
	}

	public void setXPosition(int xPosition) {
		this.xPosition = xPosition;
	}

	public int getYPosition() {
		return yPosition;
	}

	public void setYPosition(int yPosition) {
		this.yPosition = yPosition;
	}

	public int getScale() {
		return scale;
	}

	public void setScale(int scale) {
		this.scale = scale;
	}

	public int getDurabilityBarColor() {
		return durabilityBarColor;
	}

	public void setDurabilityBarColor(int durabilityBarColor) {
		this.durabilityBarColor = durabilityBarColor;
	}

	public boolean isRainbowEffect() {
		return rainbowEffect;
	}

	public void setRainbowEffect(boolean rainbowEffect) {
		this.rainbowEffect = rainbowEffect;
	}
}

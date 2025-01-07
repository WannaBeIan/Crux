package com.upfault.crux.config.configs;

import dev.isxander.yacl3.config.v2.api.SerialEntry;

public class XPProgressHUDConfig {

	@SerialEntry
	private int xPosition = 275;

	@SerialEntry
	private int yPosition = 295;

	@SerialEntry
	private int scale = 1;

	@SerialEntry
	private int xpTextColor = 0x5bff01;

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

	public int getXpTextColor() {
		return xpTextColor;
	}

	public void setXpTextColor(int xpTextColor) {
		this.xpTextColor = xpTextColor;
	}

	public boolean isRainbowEffect() {
		return rainbowEffect;
	}

	public void setRainbowEffect(boolean rainbowEffect) {
		this.rainbowEffect = rainbowEffect;
	}
}

// Updated PotionEffectsHUDConfig.java
package com.upfault.crux.config.configs;

import dev.isxander.yacl3.config.v2.api.SerialEntry;

public class PotionEffectsHUDConfig {

	@SerialEntry
	private int xPosition = 0;

	@SerialEntry
	private int yPosition = 35;

	@SerialEntry
	private int scale = 1;

	@SerialEntry
	private int textColor = 0xFFFFFF;

	@SerialEntry
	private boolean rainbowEffect = false;

	@SerialEntry
	private boolean renderStatusAZ = true;

	@SerialEntry
	private boolean renderStatusZA = false;

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

	public int getTextColor() {
		return textColor;
	}

	public void setTextColor(int textColor) {
		this.textColor = textColor;
	}

	public boolean isRenderStatusAZ() {
		return renderStatusAZ;
	}

	public void setRenderStatusAZ(boolean renderStatusAZ) {
		this.renderStatusAZ = renderStatusAZ;
	}

	public boolean isRenderStatusZA() {
		return renderStatusZA;
	}

	public void setRenderStatusZA(boolean renderStatusZA) {
		this.renderStatusZA = renderStatusZA;
	}

	public boolean isRainbowEffect() {
		return rainbowEffect;
	}

	public void setRainbowEffect(boolean rainbowEffect) {
		this.rainbowEffect = rainbowEffect;
	}
}

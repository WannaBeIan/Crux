package com.upfault.crux.config.configs;

import dev.isxander.yacl3.config.v2.api.SerialEntry;

public class CoordinatesConfig {

	@SerialEntry
	private int yPosition = 10;

	@SerialEntry
	private int xPosition = 10;

	@SerialEntry
	private int scale = 1;

	@SerialEntry
	private int coordinateColor = 0xffef00;

	@SerialEntry
	private boolean rainbowEffect = false;

	public int getScale() {
		return scale;
	}

	public void setScale(int scale) {
		this.scale = scale;
	}

	public int getYPosition() {
		return yPosition;
	}

	public void setYPosition(int yPosition) {
		this.yPosition = yPosition;
	}

	public int getXPosition() {
		return xPosition;
	}

	public void setXPosition(int xPosition) {
		this.xPosition = xPosition;
	}

	public int getCoordinateColor() {
		return coordinateColor;
	}

	public void setCoordinateColor(int coordinateColor) {
		this.coordinateColor = coordinateColor;
	}

	public boolean isRainbowEffect() {
		return rainbowEffect;
	}

	public void setRainbowEffect(boolean rainbowEffect) {
		this.rainbowEffect = rainbowEffect;
	}
}

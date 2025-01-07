package com.upfault.crux.config.configs;

import dev.isxander.yacl3.config.v2.api.SerialEntry;

public class CoordinatesConfig {

	@SerialEntry
	private int yPosition = 10;

	public int getYPosition() {
		return yPosition;
	}

	public void setYPosition(int yPosition) {
		this.yPosition = yPosition;
	}
}

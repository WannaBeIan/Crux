package com.upfault.crux.utils;

public class ColorUtils {

	public static int getRainbowColor(long time) {
		float hue = (float) (time % 10000) / 10000;
		return java.awt.Color.HSBtoRGB(hue, 1.0F, 1.0F) | 0xFF000000;
	}
}

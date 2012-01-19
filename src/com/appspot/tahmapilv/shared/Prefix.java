package com.appspot.tahmapilv.shared;

/**
 * An utility class for metric system prefixes
 * @author raido
 */
public enum Prefix {

	YOTTA("Y", 24),
	ZETTA("Z", 21),
	EXA("E", 18),
	PETA("P", 15),
	TERA("T", 12),
	GIGA("G", 9),
	MEGA("M", 6),
	KILO("k", 3),
	HECTO("h", 2),
	DECA("da", 1),
	NONE("", 0),
	DECI("d", -1),
	CENTI("c", -2),
	MILLI("m", -3),
	MICRO("\u00B5", -6),
	NANO("n", -9),
	PICO("p", -12),
	FEMTO("f", -15),
	ATTO("a", -18),
	ZEPTO("z", -21),
	YOCTO("y", -24);

	private String sign;
	private int factor;

	Prefix(String sign, int factor) {
		this.sign = sign;
		this.factor = factor;
	}

	/**
	 * @return factor of ten of a corresponding prefix
	 */
	public int getFactor() {
		return factor;
	}

	/**
	 * @return factor of ten of a corresponding prefix
	 */
	public String getSign() {
		return sign;
	}

	/**
	 * Multiplier for a corresponding prefix to convert to the factor of ten to 0
	 * @return
	 */
	public double getMultiplier() {
		return Math.pow(10, getFactor());
	}

	/**
	 * Prefix conversion
	 * @return converted value
	 */
	public double convert(double inputValue, Prefix inputPrefix) {
		return Math.pow(inputValue * 10, inputPrefix.getFactor() - getFactor());
	}
}

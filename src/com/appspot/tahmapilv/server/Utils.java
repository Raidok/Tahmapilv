package com.appspot.tahmapilv.server;

import java.text.DecimalFormat;

import com.appspot.tahmapilv.shared.InputException;

/**
 * @author raido
 */
public class Utils {

	private Utils() {}

	public static double stringToDouble(String string) throws InputException {
		try {
			return Double.valueOf(string.replace(',', '.'));
		} catch (NumberFormatException e) {
			throw new InputException("Not a Number!");
		}
	}

	public static String roundToThree(double d) {
		DecimalFormat twoDForm = new DecimalFormat("#.###");
		return twoDForm.format(d);
	}
}

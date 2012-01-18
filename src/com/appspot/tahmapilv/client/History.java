package com.appspot.tahmapilv.client;

/**
 * @author raido
 */
public class History {

	public static String getToken() {
		return com.google.gwt.user.client.History.getToken();
	}

	private History() {}

	public static void go(String token) {
		if (com.google.gwt.user.client.History.getToken().equals(token)) {
			com.google.gwt.user.client.History.fireCurrentHistoryState();
		} else {
			com.google.gwt.user.client.History.newItem(token);
		}
	}
}
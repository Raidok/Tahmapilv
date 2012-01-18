package com.appspot.tahmapilv.shared;

import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * @author raido
 */
public class KeyValuePair implements IsSerializable {

	private String key;

	private String value;

	public KeyValuePair() {}

	public KeyValuePair(String key, String value) {
		this.key = key;
		this.value = value;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "KeyValuePair [key=" + key + ", value=" + value + "]";
	}

}
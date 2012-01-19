package com.appspot.tahmapilv.shared;

import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * @author raido
 */
@SuppressWarnings("serial")
public class InputException extends Exception implements IsSerializable {

	InputException() {}

	public InputException(String message) {
		super(message);
	}
}

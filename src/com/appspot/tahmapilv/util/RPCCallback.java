package com.appspot.tahmapilv.util;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * @author raido
 *
 */
public abstract class RPCCallback<T> implements AsyncCallback<T>{

	/**
	 * The message displayed to the user when the server cannot be reached or
	 * returns an error.
	 */
	private static final String SERVER_ERROR = "An error occurred while "
			+ "attempting to contact the server. Please check your network "
			+ "connection and try again.";

	@Override
	public void onFailure(Throwable caught) {
		GWT.log(caught.getMessage());
	}

	@Override
	public abstract void onSuccess(T result);

}

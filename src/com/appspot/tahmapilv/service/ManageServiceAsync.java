package com.appspot.tahmapilv.service;

import com.appspot.tahmapilv.shared.RawDataList;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * @author raido
 */
public interface ManageServiceAsync {

	void getRawData(AsyncCallback<RawDataList> callback);
}

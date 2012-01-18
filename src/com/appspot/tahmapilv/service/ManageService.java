package com.appspot.tahmapilv.service;

import com.appspot.tahmapilv.shared.RawDataList;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * @author raido
 */
@RemoteServiceRelativePath("manage")
public interface ManageService extends RemoteService {

	RawDataList getRawData();
}

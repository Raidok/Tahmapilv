package com.appspot.tahmapilv.server.impl;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import com.appspot.tahmapilv.server.PMF;
import com.appspot.tahmapilv.server.RawData;
import com.appspot.tahmapilv.service.ManageService;
import com.appspot.tahmapilv.shared.RawDataList;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * The server side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class ManageServiceImpl extends RemoteServiceServlet implements ManageService {

	@SuppressWarnings("unchecked")
	@Override
	public RawDataList getRawData() {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		Query q = pm.newQuery(RawData.class);
		List<RawData> list = (List<RawData>) q.execute();
		System.out.println(list.size());
		pm.close();
		return null; //new RawDataList(convertRawDataList(list)); //FIXME
	}

	/*private List<com.appspot.tahmapilv.shared.RawData> convertRawDataList (List<RawData> rawDataList) {
		List<com.appspot.tahmapilv.shared.RawData> returnList =
				new ArrayList<com.appspot.tahmapilv.shared.RawData>();
		if (rawDataList != null) {
			for (RawData data : rawDataList) {
				System.out.println(data);
				returnList.add(new com.appspot.tahmapilv.shared.RawData(convertParams(data.getParams())));
			}
		}
		return returnList;
	}

	private List<com.appspot.tahmapilv.shared.KeyValuePair> convertParams(List<KeyValuePair> kvpList) {
		List<com.appspot.tahmapilv.shared.KeyValuePair> returnList =
				new ArrayList<com.appspot.tahmapilv.shared.KeyValuePair>();
		if (kvpList != null) {
			for (KeyValuePair kvp : kvpList) {
				System.out.println(kvp);
				returnList.add(new com.appspot.tahmapilv.shared.KeyValuePair(kvp.getKey(), kvp.getValue()));
			}
		}
		return returnList;
	}*/
}

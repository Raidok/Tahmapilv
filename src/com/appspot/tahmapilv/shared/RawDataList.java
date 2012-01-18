package com.appspot.tahmapilv.shared;

import java.util.List;

import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * @author raido
 */
public class RawDataList implements IsSerializable {

	private List<RawData> list;

	public RawDataList() {}

	public RawDataList(List<RawData> list) {
		this.list = list;
	}

	public List<RawData> getList() {
		return list;
	}

	public void setList(List<RawData> list) {
		this.list = list;
	}
}

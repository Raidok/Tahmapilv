package com.appspot.tahmapilv.shared;

import java.util.List;

import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * @author raido
 */
public class RawData implements IsSerializable {

	private Long id;

	private boolean isTreated;

	private List<KeyValuePair> params;

	public RawData() {}

	public RawData(List<KeyValuePair> params) {
		this.isTreated = false;
		this.params = params;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public boolean isTreated() {
		return isTreated;
	}

	public void setTreated(boolean isTreated) {
		this.isTreated = isTreated;
	}

	public List<KeyValuePair> getParams() {
		return params;
	}

	public void setParams(List<KeyValuePair> params) {
		this.params = params;
	}

	public String getParam(String key) {
		if (key != null && params != null) {
			for (KeyValuePair kv : params) {
				if (key.equals(kv.getKey()))
					return kv.getValue();
			}
		}
		return "";
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		if (params != null) {
			for (KeyValuePair kvp : params) {
				sb.append(kvp.toString());
			}
		}
		return "RawData [id=" + id + ", isTreated=" + isTreated + ", params="
		+ sb.toString() + "]";
	}
}

package com.appspot.tahmapilv.server;

import java.util.List;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Key;
import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * @author raido
 */
@PersistenceCapable
public class RawData implements IsSerializable {

	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Long id;

	@Persistent
	private boolean isTreated;

	@Persistent
	private List<Key> params;

	public RawData() {}

	public RawData(List<Key> params) {
		this.isTreated = false;
		this.params = params;
	}

	public Long getId() {
		return id;
	}

	public boolean isTreated() {
		return isTreated;
	}

	public void setTreated(boolean isTreated) {
		this.isTreated = isTreated;
	}

	public List<Key> getParams() {
		return params;
	}

	public void setParams(List<Key> params) {
		this.params = params;
	}

	/*public String getParam(String key) {
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
	}*/
}

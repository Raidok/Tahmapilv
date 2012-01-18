package com.appspot.tahmapilv.server;

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
public class KeyValuePair implements IsSerializable {

	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Key primaryKey;

	@Persistent
	private String key;

	@Persistent
	private String value;

	public KeyValuePair() {}

	public KeyValuePair(String key, String value) {
		this.key = key;
		this.value = value;
	}

	public Key getPrimaryKey() {
		return primaryKey;
	}

	public void setPrimaryKey(Key primaryKey) {
		this.primaryKey = primaryKey;
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
package com.appspot.tahmapilv.service;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * @author raido
 */
public interface AssistantServiceAsync {

	void getCapacitorResistance(double capacitance, double frequency, AsyncCallback<Double> callBack);
	void getInductorResistance(double inductance, double frequency, AsyncCallback<Double> callBack);
}

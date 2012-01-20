package com.appspot.tahmapilv.service;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * @author raido
 */
public interface AssistantServiceAsync {

	void getCapacitorResistance(String capacitance, int factor, String frequency, int multiplier,
			AsyncCallback<String> callBack);
	void getInductorResistance(String inductance, int factor, String frequency, int multiplier,
			AsyncCallback<String> callBack);
	void getGain(String type, String input, String output,
			AsyncCallback<String> callBack);
	void getTimeConstantAndCutOffFreq(String type, String input1, int factor1, String input2, int factor2,
			AsyncCallback<String> callBack);
}

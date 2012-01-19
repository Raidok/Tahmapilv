package com.appspot.tahmapilv.service;

import com.appspot.tahmapilv.shared.InputException;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * @author raido
 */
@RemoteServiceRelativePath("assist")
public interface AssistantService extends RemoteService {

	/* Capacitor AC response */
	String getCapacitorResistance(String capacitance, int factor, String frequency, int multiplier) throws InputException;
	String getInductorResistance(String inductance, int factor, String frequency, int multiplier) throws InputException;
}

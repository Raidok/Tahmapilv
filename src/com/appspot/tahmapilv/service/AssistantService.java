package com.appspot.tahmapilv.service;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * @author raido
 */
@RemoteServiceRelativePath("assist")
public interface AssistantService extends RemoteService {

	double getCapacitorResistance(double capacitance, double frequency);
	double getInductorResistance(double inductance, double frequency);
}

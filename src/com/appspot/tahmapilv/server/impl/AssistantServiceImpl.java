package com.appspot.tahmapilv.server.impl;

import isc.components.Capacitor;
import isc.components.Inductor;

import com.appspot.tahmapilv.server.Utils;
import com.appspot.tahmapilv.service.AssistantService;
import com.appspot.tahmapilv.shared.InputException;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * @author raido
 *
 */
@SuppressWarnings("serial")
public class AssistantServiceImpl extends RemoteServiceServlet implements AssistantService {

	@Override
	public String getCapacitorResistance(String capacitance, int factor,
			String frequency, int multiplier) throws InputException {
		double cap = Utils.stringToDouble(capacitance) * Math.pow(10, factor);
		double freq = Utils.stringToDouble(frequency);
		if (multiplier > 0) freq /= (multiplier * Math.PI);
		return String.valueOf(new Capacitor(cap, freq).getResistance());
	}

	@Override
	public String getInductorResistance(String inductance, int factor,
			String frequency, int multiplier) throws InputException {
		double ind = Utils.stringToDouble(inductance) * Math.pow(10, factor);
		double freq = Utils.stringToDouble(frequency) / (multiplier * Math.PI);
		return String.valueOf(new Inductor(ind, freq).getResistance());
	}
}

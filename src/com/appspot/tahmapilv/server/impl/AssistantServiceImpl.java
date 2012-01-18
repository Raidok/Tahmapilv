package com.appspot.tahmapilv.server.impl;

import util.Units.FrequencyUnit;

import com.appspot.tahmapilv.service.AssistantService;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import components.Capacitor;
import components.Inductor;

/**
 * @author raido
 *
 */
@SuppressWarnings("serial")
public class AssistantServiceImpl extends RemoteServiceServlet implements AssistantService {

	/* (non-Javadoc)
	 * @see com.appspot.tahmapilv.service.AssistantService#getCapacitorResistance(double, double)
	 */
	@Override
	public double getCapacitorResistance(double capacitance, double frequency) {
		return new Capacitor(capacitance, frequency).getResistance();
	}

	@Override
	public double getInductorResistance(double inductance, double frequency) {
		return new Inductor(inductance, frequency, FrequencyUnit.HERTZ).getResistance();
	}

}

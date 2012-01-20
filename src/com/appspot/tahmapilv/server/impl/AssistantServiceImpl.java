package com.appspot.tahmapilv.server.impl;

import isc.components.Capacitor;
import isc.components.Inductor;
import isc.util.Admittance;

import com.appspot.tahmapilv.server.Utils;
import com.appspot.tahmapilv.service.AssistantService;
import com.appspot.tahmapilv.shared.InputException;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * @author raido
 */
@SuppressWarnings("serial")
public class AssistantServiceImpl extends RemoteServiceServlet implements AssistantService {

	@Override
	public String getCapacitorResistance(String capacitance, int factor,
			String frequency, int multiplier) throws InputException {
		double cap = Utils.stringToDouble(capacitance) * Math.pow(10, factor);
		double freq = Utils.stringToDouble(frequency);
		if (multiplier > 0) freq /= (multiplier * Math.PI);
		return Utils.roundToThree(new Capacitor(cap, freq).getResistance());
	}

	@Override
	public String getInductorResistance(String inductance, int factor,
			String frequency, int multiplier) throws InputException {
		double ind = Utils.stringToDouble(inductance) * Math.pow(10, factor);
		double freq = Utils.stringToDouble(frequency);
		if (multiplier > 0) freq /= (multiplier * Math.PI);
		return Utils.roundToThree(new Inductor(ind, freq).getResistance());
	}

	@Override
	public String getGain(String type, String input, String output)
			throws InputException {
		double in = Utils.stringToDouble(input);
		double out = Utils.stringToDouble(output);
		double ratio = out/in;
		StringBuffer buf = new StringBuffer("ratio="+Utils.roundToThree(ratio));
		if ("CUR".equals(type)) {
			buf.append(" current gain=");
			buf.append(Utils.roundToThree(Admittance.getCurrentGain(ratio)));
			buf.append(" dB");
		} else if ("POW".equals(type)) {
			buf.append(" power gain=");
			buf.append(Utils.roundToThree(Admittance.getPowerGain(ratio)));
			buf.append(" dB");
		} else if ("VOL".equals(type)) {
			buf.append(" voltage gain=");
			buf.append(Utils.roundToThree(Admittance.getVoltageGain(ratio)));
			buf.append(" dB");
		}
		return buf.toString();
	}
}

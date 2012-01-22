package com.appspot.tahmapilv.server.impl;

import isc.components.Capacitor;
import isc.components.Inductor;
import isc.util.Admittance;
import isc.util.TimeConstant;

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

	@Override
	public String getTimeConstantAndCutOffFreq(String type, String input1,
			int factor1, String input2, int factor2) throws InputException {
		double in1 = Utils.stringToDouble(input1) * Math.pow(10, factor1);
		double in2 = Utils.stringToDouble(input2) * Math.pow(10, factor2);
		double tc = 0;
		StringBuffer buf = new StringBuffer();
		if ("RC".equals(type)) {
			buf.append("RC circuit time constant:");
			tc = TimeConstant.getTimeConstantRC(in1, in2);
		} if ("LR".equals(type)) {
			buf.append("LR circuit time constant:");
			tc = TimeConstant.getTimeConstantLR(in1, in2);
		}
		buf.append(Utils.roundToThree(tc * 1E6));
		buf.append(" \u00B5s cutoff frequency:");
		buf.append(Utils.roundToThree(TimeConstant.getCutoffFrequency(tc)));
		buf.append(" Hz");
		return buf.toString();
	}
}

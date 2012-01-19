package com.appspot.tahmapilv.util;

import com.appspot.tahmapilv.shared.Prefix;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.ListBox;

/**
 * @author raido
 */
public class UnitsListBox extends ListBox {

	public enum Type {
		CAPACITANCE("F"),
		INDUCTANCE("H"),
		RESISTANCE("\u2126"), //Ohm sign
		FREQUENCY("");
		private String unit;
		Type(String unit) {
			this.unit = unit;
		}
		public String getUnit() {
			return unit;
		}
	}

	private Type type;

	public UnitsListBox(Type type) {
		super();
		this.type = type;
		switch (type) {
		case CAPACITANCE:
			addItem(Prefix.NONE);
			addItem(Prefix.MILLI);
			addItem(Prefix.MICRO);
			addItem(Prefix.NANO);
			addItem(Prefix.PICO);
			setSelected(Prefix.NANO);
			break;

		case INDUCTANCE:
			addItem(Prefix.NONE);
			addItem(Prefix.MILLI);
			addItem(Prefix.MICRO);
			setSelected(Prefix.MILLI);
			break;

		case RESISTANCE:
			addItem(Prefix.MEGA);
			addItem(Prefix.KILO);
			addItem(Prefix.NONE);
			addItem(Prefix.MILLI);
			setSelected(Prefix.KILO);
			break;

		case FREQUENCY:
			addItem("Hz", "0");
			addItem("rad", "2");
			addItem("krad", "2000");
			break;

		default:
			addItem(Prefix.NONE);
			break;
		}
	}

	private void addItem(Prefix prefix) {
		addItem(prefix.getSign() + type.getUnit(), String.valueOf(prefix.getFactor()));
	}

	public int getValue() {
		return Integer.valueOf(getValue(getSelectedIndex()));
	}

	public void setSelected(Prefix prefix) {
		int count = getItemCount();
		GWT.log("setSelected: count="+count+" setTo="+prefix);
		for (int i = 0; i < count; i++) {
			if (Integer.valueOf(getValue(i)) == prefix.getFactor()) {
				setSelectedIndex(i);
				GWT.log(" found it! i="+i);
			}
		}
	}
}

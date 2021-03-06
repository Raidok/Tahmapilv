package com.appspot.tahmapilv.client.content;

import com.appspot.tahmapilv.client.Services;
import com.appspot.tahmapilv.util.RPCCallback;
import com.appspot.tahmapilv.util.UnitsListBox;
import com.appspot.tahmapilv.util.UnitsListBox.Type;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class Capacitor extends Composite implements Content {

	private static CapacitorUiBinder uiBinder = GWT
			.create(CapacitorUiBinder.class);

	interface CapacitorUiBinder extends UiBinder<Widget, Capacitor> {
	}

	@UiField TextBox capacitance;
	@UiField(provided=true) UnitsListBox capacitanceUnit;
	@UiField TextBox frequency;
	@UiField(provided=true) UnitsListBox frequencyUnit;
	@UiField Button button;
	@UiField Label result;

	public Capacitor() {
		this.capacitanceUnit = new UnitsListBox(Type.CAPACITANCE);
		this.frequencyUnit = new UnitsListBox(Type.FREQUENCY);
		initWidget(uiBinder.createAndBindUi(this));
	}

	@UiHandler("button")
	void onSubmitClick(ClickEvent e) {
		Services.getAssistantService().getCapacitorResistance(
				capacitance.getText(),
				capacitanceUnit.getIntValue(),
				frequency.getText(),
				frequencyUnit.getIntValue(),
				new RPCCallback<String>() {

					@Override
					public void onSuccess(String result) {
						Capacitor.this.result.setText("Result: " + result + " \u2126");
					}
				});
	}
}

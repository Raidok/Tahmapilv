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

public class Inductor extends Composite implements Content {

	private static InductorUiBinder uiBinder = GWT
			.create(InductorUiBinder.class);

	interface InductorUiBinder extends UiBinder<Widget, Inductor> {
	}

	@UiField TextBox inductance;
	@UiField(provided=true) UnitsListBox inductanceUnit;
	@UiField TextBox frequency;
	@UiField(provided=true) UnitsListBox frequencyUnit;
	@UiField Button button;
	@UiField Label result;

	public Inductor() {
		this.inductanceUnit = new UnitsListBox(Type.INDUCTANCE);
		this.frequencyUnit = new UnitsListBox(Type.FREQUENCY);
		initWidget(uiBinder.createAndBindUi(this));
	}

	@UiHandler("button")
	void onClick(ClickEvent e) {
		Services.getAssistantService().getInductorResistance(
				inductance.getText(),
				inductanceUnit.getIntValue(),
				frequency.getText(),
				frequencyUnit.getIntValue(),
				new RPCCallback<String>() {

					@Override
					public void onSuccess(String result) {
						Inductor.this.result.setText("Result: " + result + " \u2126");
					}
				});
	}
}

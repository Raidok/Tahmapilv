package com.appspot.tahmapilv.client.content;

import com.appspot.tahmapilv.service.Services;
import com.appspot.tahmapilv.util.RPCCallback;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class Capacitor extends Composite implements HasText,Content {

	private static CapacitorUiBinder uiBinder = GWT
			.create(CapacitorUiBinder.class);

	interface CapacitorUiBinder extends UiBinder<Widget, Capacitor> {
	}

	public Capacitor() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@UiField TextBox capacitance;
	@UiField TextBox frequency;
	@UiField Button button;
	@UiField Label result;

	@UiHandler("button")
	void onClick(ClickEvent e) {
		Services.getAssistantService().getCapacitorResistance(
				Double.valueOf(capacitance.getText()),
				Double.valueOf(frequency.getText()),
				new RPCCallback<Double>() {

					@Override
					public void onSuccess(Double result) {
						Capacitor.this.result.setText("Tulemus: " + result);
					}
				});
	}

	@Override
	public void setText(String text) {
		button.setText(text);
	}

	@Override
	public String getText() {
		return button.getText();
	}

}

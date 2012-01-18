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

public class Inductor extends Composite implements HasText,Content {

	private static InductorUiBinder uiBinder = GWT
			.create(InductorUiBinder.class);

	interface InductorUiBinder extends UiBinder<Widget, Inductor> {
	}

	public Inductor() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@UiField TextBox inductance;
	@UiField TextBox frequency;
	@UiField Button button;
	@UiField Label result;

	@UiHandler("button")
	void onClick(ClickEvent e) {
		Services.getAssistantService().getInductorResistance(
				Double.valueOf(inductance.getText()),
				Double.valueOf(frequency.getText()),
				new RPCCallback<Double>() {

					@Override
					public void onSuccess(Double result) {
						Inductor.this.result.setText("Tulemus: " + result);
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

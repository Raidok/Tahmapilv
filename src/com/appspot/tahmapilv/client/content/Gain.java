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

public class Gain extends Composite {

	private static GainUiBinder uiBinder = GWT.create(GainUiBinder.class);

	interface GainUiBinder extends UiBinder<Widget, Gain> {
	}

	@UiField(provided=true) UnitsListBox type;
	@UiField TextBox input;
	@UiField TextBox output;
	@UiField Button button;
	@UiField Label result;

	public Gain() {
		type = new UnitsListBox(Type.GAIN);
		initWidget(uiBinder.createAndBindUi(this));
	}

	@UiHandler("button")
	void onSubmitClick(ClickEvent e) {
		Services.getAssistantService().getGain(
				type.getValue(),
				input.getValue(),
				output.getValue(),
				new RPCCallback<String>() {
					@Override
					public void onSuccess(String result) {
						Gain.this.result.setText("Result: " + result);
					}
				});
	}

}

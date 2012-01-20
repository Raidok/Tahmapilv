package com.appspot.tahmapilv.client.content;

import com.appspot.tahmapilv.client.Services;
import com.appspot.tahmapilv.util.RPCCallback;
import com.appspot.tahmapilv.util.UnitsListBox;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.InlineLabel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class TimeConstant extends Composite {

	private static TimeConstantUiBinder uiBinder = GWT
			.create(TimeConstantUiBinder.class);

	interface TimeConstantUiBinder extends UiBinder<Widget, TimeConstant> {
	}

	//@UiField(provided=true) UnitsListBox type;
	@UiField InlineLabel lab1;
	@UiField TextBox input1;
	@UiField(provided=true) UnitsListBox factor1;
	@UiField InlineLabel lab2;
	@UiField TextBox input2;
	@UiField(provided=true) UnitsListBox factor2;
	@UiField Button button;
	@UiField Label result;


	public TimeConstant() {
		//type = new UnitsListBox(Type.SCH_TYPE);
		//setFieldsVisible(false);
		initWidget(uiBinder.createAndBindUi(this));
	}

	private void setFieldsVisible(boolean visible) {
		lab1.setVisible(visible);
		input1.setVisible(visible);
		factor1.setVisible(visible);
		lab2.setVisible(visible);
		input2.setVisible(visible);
		factor2.setVisible(visible);
		button.setVisible(visible);
		if (!visible) result.setText("");
	}

	@UiHandler("button")
	void onSubmitClick(ClickEvent e) {
		Services.getAssistantService().getTimeConstantAndCutOffFreq(
				"1",//type.getValue(),
				input1.getValue(),
				factor1.getIntValue(),
				input2.getValue(),
				factor2.getIntValue(),
				new RPCCallback<String>() {
					@Override
					public void onSuccess(String result) {
						TimeConstant.this.result.setText("Result: " + result);
					}
				});
	}

}

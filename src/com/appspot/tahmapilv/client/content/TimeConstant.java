package com.appspot.tahmapilv.client.content;

import com.appspot.tahmapilv.client.Services;
import com.appspot.tahmapilv.util.RPCCallback;
import com.appspot.tahmapilv.util.UnitsListBox;
import com.appspot.tahmapilv.util.UnitsListBox.Type;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ChangeEvent;
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

	private UnitsListBox RBox;
	private UnitsListBox LBox;
	private UnitsListBox CBox;
	@UiField(provided=true) UnitsListBox type;
	@UiField InlineLabel lab1;
	@UiField TextBox input1;
	@UiField(provided=true) UnitsListBox factor1;
	@UiField InlineLabel lab2;
	@UiField TextBox input2;
	@UiField(provided=true) UnitsListBox factor2;
	@UiField Button button;
	@UiField Label result;


	public TimeConstant() {
		type = new UnitsListBox(Type.SCH_TYPE);
		factor1 = new UnitsListBox();
		factor2 = new UnitsListBox();
		initWidget(uiBinder.createAndBindUi(this));
		setFieldsVisible(false);
	}

	private void setFields(String type) {
		setFieldsVisible(!"".equals(type));
		if ("RC".equals(type)) {
			GWT.log(":RC:"+type);
			factor1.fill(Type.RESISTANCE);
			factor2.fill(Type.CAPACITANCE);
		} else if ("LR".equals(type)) {
			GWT.log(":LR:"+type);
			factor1.fill(Type.INDUCTANCE);
			factor2.fill(Type.RESISTANCE);
		}
	}

	private void setFieldsVisible(boolean visible) {
		lab1.setVisible(visible);
		input1.setVisible(visible);
		factor1.setVisible(visible);
		lab2.setVisible(visible);
		input2.setVisible(visible);
		factor2.setVisible(visible);
		button.setVisible(visible);
		if (!visible) {
			result.setText("");
		} else {
			input1.setText("");
			input2.setText("");
		}
	}

	@UiHandler("type")
	void onChangeHandler(ChangeEvent e) {
		setFields(type.getValue());
	}

	@UiHandler("button")
	void onSubmitClick(ClickEvent e) {
		Services.getAssistantService().getTimeConstantAndCutOffFreq(
				type.getValue(),
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

package com.appspot.tahmapilv.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Widget;

public class Main extends Composite {

	private static MainUiBinder uiBinder = GWT.create(MainUiBinder.class);

	interface MainUiBinder extends UiBinder<Widget, Main> {
	}

	@UiField
	FlowPanel content;

	public Main() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	public FlowPanel getContent() {
		GWT.log("content get " + content);
		return content;
	}

	public void setContent(Widget content) {
		GWT.log("content set to " + content);
		this.content.clear();
		this.content.add(content);
	}

}

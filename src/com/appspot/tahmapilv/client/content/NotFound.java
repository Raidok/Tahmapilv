package com.appspot.tahmapilv.client.content;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class NotFound extends Composite {

	private static NotFoundUiBinder uiBinder = GWT
			.create(NotFoundUiBinder.class);

	interface NotFoundUiBinder extends UiBinder<Widget, NotFound> {
	}

	public NotFound() {
		initWidget(uiBinder.createAndBindUi(this));
	}

}

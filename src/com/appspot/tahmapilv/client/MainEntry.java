package com.appspot.tahmapilv.client;

import com.appspot.tahmapilv.client.content.Capacitor;
import com.appspot.tahmapilv.client.content.Gain;
import com.appspot.tahmapilv.client.content.Inductor;
import com.appspot.tahmapilv.client.content.NotFound;
import com.appspot.tahmapilv.client.content.TimeConstant;
import com.appspot.tahmapilv.client.content.Welcome;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class MainEntry implements EntryPoint {

	private Main main;

	@Override
	public void onModuleLoad() {
		RootPanel.get("body").add(main = new Main());
		History.addValueChangeHandler(new HistoryChangeHandler());
		History.fireCurrentHistoryState();
	}

	private class HistoryChangeHandler implements ValueChangeHandler<String> {
		@Override
		public void onValueChange(ValueChangeEvent<String> event) {
			String token = History.getToken();
			if ("".equals(token)) {
				main.setContent(new Welcome());
			} else if ("Capacitor".equals(token)) {
				main.setContent(new Capacitor());
			} else if ("Inductor".equals(token)) {
				main.setContent(new Inductor());
			} else if ("Gain".equals(token)) {
				main.setContent(new Gain());
			} else if ("TimeConstant".equals(token)) {
				main.setContent(new TimeConstant());
			} else {
				main.setContent(new NotFound());
			}
		}
	}
}
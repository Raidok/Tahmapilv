package com.appspot.tahmapilv.client;

import com.appspot.tahmapilv.service.AssistantService;
import com.appspot.tahmapilv.service.AssistantServiceAsync;
import com.appspot.tahmapilv.service.ManageService;
import com.appspot.tahmapilv.service.ManageServiceAsync;
import com.google.gwt.core.client.GWT;

/**
 * @author raido
 *
 */
public class Services {

	private Services() {}

	private static ManageServiceAsync manageService = GWT.create(ManageService.class);
	private static AssistantServiceAsync assistantService = GWT.create(AssistantService.class);

	public static ManageServiceAsync getManageService() {
		return manageService;
	}

	public static AssistantServiceAsync getAssistantService() {
		return assistantService;
	}
}

package com.appspot.tahmapilv.service;

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

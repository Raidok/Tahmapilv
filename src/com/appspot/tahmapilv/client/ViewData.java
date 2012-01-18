package com.appspot.tahmapilv.client;

import java.util.ArrayList;
import java.util.List;

import com.appspot.tahmapilv.service.ManageService;
import com.appspot.tahmapilv.service.ManageServiceAsync;
import com.appspot.tahmapilv.shared.KeyValuePair;
import com.appspot.tahmapilv.shared.RawData;
import com.appspot.tahmapilv.shared.RawDataList;
import com.google.gwt.cell.client.TextCell;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * @author raido
 */
public class ViewData implements EntryPoint {

	private final ManageServiceAsync manageService = GWT
			.create(ManageService.class);

	@Override
	public void onModuleLoad() {
		final Label errorLabel = new Label();
		RootPanel.get("errorLabelContainer").add(errorLabel);

		List<RawData> list = new ArrayList<RawData>();

		List<KeyValuePair> kvList = new ArrayList<KeyValuePair>();
		kvList.add(new KeyValuePair("header", "b"));
		list.add(new RawData(kvList));

		List<KeyValuePair> kvList2 = new ArrayList<KeyValuePair>();
		kvList2.add(new KeyValuePair("header", "c"));
		list.add(new RawData(kvList2));

		final Table table = new Table();


		manageService.getRawData(new AsyncCallback<RawDataList>() {

			@Override
			public void onSuccess(RawDataList result) {
				GWT.log("Tulemusi:" + result.getList().size());
				table.setRowData(result.getList());
				RootPanel.get("dataContainer").add(table);
			}

			@Override
			public void onFailure(Throwable caught) {
				errorLabel.setText("Viga: " + caught.getMessage());
			}
		});
	}

	private class Table extends CellTable<RawData> {
		public Table() {
			Column<RawData, String> headerColumn = new Column<RawData, String>(
					new TextCell()) {

				@Override
				public String getValue(RawData object) {
					return object.toString();
				}

			};
			addColumn(headerColumn, "header");
		}
	}
}

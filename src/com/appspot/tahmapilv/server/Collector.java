package com.appspot.tahmapilv.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.datastore.Key;


/**
 * @author raido
 */
@SuppressWarnings("serial")
public class Collector extends HttpServlet {



	@SuppressWarnings("unchecked")
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Long startTime = System.currentTimeMillis();
		PrintWriter out = response.getWriter();

		Long id = save(request.getParameterMap());

		Long time = System.currentTimeMillis() - startTime;
		out.print("Success (" + id + ") in " + time + " ms");
	}

	private Long save(Map<String, String[]> params) {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		List<KeyValuePair> list = new ArrayList<KeyValuePair>();
		for (Entry<String, String[]> e : params.entrySet()) {
			list.add(new KeyValuePair(e.getKey(), e.getValue()[0]));
		}
		RawData data = new RawData(saveList(list));
		pm.makePersistent(data);
		return data.getId();
	}

	private List<Key> saveList(List<KeyValuePair> list) {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		List<Key> returnList = new ArrayList<Key>();
		Query q = pm.newQuery(KeyValuePair.class);
		q.setFilter("key == keyParam");
		q.setFilter("value == valueParam");
		q.declareParameters("String keyParam");
		q.declareParameters("String valueParam");
		for (KeyValuePair kvp : list) {
			@SuppressWarnings("unchecked")
			List<KeyValuePair> qList = (List<KeyValuePair>) q.execute(kvp.getKey(), kvp.getValue());
			System.out.println(qList.size() + " item(s) on " + kvp);
			if (qList.size() > 0) {
				returnList.add(qList.get(0).getPrimaryKey());
			}
		}
		return returnList;
	}
}
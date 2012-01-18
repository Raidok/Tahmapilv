package com.appspot.tahmapilv.server;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManagerFactory;

/**
 * @author raido
 */
public class PMF {

	private static final PersistenceManagerFactory PMF =
			JDOHelper.getPersistenceManagerFactory("transactions-optional");

	public static PersistenceManagerFactory get() {
		return PMF;
	}

}
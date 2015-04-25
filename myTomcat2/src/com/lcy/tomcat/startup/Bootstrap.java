package com.lcy.tomcat.startup;

import com.lcy.tomcat.connector.http.HttpConnector;

public class Bootstrap {

	public static void main(String[] args) {
		HttpConnector hc = new HttpConnector();
		hc.start();
	}
}

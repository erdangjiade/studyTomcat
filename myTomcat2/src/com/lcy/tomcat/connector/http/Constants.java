package com.lcy.tomcat.connector.http;

import java.io.File;

public final class Constants {

	public static final String WEB_ROOT = System.getProperty("user.dir") +
			File.separator + "webroot";
	public static final String PACKAGE = "com.lcy.tomcat.connector.http";
	public static final int DEFAULT_CONNECTION_TIMEOUT = 60000;
	public static final int PROCESSOR_IDEL = 0;
	public static final int PROCESSOR_ACTIVE = 1;
	
	
}

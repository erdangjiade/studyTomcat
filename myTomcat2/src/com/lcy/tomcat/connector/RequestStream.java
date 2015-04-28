package com.lcy.tomcat.connector;

import java.io.IOException;

import javax.servlet.ServletInputStream;

import com.lcy.tomcat.connector.http.HttpRequest;

public class RequestStream extends ServletInputStream{

	public RequestStream(HttpRequest hr){
		
	}

	@Override
	public int read() throws IOException {
		// TODO Auto-generated method stub
		return 0;
	}
	
}

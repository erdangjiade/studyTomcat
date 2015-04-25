package com.lcy.tomcat;

import java.io.IOException;

public class StaticResourceProcess {

	public void process(Request request, Response response){
		
		try {
			response.sendStaticResource();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}

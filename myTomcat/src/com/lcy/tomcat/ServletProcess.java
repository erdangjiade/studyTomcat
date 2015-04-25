package com.lcy.tomcat;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLStreamHandler;

import javax.servlet.Servlet;
import javax.servlet.ServletResponse;

public class ServletProcess {

	public void process(Request request, Response response){
		String uri = request.getUri();
		String servletName = uri.substring(uri.lastIndexOf("/")+1);
		URLClassLoader urlClassLoader = null;
		
		try {
			
			URL[] urls = new URL[1];
			URLStreamHandler ush = null;
			
			File classpath = new File(Constants.WEB_ROOT);
			String repository = (new URL("file", null, 	classpath.getCanonicalPath() + File.separator)).toString();
			urls[0]  = new URL(null, repository, ush);
			
			urlClassLoader = new URLClassLoader(urls);
			Class myClass = urlClassLoader.loadClass(servletName);
			Servlet servlet = (Servlet)myClass.newInstance();
			
			RequestFacade requestF = new RequestFacade(request);
			ResponseFacade responseF = new ResponseFacade(response);
			
			servlet.service(requestF, responseF);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}
	
}

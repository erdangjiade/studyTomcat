package com.lcy.tomcat;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLStreamHandler;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import com.lcy.tomcat.connector.http.Constants;
import com.lcy.tomcat.connector.http.HttpRequest;
import com.lcy.tomcat.connector.http.HttpRequestFacade;
import com.lcy.tomcat.connector.http.HttpResponse;
import com.lcy.tomcat.connector.http.HttpResponseFacade;

public class ServletProcessor {

	public void process(HttpRequest request, HttpResponse response){
		
		String uri = request.getRequestURI();
		String servletName = uri.substring(uri.lastIndexOf("/")+1);
		URLClassLoader loader = null;
		
		URL[] urls = new URL[1];
		URLStreamHandler streamHandler = null;
		File classPath = new File(Constants.WEB_ROOT);
		try {
			String repository  = (new URL("file", null, classPath.getCanonicalPath() + File.separator)).toString();
			urls[0] = new URL(null, repository, streamHandler);
			loader = new URLClassLoader(urls);
			
			Class myclass = loader.loadClass(servletName);
			
			Servlet servlet = (Servlet) myclass.newInstance();
			HttpRequestFacade requestF = new HttpRequestFacade(request);
			HttpResponseFacade responseF = new HttpResponseFacade(response);
			servlet.service(requestF, responseF);
			response.finishResponse();
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ServletException e) {
			e.printStackTrace();
		}
	}
	
}

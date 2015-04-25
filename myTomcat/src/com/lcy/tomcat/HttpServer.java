package com.lcy.tomcat;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class HttpServer {

	public static final String WEB_ROOT = System.getProperty("user.dir")
									+ File.separator + "webroot";
		
	private static final String SHUTDOWN_COMMAND = "/SHUTDOWN";
	
	private boolean shutdown = false;
	
	public static void main(String[] args) {
		HttpServer hs = new HttpServer();
		hs.await();
	}
	
	public void await() {
		
		ServerSocket ss = null;
		try {
			ss = new ServerSocket(8080, 1);
		} catch (IOException e1) {
			e1.printStackTrace();
			System.exit(1);;
		}
		
		while(!shutdown){
			Socket s = null;
			InputStream is = null;
			OutputStream os = null;
			try {
				s = ss.accept();
				is = s.getInputStream();
				os = s.getOutputStream();
				
				Request request = new Request(is);
				request.parse();
				
				Response response = new Response(os);
				response.setRequest(request);
//				response.sendStaticResource();
				
				if(request.getUri().startsWith("/servlet/")){
					//Ö´ÐÐservlet
					ServletProcess sp = new ServletProcess();
					sp.process(request, response);
					
				}else{
					StaticResourceProcess srp = new StaticResourceProcess();
					srp.process(request, response);
				}
				
				s.close();
				
				shutdown = SHUTDOWN_COMMAND.equals(request.getUri());
			} catch (Exception e) {
				e.printStackTrace();
				System.exit(1);
			}
			
		}
		
	}
	
}

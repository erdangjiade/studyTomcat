package com.lcy.tomcat.connector.http;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class HttpConnector implements Runnable{

	boolean stopped;
	private String scheme = "http";
	
	public String getScheme(){
		return scheme;
	}
	
	@Override
	public void run() {
		ServerSocket ss = null;
		try {
			ss = new ServerSocket(8080, 1);
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
		
		while(!stopped){
			
			try {
				Socket s = ss.accept();
			} catch (IOException e) {
				e.printStackTrace();
				continue;
			}
			
			
			
		}
		
		
	}

	
	public void start(){
		Thread t = new Thread(this);
		t.start();
	}
	
}

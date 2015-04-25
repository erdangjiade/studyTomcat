package myTomcat;

import java.net.ServerSocket;

import org.junit.Test;

import com.lcy.tomcat.ServletProcess;

public class T {

	@Test
	public void t1(){
		ServletProcess sp = new ServletProcess();
		sp.process(null, null);
	}
	
}

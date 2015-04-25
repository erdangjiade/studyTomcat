

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class MyServlet implements Servlet{

	@Override
	public void destroy() {
		System.out.println("MyServlet is destroyed");
		
	}

	@Override
	public ServletConfig getServletConfig() {
		
		return null;
	}

	@Override
	public String getServletInfo() {
		
		return null;
	}

	@Override
	public void init(ServletConfig arg0) throws ServletException {
		System.out.println("MyServlet is initialized");
		
	}

	@Override
	public void service(ServletRequest request, ServletResponse response)
			throws ServletException, IOException {
		System.out.println("from service");
		PrintWriter pw = response.getWriter();
		pw.println("Hello, this is myServlet with having ln");
		pw.print("here is no ln");
		
	}

	
}

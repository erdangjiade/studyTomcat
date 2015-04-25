package com.lcy.tomcat;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Locale;

import javax.servlet.ServletOutputStream;
import javax.servlet.ServletResponse;

public class Response  implements ServletResponse{

	private static final int BUFFER_SIZE = 1024;
	private Request request ;
	private OutputStream os;
	
	public Response(OutputStream os){
		this.os = os;
	}
	public void setRequest(Request r){
		request = r;
	}
	
	public void sendStaticResource() throws IOException{
		String uri = request.getUri();
		byte[]	bytes = new byte[BUFFER_SIZE];
		FileInputStream fis = null;
		File file = new File(HttpServer.WEB_ROOT + File.separator + uri);
		
		try{
		if(file.exists()){
			fis = new FileInputStream(file);
			int ch = fis.read(bytes, 0, BUFFER_SIZE);
			while(ch != -1){
				os.write(bytes, 0, ch);
				ch = fis.read(bytes, 0, BUFFER_SIZE);
			}
		}else{
			String errMessage = "HTTP/1.1 404 File Not Found\r\n"+
					"Content-Type: text/html\r\n"+
					"Content-Length: 27\r\n" +
					"\r\n" +
					"<h1>File Is Not Found</h1>";
				os.write(errMessage.getBytes());
		}
		}catch(Exception e){
			System.out.println(e.toString());
		}finally{
			if(fis != null){
				fis.close();
			}
		}
		
	}
	@Override
	public void flushBuffer() throws IOException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public int getBufferSize() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public String getCharacterEncoding() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Locale getLocale() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ServletOutputStream getOutputStream() throws IOException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public PrintWriter getWriter() throws IOException {
		
		return new PrintWriter(os, true);
	}
	
	@Override
	public boolean isCommitted() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public void reset() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void resetBuffer() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void setBufferSize(int arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void setContentLength(int arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void setContentType(String arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void setLocale(Locale arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
}

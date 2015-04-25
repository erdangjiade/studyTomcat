package com.lcy.tomcat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletRequest;

public class Request implements ServletRequest{

	private InputStream is;
	private String uri;
	
	
	public Request(InputStream is){
		this.is = is;
	}
	
	public void parse(){
		StringBuffer sb = new StringBuffer(2048);
		int i;
		byte[] bs = new byte[2048];
		try {
			i = is.read(bs);
		} catch (IOException e) {
			e.printStackTrace();
			i = -1;
		}
		for(int j=0; j<i; j++){
			sb.append((char)bs[j]);
		}
		System.out.println(sb.toString());
		uri = parseUri(sb.toString());
	}
	
	
	private String parseUri(String requestString) {
		int index1 = requestString.indexOf(" ");
		if(index1 != -1){
			int index2 = requestString.indexOf(" ", index1+1);
			if(index2 > index1){
				return requestString.substring(index1+1, index2);
			}
		}
		
		return null;
	}

	public String getUri() {
		return uri;
	}

	@Override
	public Object getAttribute(String arg0) {
		return null;
	}

	@Override
	public Enumeration getAttributeNames() {
		return null;
	}

	@Override
	public String getCharacterEncoding() {
		return null;
	}

	@Override
	public int getContentLength() {
		return 0;
	}

	@Override
	public String getContentType() {
		return null;
	}

	@Override
	public ServletInputStream getInputStream() throws IOException {
		return null;
	}

	@Override
	public Locale getLocale() {
		return null;
	}

	@Override
	public Enumeration getLocales() {
		return null;
	}

	@Override
	public String getParameter(String arg0) {
		return null;
	}

	@Override
	public Map getParameterMap() {
		return null;
	}

	@Override
	public Enumeration getParameterNames() {
		return null;
	}

	@Override
	public String[] getParameterValues(String arg0) {
		return null;
	}

	@Override
	public String getProtocol() {
		return null;
	}

	@Override
	public BufferedReader getReader() throws IOException {
		return null;
	}

	@Override
	public String getRealPath(String arg0) {
		return null;
	}

	@Override
	public String getRemoteAddr() {
		return null;
	}

	@Override
	public String getRemoteHost() {
		return null;
	}

	@Override
	public RequestDispatcher getRequestDispatcher(String arg0) {
		return null;
	}

	@Override
	public String getScheme() {
		return null;
	}

	@Override
	public String getServerName() {
		return null;
	}

	@Override
	public int getServerPort() {
		return 0;
	}

	@Override
	public boolean isSecure() {
		return false;
	}

	@Override
	public void removeAttribute(String arg0) {
		
	}

	@Override
	public void setAttribute(String arg0, Object arg1) {
		
	}

	@Override
	public void setCharacterEncoding(String arg0)
			throws UnsupportedEncodingException {
		
	}
	
}

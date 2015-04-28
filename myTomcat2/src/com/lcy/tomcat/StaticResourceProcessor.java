package com.lcy.tomcat;

import java.io.IOException;

import com.lcy.tomcat.connector.http.HttpRequest;
import com.lcy.tomcat.connector.http.HttpResponse;

public class StaticResourceProcessor {

  public void process(HttpRequest request, HttpResponse response) {
    try {
      response.sendStaticResource();
    }
    catch (IOException e) {
      e.printStackTrace();
    }
  }

}

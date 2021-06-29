package com.mbtroads;

import org.graphwalker.java.test.Result;
import org.graphwalker.java.test.TestExecutor;
import org.graphwalker.websocket.WebSocketServer;

import java.io.IOException;

public class Runner {
  public static void main(String[] args) throws IOException {

    TestExecutor executor1 = new TestExecutor(ArticleCreationTest.class);

//    Result result = executor.execute(true);
//    Result result1 = executor1.execute(true);

    WebSocketServer server = new WebSocketServer(8887, executor1.getMachine());
    server.start();

    Result result1 = executor1.execute(true);
    if (result1.hasErrors()) {
      for (String error : result1.getErrors()) {
        System.out.println(error);
      }
    }

//    System.out.println("Done: [" + result.getResults().toString(2) + "]\n");
    System.out.println("Done: [" + result1.getResults().toString(2) + "]\n");

  }
}

package com.mbtroads;

import com.mbtroads.SomeSmallTest;
import org.graphwalker.java.test.Result;
import org.graphwalker.java.test.TestExecutor;

import java.io.IOException;

public class Runner {
  public static void main(String[] args) throws IOException {
//    TestExecutor executor = new TestExecutor(
//      SomeSmallTest.class
//    );

    TestExecutor executor1 = new TestExecutor(ArticleCreationTest.class);

//    Result result = executor.execute(true);
    Result result1 = executor1.execute(true);

//    System.out.println("Done: [" + result.getResults().toString(2) + "]\n");
    System.out.println("Done: [" + result1.getResults().toString(2) + "]\n");

  }
}

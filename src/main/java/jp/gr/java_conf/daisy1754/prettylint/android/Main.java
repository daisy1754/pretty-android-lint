package jp.gr.java_conf.daisy1754.prettylint.android;

import java.io.File;
import java.util.List;

public class Main {

  public static void main(String[] args) {
    if (args.length == 0) {
      System.out.println("Need file name as argument");
      return;
    }

    Parser parser = new Parser();
    List<Issue> issues = parser.parseFile(new File(args[0]));
    new Writer().writeOutput(issues, System.out);
  }
}

package jp.gr.java_conf.daisy1754.prettylint.android;

import java.io.BufferedOutputStream;
import java.io.PrintStream;
import java.util.List;

/**
 * Format result from {@link Parser} and emit output to stdout.
 */
public class Writer {

  public void writeOutput(List<Issue> issues, PrintStream out) {
    for (Issue i : issues) {
      out.println(i);
    }
  }
}

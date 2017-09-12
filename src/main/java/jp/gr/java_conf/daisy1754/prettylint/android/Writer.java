package jp.gr.java_conf.daisy1754.prettylint.android;

import jp.gr.java_conf.daisy1754.prettylint.android.TextAppearanceHelper.Color;
import jp.gr.java_conf.daisy1754.prettylint.android.data.Issue;
import jp.gr.java_conf.daisy1754.prettylint.android.data.Location;

import java.io.PrintStream;
import java.security.Security;
import java.util.List;

/**
 * Format result from {@link Parser} and emit output to stdout.
 */
public class Writer {

  private final TextAppearanceHelper textHelper = new TextAppearanceHelper();

  public void writeOutput(List<Issue> issues, PrintStream out) {
    for (Issue i : issues) {
      Location l = i.getLocation();
      StringBuilder builder = new StringBuilder();
      builder.append("[")
          .append(textHelper.setColor(
              i.getSeverity().toString(),
              i.getSeverity().equals(Issue.Severity.ERROR) ? Color.RED : Color.YELLOW))
          .append("] ")
          .append(textHelper.setUnderline(i.getType()))
          .append(": ")
          .append(i.getMessage())
          .append(System.lineSeparator())
          .append("line ")
          .append(l.getLine())
          .append(", column ")
          .append(l.getColumn())
          .append(" of ")
          .append(l.getFilePath())
          .append(System.lineSeparator());
      out.println(builder.toString());
    }
    long numErrors =
        issues.stream().filter(i -> Issue.Severity.ERROR.equals(i.getSeverity())).count();
    out.println(String.format("%d errors found", numErrors));
  }
}

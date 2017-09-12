package jp.gr.java_conf.daisy1754.prettylint.android.data;

/**
 * Represents entry in lint output, either warning or error.
 */
public class Issue {
  private final String type;
  private final Severity severity;
  private final String message;
  private final Location location;

  public Issue(String type, Severity severity, String message, Location location) {
    this.type = type;
    this.severity = severity;
    this.message = message;
    this.location = location;
  }

  @Override
  public String toString() {
    return new StringBuilder()
        .append("type: ")
        .append(type)
        .append(", severity: ")
        .append(severity)
        .append(", message: ")
        .append(message)
        .append(", file: ")
        .append(location.getFilePath())
        .append(", line: ")
        .append(location.getLine())
        .toString();
  }

  public enum Severity {
    ERROR, WARNING
  }
}

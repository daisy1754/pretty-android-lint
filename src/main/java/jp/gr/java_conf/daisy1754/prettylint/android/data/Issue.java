package jp.gr.java_conf.daisy1754.prettylint.android.data;

/**
 * Represents entry in lint output, either warning or error.
 */
public class Issue {
  private final String type;
  private final Severity severity;
  private final String message;

  public Issue(String type, Severity severity, String message) {
    this.type = type;
    this.severity = severity;
    this.message = message;
  }

  @Override
  public String toString() {
    return new StringBuilder().append("type: ").append(type).append(", severity: ").append(severity).append(", message: ").append(message).toString();
  }

  public enum Severity {
    ERROR, WARNING
  }
}

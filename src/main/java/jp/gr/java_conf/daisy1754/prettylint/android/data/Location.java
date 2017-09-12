package jp.gr.java_conf.daisy1754.prettylint.android.data;

/**
 * Contains information about where lint issue happens (ie, file, line and column).
 */
public class Location {
  private final String filePath;
  private final int line;
  private final int column;

  public Location(String filePath, int line, int column) {
    this.filePath = filePath;
    this.line = line;
    this.column = column;
  }

  public String getFilePath() {
    return filePath;
  }

  public int getLine() {
    return line;
  }

  public int getColumn() {
    return column;
  }
}

package jp.gr.java_conf.daisy1754.prettylint.android;

/**
 * Helper class that allows put color on text.
 */
public class TextAppearanceHelper {
  private static final String ANSI_START_CHARS = "\u001B[";
  private static final String ANSI_UNDERLINE = ANSI_START_CHARS + "4m";
  private static final String ANSI_RESET = "\u001B[0m";

  public String setColor(String input, Color color) {
    return ANSI_START_CHARS + color.value + 'm' + input + ANSI_RESET;
  }

  public String setUnderline(String input) {
    return ANSI_UNDERLINE + input + ANSI_RESET;
  }

  public enum Color {
    BLACK(30), RED(31), GREEN(32), YELLOW(33), BLUE(34), PURPLE(35), CYAN(36), WHITE(37);

    private final int value;
    Color(int value) {
      this.value = value;
    }
  }
}

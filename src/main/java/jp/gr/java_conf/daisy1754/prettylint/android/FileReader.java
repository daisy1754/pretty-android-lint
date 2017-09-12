package jp.gr.java_conf.daisy1754.prettylint.android;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * Reads file.
 */
public class FileReader {

  /**
   * Extract the specified line from given file.
   */
  public String extractLine(String path, int lineIndex) throws IOException {
    try (Stream<String> lines = Files.lines(Paths.get(path))) {
      if (lineIndex == 0) {
        return lines.findFirst().get();
      }
      return lines.skip(lineIndex - 1).findFirst().get();
    }
  }
}

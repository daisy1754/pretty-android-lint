package jp.gr.java_conf.daisy1754.prettylint.android;

import jp.gr.java_conf.daisy1754.prettylint.android.data.Issue;
import jp.gr.java_conf.daisy1754.prettylint.android.data.Issue.Severity;
import jp.gr.java_conf.daisy1754.prettylint.android.data.Location;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

/**
 * Parse given lint-results.xml file.
 */
public class Parser {

  /**
   * Parse lint-results.xml file and returns list of {@link Issue}s.
   */
  public List<Issue> parseFile(File file) {
    DocumentBuilder builder;
    Document doc;
    try {
      builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
      doc = builder.parse(file);
    } catch (Exception e) {
      // TODO: handle exception
      throw new IllegalStateException("problem while parsing", e);
    }
    doc.getDocumentElement().normalize();

    List<Issue> issues = new ArrayList<>();
    NodeList nodes = doc.getElementsByTagName("issues").item(0).getChildNodes();
    for (int i = 0; i < nodes.getLength(); i++) {
      Node node = nodes.item(i);
      if (node.getNodeType() == Node.ELEMENT_NODE) {
        Element element = (Element) node;
        Severity severity = Severity.valueOf(element.getAttribute("severity").toUpperCase());
        if (Severity.WARNING.equals(severity)) {
          // Ignore warning for now
          continue;
        }
        String type = element.getAttribute("id");
        String message = element.getAttribute("message");
        Location location = parseLocation(
            (Element) element.getElementsByTagName("location").item(0));
        // TODO: validate input
        issues.add(
            new Issue(type, severity, message, location));
      }
    }
    return issues;
  }

  private Location parseLocation(Element element) {
    return new Location(element.getAttribute("file"),
        parseWithDefault(element.getAttribute("line"), -1),
        parseWithDefault(element.getAttribute("column"), -1));
  }

  private int parseWithDefault(String input, int defaultValue) {
    try {
      return Integer.parseInt(input);
    } catch (NumberFormatException e) {
      return defaultValue;
    }
  }
}

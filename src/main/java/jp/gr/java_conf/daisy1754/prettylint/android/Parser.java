package jp.gr.java_conf.daisy1754.prettylint.android;

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
        String type = element.getAttribute("id");
        String severity = element.getAttribute("severity");
        String message = element.getAttribute("message");
        // TODO: validate input
        issues.add(new Issue(type, Issue.Severity.valueOf(severity.toUpperCase()), message));
      }
    }
    return issues;
  }
}

package test;

import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import parser.XMLParser;

public class XMLParserTest {
    @Test
    public void positiveTests(String actual, String expected) {
        XMLParser parser = new XMLParser("src/main/test/resources/test.xml");
        parser.parseDocument();
        assertion.assertEquals(actual, expected);
    }
}

package test;

import org.testng.*;
import org.testng.annotations.Test;

import parser.XMLParser;

import static org.testng.Assert.assertEquals;

public class XMLParserTest {
    @Test
    public void positiveTests(String actual, String expected) {
        XMLParser parser = new XMLParser("src/main/test/valid.xml");
        parser.parseDocument();
        Assert.assertEquals(parser.getErrors().size(), 0, "Should have no errors");
    }

    @Test
    public void NullTest() {
        XMLParser parser = new XMLParser(null);
    }
}

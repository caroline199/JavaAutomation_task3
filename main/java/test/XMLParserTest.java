package test;

import org.testng.*;
import org.testng.annotations.Test;
import parser.XMLParser;

public class XMLParserTest {

    @Test
    public void testValidXML() {
        XMLParser parser = new XMLParser("/Users/karolinakiselyova/IdeaProjects/JavaAutomation_task3/main/java/test/resources/valid.xml");
        parser.parseDocument();
        Assert.assertEquals(parser.getErrors().size(), 0, "Passed");
    }
    @Test
    public void testInvalidXML() {
        XMLParser parser = new XMLParser("/Users/karolinakiselyova/IdeaProjects/JavaAutomation_task3/main/java/test/resources/invalid.xml");
        parser.parseDocument();
        Assert.assertEquals(parser.getErrors().size(), 1, "1 Failed");
        Assert.assertEquals(parser.getErrors().get(0), "Unexpected closing tag fruits");
    }
}

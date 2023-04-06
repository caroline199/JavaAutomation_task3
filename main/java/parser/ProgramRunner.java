package parser;

import utilities.Iterator;

public class ProgramRunner {

    public static void main(String[] args) {
        XMLParser parser = new XMLParser("/Users/karolinakiselyova/IdeaProjects/JavaAutomation_task3/main/java/test/resources/valid.xml");
        parser.parseDocument();
        if (parser.getErrors().isEmpty()) {
            System.out.println("Valid xml");
        } else {
            Iterator<String> errorsIter = parser.getErrors().iterator();
            while (errorsIter.hasNext()) {
                System.out.println(errorsIter.next());
            }
        }
    }
}
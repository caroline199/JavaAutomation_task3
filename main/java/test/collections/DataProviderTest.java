package test.collections;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utilities.MyArrayList;

public class DataProviderTest {



    @DataProvider (name = "data-provider")
    public Object[][] setElement() {
        return new Object[][]{
                {true, 5},
                {false, 1},
                {true, 0},
                {true, -7},
                {false, 7},
        };
    }

    @Test(dataProvider = "data-provider")
    public void testAddIndexElement(boolean expected, int value) {
        MyArrayList<Integer> testingArray = new MyArrayList<>();
        testingArray.add(34);
        testingArray.add(5);
        testingArray.add(90);
        testingArray.add(-7);
        testingArray.add(0);
        testingArray.add(122);
        testingArray.add(-67);

        boolean actual = testingArray.contains(value);
        assertEquals(actual, expected);
    }
}

package test.collections;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import utilities.MyArrayList;

public class MyArrayListTest {

    private MyArrayList<Integer> testingArray;

    @BeforeMethod
    public void initArray() {
        testingArray = new MyArrayList<>();
    }

    @Test
    public void testInitialSize() {
        Assert.assertEquals(testingArray.size(), 0);
    }

    @Test(groups = "additionTests")
    public void testAddElement() {
        testingArray.add(5);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(testingArray.size(), 1);
        softAssert.assertEquals(testingArray.get(0).intValue(), 5);
        softAssert.assertAll();
    }

    @Test(dependsOnMethods = "testAddElement")
    public void testDeleteElement() {
        testingArray.add(5);
        testingArray.remove(0);
        Assert.assertTrue(testingArray.isEmpty());
    }

    @Test(dependsOnMethods = "testAddElement")
    public void testGetElement() {
        testingArray.add(10);
        testingArray.add(4);
        Assert.assertEquals(testingArray.get(1).intValue(), 4);
    }

    @Test(groups = "newTests")
    public void testAddIndexElement() {
        testingArray.add(0, 5);
        testingArray.add(1, 4);
        testingArray.add(2, 3);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(testingArray.size(), 3);
        softAssert.assertEquals(testingArray.get(2).intValue(), 3);
        softAssert.assertAll();
    }

    @Test(groups = "newTests",dependsOnMethods = "testAddIndexElement")
    public void testClearArray() {
        testingArray.add(0, 5);
        testingArray.add(1, 4);
        testingArray.add(2, 3);
        testingArray.clear();
        Assert.assertTrue(testingArray.isEmpty());
    }

    @Test(groups = "newTests",dependsOnMethods = "testAddElement")
    public void testChangeElement() {
        testingArray.add(5);
        testingArray.set(0, 10);
        Assert.assertEquals(testingArray.get(0).intValue(), 10);
    }

    @Test(groups = "newTests",dependsOnMethods = "testAddElement")
    public void testFindElement() {
        testingArray.add(5);
        testingArray.add(0);
        testingArray.add(4);
        testingArray.add(2);
        Assert.assertTrue(testingArray.contains(0));
    }
}
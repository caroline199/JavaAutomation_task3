package test.collections;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.MyStack;

public class MyStackTest {

    private MyStack<Integer> testingStack;

    @BeforeMethod
    public void initStack() {
        testingStack = new MyStack<>();
    }

    @Test
    public void testInitialSize() {
        Assert.assertEquals(testingStack.size(), 0);
    }

    @Test(groups = "additionTests")
    public void testPush() {
        testingStack.push(6);
        Assert.assertEquals(testingStack.size(), 1);
    }

    @Test(groups = "newTests", dependsOnMethods = "testPush")
    public void testPop() {
        testingStack.push(6);
        testingStack.push(5);
        testingStack.push(4);
        Assert.assertEquals(testingStack.pop(), (Integer)4);
    }

    @Test(groups = "newTests", dependsOnMethods = "testPop")
    public void testPeek() {
        testingStack.push(6);
        testingStack.push(5);
        testingStack.push(4);
        testingStack.pop();
        Assert.assertEquals(testingStack.peek(), (Integer)5);
    }

    @Test(groups = "newTests", dependsOnMethods = "testPush")
    public void testDelete() {
        testingStack.push(6);
        testingStack.push(5);
        testingStack.push(4);
        testingStack.clear();
        Assert.assertTrue(testingStack.isEmpty());
    }

    @Test(groups = "newTests", dependsOnMethods = "testPush")
    public void testContains() {
        testingStack.push(6);
        testingStack.push(5);
        testingStack.push(4);
        Assert.assertTrue(testingStack.contains(5));
    }

    @Test(groups = "newTests", dependsOnMethods = "testPush")
    public void testSearch() {
        testingStack.push(6);
        testingStack.push(5);
        testingStack.push(4);
        Assert.assertEquals(testingStack.search(6), 3);
    }

    @Test(groups = "newTests", dependsOnMethods = "testPush")
    public void testEquals() {
        testingStack.push(6);
        testingStack.push(5);
        testingStack.push(4);

        MyStack<Integer> newStack = new MyStack<>();
        newStack.push(6);
        newStack.push(5);
        newStack.push(4);

        Assert.assertTrue(testingStack.equals(newStack));
    }

    @Test(groups = "newTests", dependsOnMethods = "testPush")
    public void testArrayObject() {
        testingStack.push(6);
        testingStack.push(5);
        testingStack.push(4);

        Object[] arr = testingStack.toArray();
        Assert.assertEquals(testingStack.size(), arr.length);
    }

    @Test(groups = "newTests", dependsOnMethods = "testPush")
    public void testArray() {
        testingStack.push(6);
        testingStack.push(5);
        testingStack.push(4);

        Integer[] arr = new Integer[3];
        arr=testingStack.toArray(arr);
        Assert.assertEquals(testingStack.pop(), arr[0]);
    }
}

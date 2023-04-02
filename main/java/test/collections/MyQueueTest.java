package test.collections;

import static org.testng.Assert.assertThrows;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import exceptions.EmptyQueueException;
import utilities.MyQueue;

public class MyQueueTest {
    private MyQueue<Integer> testingQueue;

    @BeforeMethod
    public void initQueue() {
        testingQueue = new MyQueue<>();
    }

    @Test
    public void testInitialSize() {
        Assert.assertEquals(testingQueue.size(), 0);
    }

    @Test(groups = "newTests")
    public void testEnqueue() {
        testingQueue.enqueue(6);
        testingQueue.enqueue(5);
        testingQueue.enqueue(4);
        Assert.assertEquals(testingQueue.size(), 3);
    }

    @Test(groups = "newTests")
    public void testEnqueueNull() {
        assertThrows(NullPointerException.class, () -> testingQueue.enqueue(null));
    }

    @Test(groups = "newTests")
    public void testEmptyQueue() {
        Assert.assertTrue(testingQueue.isEmpty());
    }

    @Test(groups = "newTests", dependsOnMethods = "testEnqueue")
    public void testNotFullQueue() {
        testingQueue.enqueue(6);
        Assert.assertFalse(testingQueue.isFull());
    }

    @Test(groups = "newTests", dependsOnMethods = "testEnqueue")
    public void testDequeue() {
        testingQueue.enqueue(6);
        testingQueue.enqueue(5);
        testingQueue.enqueue(4);
        testingQueue.dequeue();
        testingQueue.dequeue();
        Assert.assertEquals(testingQueue.size(), 1);
    }

    @Test(groups = "newTests")
    public void testDequeueEmptyQueue() {
        assertThrows(EmptyQueueException.class, () -> testingQueue.dequeue());
    }

    @Test(groups = "newTests", dependsOnMethods = "testEnqueue")
    public void testDequeueAll() {
        testingQueue.enqueue(6);
        testingQueue.enqueue(5);
        testingQueue.dequeueAll();
        Assert.assertEquals(testingQueue.size(), 0);
    }
}

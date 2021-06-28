package QueImplementationTest;


import QueueImplementation.Queue;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class QueTest {


    @Test
    void addNoneTest() {
        Queue<Integer> queue = new Queue<>();
        assertEquals(0, queue.size());
        assertThrows(NullPointerException.class, queue::get);
    }

    @Test
    void addOneTest() {
        Queue<Integer> queue = new Queue<>();
        queue.add(24);
        assertEquals(1, queue.size());
    }

    @Test
    void addMoreThanOneTest() {
        Queue<Integer> queue = new Queue<>();
        queue.add(10);
        queue.add(20);
        queue.add(25);
        assertEquals(3, queue.size());

    }

    @Test
    void removeNoneTest() {
        Queue<Integer> queue = new Queue<>();
        assertFalse(queue.remove());
    }

    @Test
    void removeFromOneTest() {
        Queue<Integer> queue = new Queue<>();
        queue.add(1);
        assertTrue(queue.remove());
        assertEquals(0, queue.size());
    }

    @Test
    void removeFromManyTest() {
        Queue<String> queue = new Queue<>();
        queue.add("Hello");
        queue.add("World");
        queue.add("India");
        assertEquals(3, queue.size());
        queue.remove();
        assertEquals(2, queue.size());
        assertEquals("World", queue.get());
        queue.remove();
        assertEquals(1, queue.size());
        assertEquals("India", queue.get());
    }




}

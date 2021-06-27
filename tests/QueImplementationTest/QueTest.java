package QueImplementationTest;


import QueueImplementation.Queue;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class QueTest {



    @Test
    void addNoneTest() {
        Queue<Integer> queue = new Queue<>();
        assertEquals(0,queue.size());
        assertThrows(NullPointerException.class,()->{
           queue.get();
        });
    }
    @Test
    void addOneTest() {
        Queue<Integer> queue = new Queue<>();
        queue.add(24);
        assertEquals(1, queue.size());
    }

    @Test
    void addMoreThanOneTest(){
        Queue<Integer> queue = new Queue<>();
        queue.add(10);
        queue.add(20);
        queue.add(25);
        assertEquals(3,queue.size());

    }

}

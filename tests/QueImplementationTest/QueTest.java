package QueImplementationTest;


import QueueImplementation.Queue;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class QueTest {

    @Test
    void addOneTest(){
        Queue<Integer> queue = new Queue<>();
        queue.add(24);
        assertEquals(1,queue.size());
    }
    @Test
    void addNoneTest(){
        Queue<Integer> queue = new Queue<>();

    }
}

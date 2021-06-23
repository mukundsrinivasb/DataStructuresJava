package Setimplementation;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public abstract class TestSet {
    public abstract <T extends Comparable<T>> HashMaps<T> createSet();

    @Test
    void addNothingTest() {
        HashMaps<Integer> set=  createSet();
        set.add(5);
        assertEquals(1,set.size());
    }
}

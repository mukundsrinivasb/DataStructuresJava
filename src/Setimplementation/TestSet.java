package Setimplementation;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

public abstract class TestSet {
    public abstract <T extends Comparable<T>> HashMaps<T> createSet();

    @Test
    void addNothingTest() {
        HashMaps<Integer> set = createSet();
        assertEquals(0, set.size());
    }

    @Test
    void addOneTest() {
        HashMaps<Integer> set = createSet();
        set.add(1);
        assertEquals(1, set.size());
    }

    @Test
    void addManyTests() {
        HashMaps<Integer> set = createSet();
        set.add(25);
        set.add(43);
        assertEquals(2, set.size());
    }

    @Test
    void addDuplicate() {
        HashMaps<Integer> set = createSet();
        assertTrue(set.add(1));
        assertFalse(set.add(1));
    }

    @Test
    void containsTest() {
        HashMaps<Integer> set = createSet();
        assertFalse(set.Contains(1));
        set.add(1);
        assertTrue(set.Contains(1));
    }

    @Test
    void containsManyTest() {
        HashMaps<Integer> set = createSet();
        set.add(2);
        set.add(40);
        set.add(20);
        assertFalse(set.Contains(3));
        assertTrue(set.Contains(20));
    }

    @Test
    void removeFromOneTest() {
        HashMaps<Integer> set = createSet();
        set.add(2);
        set.remove(2);
        set.remove(1);
        assertEquals(0, set.size());
    }

    @Test
    void removeFromManyTest() {
        HashMaps<Integer> set = createSet();
        for (int i = 0; i < 50; i++) {
            set.add(i);
        }
        assertEquals(50, set.size());
        set.remove(50);
        assertEquals(50, set.size());
        set.remove(1);
        assertEquals(49, set.size());
    }

    @Test
    void toArrayOneElementTest() {
        HashMaps<String> set = createSet();
        set.add("One");
    }

    @Test
    void toArrayNoneElementTest() {

    }

    @Test
    void toArrayManyElementsTest() {

    }

    void checkArray(HashMaps<String> set, String[] chkArr) {

    }
}

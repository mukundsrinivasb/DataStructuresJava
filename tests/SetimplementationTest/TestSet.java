package SetimplementationTest;

import Setimplementation.Set;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import java.util.Arrays;


import static org.junit.jupiter.api.Assertions.*;

public abstract class TestSet {
    public abstract <T extends Comparable<T>> Set<T> createSet();


    @Test
    void addNothingTest() {
        Set<Integer> set = createSet();
        assertEquals(0, set.size());
    }

    @Test
    void addOneTest() {
        Set<Integer> set = createSet();
        set.add(1);
        assertEquals(1, set.size());
    }

    @Test
    void addManyTests() {
        Set<Integer> set = createSet();
        set.add(25);
        set.add(43);
        set.add(90);
        set.add(92);
        assertEquals(4, set.size());
    }

    @Test
    @DisplayName("Gotta pass this one 😱")
    void addCopies() {
        Set<Integer> set = createSet();
        set.add(25);
        assertEquals(1, set.size());
        assertFalse(set.add(25));
        set.add(14);
        assertEquals(2, set.size());
        assertFalse(set.add(14));
        set.add(67);
        assertEquals(3, set.size());
        assertFalse(set.add(67));
        set.add(92);
        assertEquals(4, set.size());
        assertFalse(set.add(92));

    }


    @Test
    void containsTest() {
        Set<Integer> set = createSet();
        assertFalse(set.Contains(1));
        set.add(1);
        assertTrue(set.Contains(1));
    }

    @Test
    void containsManyTest() {
        Set<Integer> set = createSet();
        set.add(2);
        set.add(40);
        set.add(20);
        assertFalse(set.Contains(3));
        assertTrue(set.Contains(20));
    }

    @Test
    void removeFromOneTest() {
        Set<Integer> set = createSet();
        set.add(2);
        set.remove(2);
        assertEquals(0, set.size());
    }

    //The remove method does not delete the value in the set
    @Test
    void removeFromManyTest() {
        Set<Integer> set = createSet();
        set.add(40);
        set.add(20);
        set.add(80);
        set.add(26);
        set.add(89);
        set.add(8);
        set.add(1);
        set.remove(89);
        assertEquals(6, set.size());
        set.remove(20);
        assertEquals(5,set.size());
        set.remove(10);
        assertEquals(5,set.size());

    }

    @Test
    void toArrayOneElementTest() {
        Set<String> set = createSet();
        set.add("One");
        String[] chkArr = {"One"};
        assertTrue(checkArray(set, chkArr));
    }

    @Test
    void toArrayNoneElementTest() {
        Set<String> set = createSet();
        String[] chArr = new String[0];
        assertTrue(checkArray(set, chArr));
    }

    @Test
    void toArrayManyElementsTest() {
        Set<String> set = createSet();
        set.add("Never");
        set.add("Wanna");
        set.add("Give");
        set.add("you");
        set.add("up");
        String[] chkArr = {"Never", "Wanna", "Give", "you", "up"};
        assertTrue(checkArray(set, chkArr));
    }


    boolean checkArray(Set<String> set, String[] chkArr) {
        var setArr = set.toArray();
        Arrays.sort(setArr);
        Arrays.sort(chkArr);
        return Arrays.equals(setArr, chkArr);
    }
}

package ListImplementationTest;

import ListImplementation.List;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public abstract class ListTest<T> {
    public abstract <T> List<T> createList();

    @Test
    void addManyTest() {
        List<Integer> list = createList();
        int size = AddElements(list);
        assertEquals(size, list.size());
    }

    int AddElements(List<Integer> list) {
        Random r = new Random();
        int s = r.nextInt(100);
        for (int i = 0; i < s; i++) {
            list.add(r.nextInt());
        }
        return s;
    }

    @Test
    void addNothingTest() {
        List<Integer> list = createList();
        assertEquals(0, list.size());
    }

    @Test
    void getFromEmptyTest() {
        List<Integer> list = createList();
        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.get(4);
        });
    }

    @Test
    void getFromAHugeset() {
        ArrayList<Integer> checkInt = new ArrayList<>();
        List<Integer> list = createList();
        Random rand = new Random();
        for (int i = 0; i < 100; i++) {
            checkInt.add(rand.nextInt());
            list.add(checkInt.get(i));
        }
        int rAdd = rand.nextInt(100);
        assertEquals(checkInt.get(rAdd), list.get(rAdd));
    }

    @Test
    void removeFromEmptyTest() {
        List<Integer> list = createList();
        assertThrows(NullPointerException.class, () -> {
            list.remove(0);
        });
    }

    @Test
    void removeFromSingleTest() {
        List<Integer> list = createList();
        list.add(24);
        assertEquals(1, list.size());
        list.remove(0);
        assertEquals(0, list.size());
    }

    @Test
    void removeFromMany() {
        List<Integer> list = createList();
        list.add(1);
        list.add(54);
        list.remove(1);
        assertEquals(1, list.size());
    }

    @Test
    void reverseNoneTest() {
        List<Integer> list = createList();
        list.reverse();
        assertEquals(0,list.size());
    }

    @Test
    void reverseOneTest() {
        List<Integer> list = createList();
        list.add(1);
        assertEquals(1, list.size());
        list.reverse();
        assertEquals(1, list.get(0));
    }

    @Test
    void reverseManyTest(){
        List<Integer> list = createList();
        list.add(2);
        list.add(3);
        list.add(10);
        assertEquals(2,list.get(0));
        list.reverse();
        assertEquals(10,list.get(0));
    }

}

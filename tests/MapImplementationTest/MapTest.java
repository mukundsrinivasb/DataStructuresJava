package MapImplementationTest;

import MapImplementation.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public abstract class MapTest {
    public abstract <K extends Comparable<? super K>, V> Map<K, V> createMap();

    @Test
    @DisplayName("put nothing")
    void addNoneTest() {
        Map<String, Integer> map = createMap();
        assertEquals(0, map.size());
    }

    @Test
    @DisplayName("put exactly one")
    void addOne() {
        Map<String, Integer> map = createMap();
        map.put("Orange", 60);
        assertEquals(1, map.size());

    }

    @Test
    @DisplayName("put many")
    void addMany() {
        Map<String, Integer> map = createMap();
        map.put("Orange", 60);
        map.put("Mango", 80);
        map.put("Apple", 90);
        assertEquals(map.size(), 3);
    }

    @Test
    @DisplayName("get from One")
    void getOne() {
        Map<String, Integer> map = createMap();
        map.put("Peach", 25);
        assertEquals(25,map.get("Peach"));
    }
    @Test
    @DisplayName("put an invalid key value pair")
    void addInvalid(){
        Map<String,Integer> map = createMap();
        assertThrows(IllegalArgumentException.class,()->map.put("Banana" , null));
    }

    @Test
    @DisplayName("get from None")
    void getFromNone() {
        Map<String, Integer> map = createMap();
        assertNull(map.get("Apple"));
    }

    @Test
    @DisplayName("get from Many ")
    void getFromMany(){
        Map<String,Float> map = createMap();
        map.put("Grape",50.0F);
        map.put("Jack Fruit",70.03F);
        assertEquals(70.03F,map.get("Jack Fruit"));
    }


}

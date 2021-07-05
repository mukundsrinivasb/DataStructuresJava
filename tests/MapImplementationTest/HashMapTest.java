package MapImplementationTest;

import MapImplementation.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public abstract class HashMapTest {
    public abstract <K extends Comparable<? super K>, V> Map<K, V> createMap();

    @Test
    @DisplayName("👌")
    void addOneTest() {
        Map<String, Integer> map = createMap();
        assertEquals(0, map.size());
    }

    @Test
    @DisplayName("👆")
    void addOne() {
        Map<String, Integer> map = createMap();
        map.put("Orange", 60);
        assertEquals(1, map.size());

    }

    @Test
    @DisplayName("🤙")
    void addMany() {
        Map<String, Integer> map = createMap();
        map.put("Orange", 60);
        map.put("Mango", 80);
        map.put("Apple", 90);
        assertEquals(map.size(), 3);

    }

}

package MapImplementationTest;

import MapImplementation.HashMap;
import MapImplementation.Map;

public class HasMapTest extends MapTest {
    @Override
    public <K extends Comparable<? super K>, V> Map<K, V> createMap() {
        return new HashMap<>();

    }
}

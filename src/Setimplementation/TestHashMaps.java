package Setimplementation;

public class TestHashMaps extends TestSet {
    @Override
    public <T extends Comparable<T>> HashMaps<T> createSet() {
        return new HashMaps<T>();
    }
}

package Setimplementation;
import java.util.LinkedList;

public class HashMaps<T extends Comparable> implements Set<T> {
    private static final int DEFAULT_SIZE = 4;
    public LinkedList<T>[] table;
    private int size;

    public HashMaps(int size) {
        table = new LinkedList[size];
    }

    public HashMaps() {
        table = new LinkedList[DEFAULT_SIZE];
    }

    @Override
    public boolean add(T value) {
        return false;

    }

    @Override
    public boolean Contains(T value) {
        return false;
    }

    @Override
    public void remove(T value) {

    }

    @Override
    public int size() {
        return 0;
    }

    LinkedList<T> getElement(T element) {
        int hash = element.hashCode();
        int bucket = Math.abs(hash) % table.length;
        LinkedList<T> refBucket = table[bucket];
        if (refBucket == null) {
            table[bucket] = new LinkedList<>();
            refBucket = table[bucket];
        }
        return refBucket;
    }
}

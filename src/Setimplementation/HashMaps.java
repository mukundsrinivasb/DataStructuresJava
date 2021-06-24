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
        LinkedList<T> thisList = getElement(value);
        if (!thisList.isEmpty()) {
            if (thisList.contains(value)) {
                return false;
            }
        }
        thisList.add(value);
        size++;
        return true;
    }

    @Override
    public boolean Contains(T value) {
        LinkedList<T> thisList = getElement(value);
        for (T element : thisList) {
            if (element.equals(value)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void remove(T value) {
        LinkedList<T> thisList = getElement(value);
        if (Contains(value)) {
            thisList.remove(value);
            size--;
        }
    }

    @Override
    public int size() {
        return size;
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

    @Override
    public Object[] toArray() {
        Object[] retArray = new Object[size];
        int c = 0;
        for (LinkedList<T> temp : table) {
            for (T val : temp) {
                retArray[c] = val;
                c++;
            }
        }
        return retArray;

    }
}

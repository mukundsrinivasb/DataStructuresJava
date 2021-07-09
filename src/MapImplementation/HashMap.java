package MapImplementation;

import ListImplementation.LinkedList;

import java.util.Arrays;

public class HashMap<K extends Comparable<? super K>, V> implements Map<K, V> {

    class KVPair implements Comparable<K> {
        K key;
        V value;

        KVPair(K k, V v) {
            key = k;
            value = v;
        }

        @Override
        public int compareTo(K o) {
            return key.compareTo(o);
        }

        K getKey() {
            return key;
        }

        V getValue() {
            return value;
        }


    }

    public static final int DEF_SIZE = 4;
    public int size = 0;
    public LinkedList<KVPair> table[];

    public HashMap(int size) {
        table = new LinkedList[size];
    }

    public HashMap() {
        table = new LinkedList[DEF_SIZE];
    }

    @Override
    public V put(K key, V value) {
        KVPair nNode = new KVPair(key, value);
        LinkedList<KVPair> tListBucket = getList(nNode);
        //if the linked list is empty
        if (tListBucket.isEmpty()) {
            tListBucket.add(nNode);
            size++;
            return nNode.getValue();
        } //if the linked list is not empty
        for (int i = 0; i < tListBucket.size(); i++) { //Check for values that already have corresponding keys
            if (tListBucket.get(i).compareTo(key) == 0) {
                KVPair retNode = tListBucket.get(i);
                tListBucket.remove(i);
                tListBucket.add(nNode);
                return retNode.getValue();
            }//If the value is not in the list
            tListBucket.add(nNode);
            return nNode.getValue();
        }

    }

    @Override
    public V get(K key) {

    }

    @Override
    public V remove(K key) {
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    /**
     * get the list in which a KVPair might exist
     *
     * @param fElement Element that has to be found within the map
     * @return if present The list of KVPairs in a bucket else an empty list
     */
    LinkedList<KVPair> getList(KVPair fElement) {
        int hash = fElement.hashCode();
        int bucket = Math.abs(hash) % table.length;
        LinkedList<KVPair> refBucket = table[bucket];
        if (refBucket.isEmpty()) {
            table[bucket] = new LinkedList<>();
            refBucket = table[bucket];
        }
        return refBucket;
    }

    @Override
    public boolean Contains(K key) {
        int hash = key.hashCode();
        int bucket = hash % table.length;
        if (!table[bucket].isEmpty())
            for (int i = 0; i < table[bucket].size(); i++)
                if (table[bucket].get(i).compareTo(key) == 0)
                    return true;
        return false;
    }
}

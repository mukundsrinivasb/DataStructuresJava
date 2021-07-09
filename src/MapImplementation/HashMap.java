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
        LinkedList<KVPair> tListBucket = getList(key);
        //if key is present
        if (Contains(key) != -1) {
            V val = tListBucket.get(Contains(key)).getValue();
            tListBucket.remove(Contains(key));
            tListBucket.add(nNode);
            return val;
        } else {
            tListBucket.add(nNode);
            return value;
        }

    }


    @Override
    public V get(K key) {
        if(Contains(key) != -1){
            LinkedList<KVPair> retList = getList(key);
            retList.get(Contains(key)).getValue();
        }
        return null;
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
     * @param key Element that has to be found within the map
     * @return if present The list of KVPairs in a bucket else an empty list
     */
    LinkedList<KVPair> getList(K key) {
        int hash = key.hashCode();
        int bucket = Math.abs(hash) % table.length;
        LinkedList<KVPair> refBucket = table[bucket];
        if (refBucket.isEmpty()) {
            table[bucket] = new LinkedList<>();
            refBucket = table[bucket];
        }
        return refBucket;
    }

    /**
     * get the index at which a key is present in a liked List
     * @param key check
     * @return number of KVPairs from the start node , -1  if absent or null
     */
    public int Contains(K key) {
        KVPair fNode = new KVPair(key, null);
        LinkedList<KVPair> fList = getList(key);
        if (!fList.isEmpty())
            for (int i = 0; i < fList.size(); i++)
                if (fList.get(i).compareTo(key) == 0)
                    return i;
        return -1;
    }
}

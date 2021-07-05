package Map;

import ListImplementation.LinkedList;
import Setimplementation.HashMaps;


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


    }

    public static final int DEF_SIZE = 4;
    public LinkedList<KVPair> table[];

    HashMap(int size) {
        table = new LinkedList[4];
    }

    HashMap() {
        table = new LinkedList[DEF_SIZE];
    }

    @Override
    public V put(K key, V value) {
        return value;
    }

    @Override
    public V get(K key) {
        return null;
    }

    @Override
    public V remove(K key) {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }
}

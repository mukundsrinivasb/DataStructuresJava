package MapImplementation;

import ListImplementation.LinkedList;


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
    public LinkedList<KVPair> table[];

    HashMap(int size) {
        table = new LinkedList[4];
    }

    HashMap() {
        table = new LinkedList[DEF_SIZE];
    }

    @Override
    public V put(K key, V value) {
        KVPair nNode = new KVPair(key, value);
        LinkedList<KVPair> tList = getList(nNode);
        KVPair retNode = null;
        for (int i = 0; i < tList.size(); i++) {
            if (tList.get(i).compareTo(nNode.getKey()) == 0) {
                retNode = tList.get(i);
                tList.remove(i);
                tList.add(nNode);
            }
        }
        return retNode.getValue();
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

    /**
     * Get the list in which the element should be  present
     * @param fElement Element that has to be found within the map
     * @return The list that should contain the element
     */
    LinkedList<KVPair> getList(KVPair fElement) {
        int hash = fElement.hashCode();
        int bucket = Math.abs(hash) % table.length;
        if (table[bucket] != null)
            return table[bucket];
        return new LinkedList<>();
    }
}

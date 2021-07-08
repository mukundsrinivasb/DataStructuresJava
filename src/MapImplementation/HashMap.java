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
        int listAddr = getList(nNode);
        if (nNode.getValue() != null) {
            try {
                for (int i = 0; i < table[listAddr].size(); i++) {
                    KVPair tElement = table[listAddr].get(i);
                    if (tElement.compareTo(nNode.getKey()) == 0) {
                        table[listAddr].remove(i);
                        table[listAddr].add(nNode);
                        return tElement.getValue();
                    }

                }
                table[listAddr].add(nNode);
                size++;

            } catch (NullPointerException e) {
                LinkedList<KVPair> nTable[] = Arrays.copyOf(table, table.length + 1);
                nTable[listAddr] = new LinkedList<>();
                nTable[listAddr].add(nNode);
                table = Arrays.copyOf(nTable, nTable.length);
                size++;
                return nNode.getValue();
            }

            return nNode.getValue();
        }
        throw new IllegalArgumentException("There is no value to this key");

    }

    @Override
    public V get(K key) {
        KVPair cPair = new KVPair(key,null);
        int hash = cPair.hashCode();
        int bucket = Math.abs(hash) % table.length;
        if (table[bucket] != null) {
            for (int i = 0; i < table[bucket].size(); i++) {
                if (table[bucket].get(i).compareTo(cPair.getKey()) == 0) {
                    return table[bucket].get(i).getValue();
                }
            }
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
     * Get the index of the linked List to reference it from another function
     *
     * @param fElement Element that has to be found within the map
     * @return The pointer to table array that should contain the element or else a new element
     */
    int getList(KVPair fElement) {
        int hash = fElement.hashCode();
        int bucket = Math.abs(hash) % table.length;
        return bucket;
    }
}

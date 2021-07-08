package MapImplementation;

public interface Map<K extends Comparable <? super K>,V> {
    /**
     * Add a key value pair to the Map
     * @param key represents the associated identifier
     * @param value represents the actual element
     * @return null if K is not present , else the value if already present, update value
     * @throws NullPointerException if the Val is null
     */
    V put(K key,V value);

    /**
     * Get the value associated with the key
     * @param key represents the associated identifier
     * @return null if K is not present , else the value if already present, update value
     */
    V get (K key);

    /**
     * Remove a particular Key value pair
     * @param key represents the associated identifier
     * @return remove value
     */
    V remove(K key);

    /**
     * The total number of elements present in a set
     * @return the total number of elements.
     */
    int size();
}

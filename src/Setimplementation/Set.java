package Setimplementation;

public interface Set<T extends Comparable> {
    /**
     * Add a value to the set
     * @param value
     * @return true if added
     */
    boolean add(T value);

    /**
     * Remove a particular Element
     * @param value
     */
    void remove(T value);

    /**
     * @return The number of elements
     */
    int size();

    /**
     * Check if the
     * @param value
     * @return
     */
    boolean Contains(T value);

}

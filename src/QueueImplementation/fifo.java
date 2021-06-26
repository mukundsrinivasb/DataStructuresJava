package QueueImplementation;


public interface fifo<T> {
    /**
     * Add a value to the first in first out Data Structure
     * @param value to be added to the list
     * @return true if added else false
     */
    void add(T value);

    /**
     * Remove the first value in the Data structure
     * @return
     */
    boolean remove();

    /**
     * The numbers of elements in this dataStrutcture
     * @return
     */
    int size();
}

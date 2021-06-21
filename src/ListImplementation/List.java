package ListImplementation;


public interface List<T> {
    /**
     * Add files to the list
     */
    void add(T value);
    /**
     * Remove element ar this index
     * @param index
     */
    T remove(int index);

    /**
     * Get the element at index
     * @param index
     * @return return the index at this element
     */
    T get(int index);

    /**
     * get the size of the list
     * @return
     */
    int size();

    /**
     * Reverse the linkedList
     */
    void reverse();


}

package ListImplementation;

public class LinkedListTest<T> extends ListTest<T>{
    @Override
    public List<T> createList() {
        return new LinkedList<T>();
    }
}

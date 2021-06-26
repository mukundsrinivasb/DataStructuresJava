package ListImplementationTest;

import ListImplementation.LinkedList;
import ListImplementation.List;

class LinkedListTest<T> extends ListTest<T> {
    @Override
    public List<T> createList() {
        return new LinkedList<T>();
    }
}
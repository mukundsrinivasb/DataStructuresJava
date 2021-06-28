package Setimplementation;

public class BSTree<T extends Comparable>  implements Set<T>{
    @Override
    public boolean add(T value) {
        return false;
    }

    @Override
    public void remove(T value) {

    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean Contains(T value) {
        return false;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }
}

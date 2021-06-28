package SetimplementationTest;

import Setimplementation.BSTSet;

class TestBSTSet extends TestSet {

    @Override
    public <T extends Comparable<T>> BSTSet<T> createSet() {
        return new BSTSet<>();
    }
}
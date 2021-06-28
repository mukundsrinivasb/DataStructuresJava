package SetimplementationTest;

import Setimplementation.BSTree;

class TestBSTree extends TestSet {

    @Override
    public <T extends Comparable<T>> BSTree<T> createSet() {
        return new  BSTree<>();
    }
}
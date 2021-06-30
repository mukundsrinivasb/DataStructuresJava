package Setimplementation;

public class BSTSet<T extends Comparable> implements Set<T> {
    class BSTree {
        T value;
        BSTree left, right;

        BSTree(T val, BSTree l, BSTree r) {
            value = val;
            left = l;
            right = r;
        }

        void setNull() {
            this.left = this.right = null;
            this.value = null;
        }


        void addNodeRecursive(BSTree addTree, T addN) {
            BSTree newTree = new BSTree(addN, null, null);
            int compare = addN.compareTo(addTree.value);
            if (compare < 0) {
                if (addTree.left == null) {
                    addTree.left = newTree;
                } else {
                    addNodeRecursive(addTree.left, addN);
                }
            } else if (compare > 0) {
                if (addTree.right == null) {
                    addTree.right = newTree;
                } else {
                    addNodeRecursive(addTree.right, addN);
                }
            } else {
                throw new IllegalArgumentException("The node that is to be added cannot be in the tree");
            }
        }

        BSTree removeRecursive(BSTree tNode, T rVal) {
            BSTree retNode = tNode;
            int compare = rVal.compareTo(tNode.value);
            if (compare > 0) {
                if (tNode.right != null) {
                    return removeRecursive(tNode.right, rVal);
                } else {
                    throw new NullPointerException();
                }
            } else if (compare < 0) {
                if (tNode.left != null) {
                    return removeRecursive(tNode.left, rVal);
                } else {
                    throw new NullPointerException();
                }
            } else {
                tNode.setNull();
                addNodeRecursive(start,);
                return tNode;
            }
        }


    }

    BSTree start;
    public int size = 0;

    @Override
    public boolean add(T value) {
        BSTree newStart = new BSTree(value, null, null);
        try {
            if (start == null) {
                start = newStart;
            } else {
                start.addNodeRecursive(start, value);
            }
            size++;
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    @Override
    public void remove(T rVal) {
        try {
            start.removeRecursive(start, rVal);
            size--;
        } catch (NullPointerException e) {
            throw new NullPointerException();
        }
    }

    @Override
    public int size() {
        return size;
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

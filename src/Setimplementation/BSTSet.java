package Setimplementation;

public class BSTSet<T extends Comparable> implements Set<T> {


    class BSTree {
        T value;
        BSTree left, right;

        BSTree(T val) {
            value = val;
        }

        /**
         * Add a subtree to the appropriate node
         *
         * @param subtree which needs to be added
         * @return true if added false otherwise
         */

        boolean addTree(BSTree subtree) {
            int comp = subtree.value.compareTo(value);
            if (subtree == null)
                return false;
            if (comp > 0) {
                if (right != null)
                    return right.addTree(subtree);
                else {
                    right = subtree;
                    return true;
                }
            } else if (comp < 0) {
                if (left != null)
                    return left.addTree(subtree);
                else {
                    left = subtree;
                    return true;
                }

            } else
                return false;
        }


        /**
         * To find and remove a node from a tree
         *
         * @param element find the element
         * @param remove  true if the element has to be removed else false
         * @return the node
         */

        BSTree Find(BSTree element, boolean remove) {
            int comp = element.value.compareTo(value);
            if (comp == 0)
                return this;
            else {
                if (comp < 0) {
                    if (left != null) {
                        BSTree found = left.Find(element, remove);
                        if (found == left && remove)
                            left = null;
                        return found;
                    } else
                        return null;
                } else {
                    if (right != null) {
                        BSTree found = right.Find(element, remove);
                        if (found == right && remove)
                            right = null;
                        return found;
                    } else
                        return null;
                }
            }

        }
    }


    BSTree root;
    public int size = 0;

    @Override
    public boolean add(T value) {
        BSTree addEle = new BSTree(value);
        if (root == null) {
            root = addEle;
            size++;
            return true;
        } else {
            boolean added = root.addTree(addEle);
            if (added)
                size++;
            return added;
        }
    }

    @Override
    public void remove(T value) {
        BSTree ele = new BSTree(value);
        BSTree found = root.Find(ele, true);
        if (found == root)
            size--;
        if (found != null) {
            if (found.right != null) {
                root.addTree(found.right);
                size--;
            }
            if (found.left != null) {
                root.addTree(found.left);
                size--;

            }
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

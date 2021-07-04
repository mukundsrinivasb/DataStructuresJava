package Setimplementation;

import java.util.ArrayList;
import java.util.List;

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

        void addElements(List<T> elements) {
            if (left != null) {
                left.addElements(elements);
            }
            if (right != null) {
                right.addElements(elements);
            }
            elements.add(value);
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
        if (found != null) {
            if (found.equals(root)) {
                if (found.left != null) {
                    root = found.left;
                    root.addTree(found.right);
                } else if (found.right != null) {
                    root = found.right;
                } else {
                    root = null;
                }
            } else {
                if (found.left != null)
                    root.addTree(found.left);
                if (found.right != null)
                    root.addTree(found.right);

            }
            size--;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean Contains(T value) {
        BSTree findNode = new BSTree(value);
        if (root == null)
            return false;
        else return root.Find(findNode, false) != null;
    }

    @Override
    public Object[] toArray() {
        List<T> elements = new ArrayList<T>();
        if (root != null)
            root.addElements(elements);
        return elements.toArray();
    }
}
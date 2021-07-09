package ListImplementation;


public class LinkedList<T> implements List<T> {
    class LLNode {
        T value;
        LLNode next;

        public LLNode(T val, LLNode nextPtr) {
            value = val;
            next = nextPtr;
        }

        int sizeRecursive(LLNode n) {
            try {
                return 1 + sizeRecursive(n.next);
            } catch (NullPointerException e) {
                return 0;
            }
        }

        T getRecursive(int index) {
            if (index == 0) {
                return value;
            } else {
                if (next == null) {
                    throw new IndexOutOfBoundsException("The index does not exist");
                }
                return next.getRecursive(index - 1);
            }
        }

        T removeRecursive(int index) {

            if (index == 1) {
                T val = value;
                next = next.next;
                return val;
            } else {
                if (this.next == null) {
                    throw new IndexOutOfBoundsException("This is the last node");
                }
                return next.removeRecursive(index - 1);
            }
        }

        //Take in the node to be reversed, spit out the reversed node
        LLNode reverseRecursive(LLNode newNext) {
            LLNode oldNext = next;
            next = newNext;
            if (oldNext == null)
                return this;
            return oldNext.reverseRecursive(this);
        }
    }

    LLNode start;
    LLNode end;

    @Override
    public void add(T value) {
        LLNode nNode = new LLNode(value, null);
        if (start == null) {
            start = nNode;
            end = start;
        } else {
            end.next = nNode;
            end = end.next;
        }
    }

    @Override
    public T remove(int index) {
        if (start == null) {
            throw new NullPointerException("Cannot remove from an empty set");
        } else {
            if (index == 0) {
                T val = start.value;
                start = start.next;
                return val;
            }
            return start.removeRecursive(index);
        }
    }

    @Override
    public T get(int index) {
        if (start == null) {
            throw new IndexOutOfBoundsException("Empty list yields nothing");
        }
        return start.getRecursive(index);
    }

    @Override
    public int size() {
        try {
            return start.sizeRecursive(start);
        } catch (NullPointerException e) {
            return 0;
        }
    }

    @Override
    public void reverse() {
        if (start != null) {
            LLNode oldStart = start;
            start = start.reverseRecursive(null);
            end = oldStart;
        }
    }

    public boolean isEmpty() {
        return size() == 0;
    }
}

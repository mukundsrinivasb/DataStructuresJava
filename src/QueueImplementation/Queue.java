package QueueImplementation;


public class Queue<T> implements fifo<T> {
    QueueNode start;
    QueueNode end;

    class QueueNode {
        T value;
        QueueNode nextPtr;

        public QueueNode(T val, QueueNode nextP) {
            value = val;
            nextPtr = nextP;
        }

        int sizeRecursive(QueueNode n) {
            if (n == null)
                return 0;
            return 1 + sizeRecursive(n.nextPtr);
        }

        void moveUp(QueueNode n) {
            try {
                QueueNode nNxt = new QueueNode(n.nextPtr.value, n.nextPtr.nextPtr);
                if (n.nextPtr == end) {
                    end = nNxt;
                } else {
                    if (n == start) {
                        start = nNxt;
                        moveUp(n.nextPtr);
                    }
                    moveUp(n.nextPtr);
                }
            } catch (NullPointerException e) {
                System.out.println("Reached the end");
            }
        }

    }


    @Override
    public void add(T val) {
        QueueNode addNode = new QueueNode(val, null);
        if (start == null) {
            start = addNode;
            end = start;
        } else {
            end.nextPtr = addNode;
            end = end.nextPtr;
        }

    }

    @Override
    public boolean remove() {
        if (start == null) {
            return false;
        } else {
            if (start == end) {
                start = null;
                return true;
            }
            start.moveUp(start);
            return true;
        }
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
    public T get() {
        if (start != null) {
            return start.value;
        }
        throw new NullPointerException("There is nothing to get");
    }
}

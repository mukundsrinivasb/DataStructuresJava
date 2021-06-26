package QueueImplementation;

import ListImplementation.List;

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
            if (n == null) {
                return 0;
            } else {
                if (n.nextPtr == end) {
                    return 1;
                }
                return 1 + sizeRecursive(n.nextPtr);
            }

        }
    }

    @Override
    public void add(T val) {
        QueueNode nQ = new QueueNode(val, null);
        if (start == null) {
            start = nQ;
            end = start;
        }
        end = nQ;
        end.nextPtr = end;
    }

    @Override
    public boolean remove() {
        return false;
    }

    @Override
    public int size() {
        return start.sizeRecursive(start);
    }
}

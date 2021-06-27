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

        int sizeRecursive(QueueNode n){
           if(n==end)
               return 1;
           return 1+sizeRecursive(n.nextPtr);
        }
    }


    @Override
    public void add(T val) {
        QueueNode addNode = new QueueNode(val, null);
        if (start == null) {
            start = addNode;
            end = start;
        }
        end.nextPtr = addNode;
        end = end.nextPtr;

    }

    @Override
    public boolean remove() {
        return true;
    }

    @Override
    public int size() {
        try{
            return start.sizeRecursive(start);
        }catch (NullPointerException e){
            return 0;
        }
    }

    @Override
    public T get() {
        if(start != null) {
            return start.value;
        }
        throw new NullPointerException("There is nothing to get");
    }
}

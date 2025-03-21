public class ArrayBaseQueue {
    private Integer[] queue;
    private int front;
    private int rear;
    private final int capacity;
    private int size;

    public ArrayBaseQueue(int capacity){
        queue = new Integer[capacity];
        front = rear = -1;
        this.capacity = capacity;
        size = 0;
    }

    public boolean isEmpty(){
        return front == -1;
    }

    public Integer front() throws Exception {
        if (isEmpty()){
            throw new Exception("No Item Found!");
        }
        else {
            return queue[front];
        }
    }

    public void dequeue() throws Exception{
        if (isEmpty()){
            throw new Exception("Queue underflow!");
        }
        else {
            queue[front++] = null;
            size --;
        }
    }

    public void enqueue(Integer newItem) throws Exception {
        if (size == capacity){
            throw new Exception("Queue Overflow!");
        }
        else {
            queue[++rear] = newItem;
            size ++;
        }
    }
}

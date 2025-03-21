public class ArrayBaseCircularQueue {
    private Integer[] circularQueue;
    private int top;
    private int size;
    private final int capacity;

    public ArrayBaseCircularQueue(int capacity){
        circularQueue = new Integer[capacity];
        this.capacity = capacity;
        top = -1;
        size = 0;
    }

    public boolean isEmpty(){
        return top == -1;
    }

    public Integer top() throws Exception {
        if (isEmpty()){
            throw new Exception("No Item Found!");
        }
        else {
            return circularQueue[top];
        }
    }

    public void pop() throws Exception {
        if (isEmpty()){
            throw new Exception("Stack Underflow!");
        }
        else {
            circularQueue[top--] = null;
            size --;
        }
    }

    public void push(Integer newItem) throws Exception {
        if (size == capacity){
            throw new Exception("Stack Overflow!");
        }
        else {
            if (top == capacity - 1){
                top = -1;
                circularQueue[++top] = newItem;
                size ++;
            }
            circularQueue[++top] = newItem;
            size ++;
        }
    }
}

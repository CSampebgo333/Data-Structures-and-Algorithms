public class ArrayBaseStack {
    private Integer[] stack;
    private int size;
    private int top;
    private final int capacity;

    public ArrayBaseStack(int capacity){
        stack = new Integer[capacity];
        top = -1;
        this.capacity = capacity;
        size = 0;
    }

    public boolean isEmpty(){
        return top == -1;
    }

    public void pop() throws Exception{
        if (isEmpty()){
            throw new Exception("Stack underflow!");
        }
        else {
            stack[top--] = null;
            size --;
        }
    }

    public Integer top() throws Exception{
        if (isEmpty()){
            throw new Exception("No Item Found!");
        }
        else {
            return stack[top];
        }
    }

    public void push(Integer item) throws Exception {
        if (size == capacity){
            throw new Exception("Stack Overflow!");
        }
        else {
            stack[++top] = item;
            size += 1;
        }
    }
}

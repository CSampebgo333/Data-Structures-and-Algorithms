public class Node {
    private int value;
    public Node next;

    public Node(int value){
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value = " + value +
                ", next = " + next +
                '}';
    }
}

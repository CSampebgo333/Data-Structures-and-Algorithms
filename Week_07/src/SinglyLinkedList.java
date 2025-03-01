public class SinglyLinkedList {
    private Node head;
    private int size;

    public SinglyLinkedList(){
        this.head = null;
        size = 0;
    }

    public void addNode(int value){
        Node newNode = new Node(value);
        if (size == 0){
            head = newNode;
        }
        else {
            Node iH = head;
            while(iH != null){

            }
        }
    }


}

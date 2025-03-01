public class BrowserHistory {
    private HistoryNode head;
    private HistoryNode tail;
    private int size;

    //  initialize the doubly linked list with head and tail set to null.
    public BrowserHistory(){
        this.head = null;
        this.tail = null;
        size = 0;
    }

    // Add a new page to the end of the history.
    public void addPage(String url, String timestamp){
        HistoryNode newNode = new HistoryNode(url, timestamp);
        if(head == null){
            head = newNode;
            tail = head;
            size += 1;
        }
        else{
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
            size += 1;
        }
    }


    public void removePage(String timestamp){
        if(head == null){
            System.out.println("ZERO ELEMENT ERROR!");
        }
        else{
            HistoryNode currentNode = head;
            while(currentNode != null){
                if (currentNode.timestamp.equals(timestamp)){
                    if (currentNode == head){
                        head = currentNode.next;
                    } else if (currentNode == tail) {
                        tail = currentNode.prev;
                        tail.next = null;
                    }
                    else {
                        HistoryNode previousProxy = currentNode.prev;
                        HistoryNode nextProxy = currentNode.next;
                        previousProxy.next = nextProxy;
                        nextProxy.prev = previousProxy;
                    }
                    size -= 1;
                }
                currentNode = currentNode.next;

            }
        }
    }

    public void displayHistoryForward(){
        HistoryNode currentNode = head;
        while(currentNode != null){
            System.out.println(currentNode);
            currentNode = currentNode.next;
        }
    }

    public void displayHistoryBackward(){
        HistoryNode currentNode = tail;
        while(currentNode != null){
            System.out.println(currentNode);
            currentNode = currentNode.prev;
        }
    }

    public int getSize(){
        return this.size;
    }
}

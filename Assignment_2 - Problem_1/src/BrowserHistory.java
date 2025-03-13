public class BrowserHistory {
    private HistoryNode head;
    private HistoryNode tail;
    private int size;

    /**
     * Initialization of an empty browser history using a doubly linked list.
     * The head and tail are set to null, and the size is initialized to zero.
     */
    public BrowserHistory() {
        this.head = null;
        this.tail = null;
        size = 0;
    }

    /**
     * Adds a new page to the end of the browser history.
     *
     * @param 'url' the URL of the visited page
     * @param 'timestamp' the time of the visit
     */
    public void addPage(String url, String timestamp) {
        HistoryNode newNode = new HistoryNode(url, timestamp);
        if (head == null) {
            head = newNode;
            tail = head;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size += 1;
    }

    /**
     * Removes a page from the history based on its timestamp.
     * If the history is empty, an error message is displayed.
     *
     * @param 'timestamp' the timestamp of the page to be removed
     */
    public void removePage(String timestamp) {
        if (head == null) {
            System.out.println("ZERO ELEMENT ERROR!");
        } else {
            HistoryNode currentNode = head;
            while (currentNode != null) {
                if (currentNode.timestamp.equals(timestamp)) {
                    if (currentNode == head) {
                        head = currentNode.next;
                    } else if (currentNode == tail) {
                        tail = currentNode.prev;
                        if (tail != null) {
                            tail.next = null;
                        }
                    } else {
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

    /**
     * Displays the browsing history from the oldest to the most recent.
     */
    public void displayHistoryForward() {
        HistoryNode currentNode = head;
        while (currentNode != null) {
            System.out.println(currentNode);
            currentNode = currentNode.next;
        }
    }

    /**
     * Displays the browsing history from the most recent to the oldest.
     */
    public void displayHistoryBackward() {
        HistoryNode currentNode = tail;
        while (currentNode != null) {
            System.out.println(currentNode);
            currentNode = currentNode.prev;
        }
    }

    /**
     * This method returns the total number of pages stored in the history.
     *
     * @return the size of the history
     */
    public int getSize() {
        return this.size;
    }
}
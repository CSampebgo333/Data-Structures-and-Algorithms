public class HistoryNode {

    // Creation of the instances of the HistoryNode class
    public String url;
    public String timestamp;
    public HistoryNode prev = null;
    public HistoryNode next = null;

    /**
     * Constructs a HistoryNode with a given URL and timestamp.
     *
     * @param 'url' the URL visited
     * @param 'timestamp' the time of the visit
     */
    public HistoryNode(String url, String timestamp) {
        this.url = url;
        this.timestamp = timestamp;
    }

    /**
     * Returns a string representation of the HistoryNode.
     *
     * @return a formatted string containing the URL and timestamp
     */
    @Override
    public String toString() {
        return "Node{" +
                "url = '" + url + '\'' +
                ", timestamp = '" + timestamp + '\'' +
                '}';
    }
}
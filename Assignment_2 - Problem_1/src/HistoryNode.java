public class HistoryNode {

    // Creation of the instances of the HistoryNode class
    public String url;
    public String timestamp;
    public HistoryNode prev = null;
    public HistoryNode next = null;

    public HistoryNode(String url, String timestamp){
        this.url = url;
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Node{" +
                "url = '" + url + '\'' +
                ", timestamp = '" + timestamp + '\'' +
                '}';
    }
}

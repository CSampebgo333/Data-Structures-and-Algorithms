public class FullyFunctionalPlaylist {
    private Song head;
    private Song tail;
    private int size;

    public FullyFunctionalPlaylist(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void addAtEnd(Song song){
        if (size == 0){
            this.head = song;
            this.tail = head;
            size += 1;
        }
        else {
            this.tail.next = song;
            song.prev = tail;
            song.next = head;
            size += 1;
        }
    }

}

public class BasicPlaylist {
    private Song head;
    private Song tail;
    private int size;

    public BasicPlaylist(){
        this.head = null;
        this.tail = null;
        size = 0;
    }

    public void displayPlayList(){
        if(size == 0){
            System.out.println("No Song Found!");
        }
        else {
            Song currentSong = head;
            while (currentSong != null){
                System.out.print(currentSong);
                currentSong = currentSong.next;
            }
        }
    }

    public void addAtEnd(Song song){
        if (size == 0){
            this.head = song;
            this.tail = song;
            size += 1;
        }
        else {
            this.tail.next = song;
            size += 1;
        }
    }

    public void addAtPosition(Song song, int position){
        if (position <= 0 || position > size){
            System.out.println("Invalid position!");
        } else if (position == 1) {
            song.next = head;
            head = song;
            size += 1;
        }
        else {
            int count = 1;
            Song currentSong = head;
            while(currentSong.next != null){
                if (count + 1 == position){
                    song.next = currentSong.next;
                    currentSong.next = song;
                    size += 1;
                }
                currentSong = currentSong.next;
                count += 1;
            }
        }
    }

    public void removeSong(String title){
        if (size == 0){
            System.out.println("No Song To remove!");
        } else if (size == 1){
            if(head.getTitle().equals(title)){
                head = null;
                tail = null;
                size -= 1;
            }
        } else if (title.equals(head.getTitle())){
            head = head.next;
        }
        else {
            Song currentSong = head;
            Song previousSong = currentSong;
            while (currentSong != null){
                if (title.equals(currentSong.getTitle())){
                    previousSong.next = currentSong.next;
                    size -= 1;
                }
                previousSong = currentSong;
                currentSong = currentSong.next;
            }
        }
    }

    public void removeSong(int pos){
        if (size == 0){
            System.out.println("No Song To Remove");
        }
        else {
            int count = 1;
            Song currentSong = head;
            Song previousSong = currentSong;
            while (currentSong != null){
                if (count == pos){
                    previousSong.next = currentSong.next;
                    size -= 1;
                }
                previousSong = currentSong;
                currentSong = currentSong.next;
                count += 1;
            }
        }
    }

    public double calculateTotalDuration(){
        Song currentSong = head;
        double totalDuration = 0;

        if (size == 0){
            return 0;
        }
        else {
            while (currentSong != null){
                totalDuration += currentSong.getDuration();
                currentSong = currentSong.next;
            }
            return totalDuration;
        }
    }
}

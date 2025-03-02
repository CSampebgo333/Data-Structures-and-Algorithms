import jdk.jshell.Snippet;

public class EnhancedPlaylist {
    private Song head;
    private Song tail;
    private int size;

    public EnhancedPlaylist(){
        this.head = null;
        this.tail = null;
    }

    public void addAtEnd(Song song){
        if (size == 0){
            this.head = song;
            this.tail = song;
            size += 1;
        }
        else{
            this.tail.next = song;
            this.tail = song;
            size += 1;
        }
    }

    public double calculateTotalDuration(){
        if (size == 0){
            return 0;
        }
        else{
            double totalDuration = 0;
            Song currentSong = head;
            while (currentSong != null){
                totalDuration += currentSong.getDuration();
                currentSong = currentSong.next;
            }
            return totalDuration;
        }
    }

    public void addAtPosition(Song song, int position){
        if (position <= 0 || position > size){
            System.out.println("Invalid Position!");
        }
        else {
            Song currentSong = head;
            Song previousSong = currentSong;
            int count = 1;
            while (currentSong != null){
                if (count == position){
                    song.next = currentSong;
                    currentSong.prev = song;
                    previousSong.next = song;
                    song.prev = previousSong;
                    size += 1;
                }
                previousSong = currentSong;
                currentSong = currentSong.next;
                count += 1;
            }
        }
    }

    public void removeSong(String title){
        if (size == 0){
            System.out.println("No Song Found!");
        }
        else {
            Song currentSong = head;
            Song previousSong = currentSong;
            Song nextSong = currentSong;
            while(currentSong != null){
                nextSong = currentSong.next;
                if(title.equals(currentSong.getTitle())){
                    previousSong.next = nextSong;
                    nextSong.prev = previousSong;
                    size -= 1;
                }
                previousSong = currentSong;
                currentSong = currentSong.next;
            }
        }
    }

    public void removeSong(int position){
        if (size == 0){
            System.out.println("No Song Found!");
        }
        else {
            int count = 1;
            Song currentSong = head;
            Song previousSong = currentSong;
            Song nextSong = currentSong;
            while (currentSong != null){
                if (count == position){
                    nextSong = currentSong.next;
                    previousSong.next = nextSong;
                    nextSong.prev = previousSong;
                    size -= 1;
                }
                count += 1;
                previousSong = currentSong;
                currentSong = currentSong.next;
            }
        }
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

    //DEBUGGING RESOURCES: System.out.println("Condition Reached: YES" + " Position=" + position + " SIZE=" + this.size);


}

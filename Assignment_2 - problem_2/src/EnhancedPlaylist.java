import jdk.jshell.Snippet;

import java.util.*;

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
            song.prev = tail;
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
        if (position <= 0 || position > this.size){
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
                    this.size += 1;
                }
                previousSong = currentSong;
                currentSong = currentSong.next;
                count += 1;
            }
        }
    }

    public void removeSong(String title){
        if (this.size == 0){
            System.out.println("No Song Found!");
        }
        else {
            Song currentSong = head;
            Song previousSong = currentSong;
            while(currentSong != null){
                Song nextSong = currentSong.next;
                if(title.equals(currentSong.getTitle())){
                    previousSong.next = nextSong;
                    nextSong.prev = previousSong;
                    this.size -= 1;
                }
                previousSong = currentSong;
                currentSong = currentSong.next;
            }
        }
    }

    public void removeSong(int position){
        if (this.size == 0){
            System.out.println("No Song Found!");
        }
        else {
            int count = 1;
            Song currentSong = head;
            Song previousSong = currentSong;
            while (currentSong != null){
                if (count == position){
                    Song nextSong = currentSong.next;
                    previousSong.next = nextSong;
                    nextSong.prev = previousSong;
                    this.size -= 1;
                }
                count += 1;
                previousSong = currentSong;
                currentSong = currentSong.next;
            }
        }
    }

    public void displayPlayList(){
        if(this.size == 0){
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

    public void playNextSong(String title){
        Song currentSong = head;
        while (currentSong != null){
            if (currentSong.getTitle().equals(title)){
                System.out.println("Playing: '" + currentSong.next.getTitle() + "' by '" + currentSong.next.getArtist() + "'");
            }
            currentSong = currentSong.next;
        }
    }

    public void playPreviousSong(String title){
        Song currentSong = head;
        while (currentSong != null){
            if (currentSong.getTitle().equals(title)){
                System.out.println("Playing: '" + currentSong.prev.getTitle() + "' by '" + currentSong.prev.getArtist() + "'");
            }
            currentSong = currentSong.next;
        }
    }

    public void shufflePlayList(){
        ArrayList<Song> songs = new ArrayList<>();
        Song currentSong = this.head;
        while(currentSong != null){
            songs.add(currentSong);
            currentSong = currentSong.next;
        }
        Collections.shuffle(songs, new Random());

        this.head = songs.get(0);
        Song current = this.head;
        for (int i = 1; i < songs.size(); i++){
            current.next = songs.get(i);
            current = current.next;
        }
        current.next = null;
    }

    //DEBUGGING RESOURCES: System.out.println("Condition Reached: YES" + " Position=" + position + " SIZE=" + this.size);
}

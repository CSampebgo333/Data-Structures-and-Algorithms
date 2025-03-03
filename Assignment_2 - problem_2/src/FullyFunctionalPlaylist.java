import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class FullyFunctionalPlaylist {
    private Song head;
    private Song tail;
    private int size;

    public FullyFunctionalPlaylist() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public double calculateTotalDuration() {
        if (size == 0) {
            return 0;
        }
        double totalDuration = 0;
        Song currentSong = head;
        do {
            totalDuration += currentSong.getDuration();
            currentSong = currentSong.next;
        } while (currentSong != head);
        return totalDuration;
    }

    public void displayPlayList() {
        if (this.size == 0) {
            System.out.println("No Song Found!");
            return;
        }
        Song currentSong = head;
        do {
            System.out.print(currentSong);
            currentSong = currentSong.next;
        } while (currentSong != head);
    }

    public void addAtEnd(Song song) {
        if (size == 0) {
            this.head = song;
            this.tail = song;
            head.next = head;
            head.prev = head;
        } else {
            song.next = head;
            song.prev = tail;
            tail.next = song;
            head.prev = song;
            tail = song;
        }
        size += 1;
    }

    public void addAtPosition(Song song, int position) {
        if (position <= 0 || position > size + 1) {
            System.out.println("Invalid Position!");
            return;
        }
        if (position == 1) {
            song.next = head;
            song.prev = tail;
            tail.next = song;
            head.prev = song;
            head = song;
        } else {
            Song currentSong = head;
            for (int count = 1; count < position - 1; count++) {
                currentSong = currentSong.next;
            }
            song.next = currentSong.next;
            song.prev = currentSong;
            currentSong.next.prev = song;
            currentSong.next = song;
        }
        size += 1;
    }

    public void removeSong(String title) {
        if (size == 0) {
            System.out.println("No song found!");
            return;
        }
        Song currentSong = head;
        do {
            if (title.equals(currentSong.getTitle())) {
                if (size == 1) {
                    head = null;
                    tail = null;
                } else {
                    currentSong.prev.next = currentSong.next;
                    currentSong.next.prev = currentSong.prev;
                    if (currentSong == head) {
                        head = currentSong.next;
                    }
                    if (currentSong == tail) {
                        tail = currentSong.prev;
                    }
                }
                size -= 1;
                break;
            }
            currentSong = currentSong.next;
        } while (currentSong != head);
    }

    public void removeSong(int position) {
        if (size == 0) {
            System.out.println("No Song Found!");
            return;
        }
        if (position <= 0 || position > size) {
            System.out.println("Invalid position!");
            return;
        }
        Song currentSong = head;
        if (position == 1) {
            if (size == 1) {
                head = null;
                tail = null;
            } else {
                tail.next = head.next;
                head.next.prev = tail;
                head = head.next;
            }
        } else {
            for (int count = 1; count < position; count++) {
                currentSong = currentSong.next;
            }
            currentSong.prev.next = currentSong.next;
            currentSong.next.prev = currentSong.prev;
            if (currentSong == tail) {
                tail = currentSong.prev;
            }
        }
        size -= 1;
    }

    public void continuousPlay(String title) {
        if (size == 0) {
            System.out.println("No songs available.");
            return;
        }
        Song currentSong = head;
        do {
            if (currentSong.getTitle().equals(title)) {
                System.out.println("Playing: '" + currentSong.getTitle() + "' by '" + currentSong.getArtist() + "'");
                System.out.println("Next Song in the Playlist: '" + currentSong.next.getTitle() + "' by '" + currentSong.next.getArtist() + "'");
                return;
            }
            currentSong = currentSong.next;
        } while (currentSong != head);
        System.out.println("Song not found in playlist.");
    }

    public void shufflePlayList() {
        if (size < 2) {
            return;
        }
        ArrayList<Song> songs = new ArrayList<>();
        Song currentSong = this.head;
        do {
            songs.add(currentSong);
            currentSong = currentSong.next;
        } while (currentSong != head);

        Collections.shuffle(songs, new Random());

        this.head = songs.get(0);
        Song current = this.head;
        for (int i = 1; i < songs.size(); i++) {
            current.next = songs.get(i);
            songs.get(i).prev = current;
            current = current.next;
        }
        current.next = this.head;
        this.head.prev = current;
        this.tail = current;
    }
}
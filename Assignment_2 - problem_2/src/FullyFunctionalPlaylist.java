import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class FullyFunctionalPlaylist {
    private Song head;
    private Song tail;
    private int size;
    private boolean isContinuousPlayEnabled; // Flag for continuous play

    public FullyFunctionalPlaylist() {
        this.head = null;
        this.tail = null;
        this.size = 0;
        this.isContinuousPlayEnabled = false; // Default: Normal play mode
    }

    /**
     * Toggles the continuous play mode of the playlist.
     */
    public void toggleContinuousPlay() {
        isContinuousPlayEnabled = !isContinuousPlayEnabled;
        System.out.println("Continuous Play: " + (isContinuousPlayEnabled ? "Enabled" : "Disabled"));
    }

    /**
     * Calculates the total duration of all songs in the playlist.
     * @return total duration of the playlist
     */
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

    /**
     * Displays all songs in the playlist.
     */
    public void displayPlayList() {
        if (this.size == 0) {
            System.out.println("No Song Found!");
        }
        Song currentSong = head;
        do {
            System.out.print(currentSong);
            currentSong = currentSong.next;
        } while (currentSong != head);
    }

    /**
     * Adds a song to the end of the playlist.
     * @param song the song to be added
     */
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
        size++;
    }

    /**
     * Adds a song at a specific position in the playlist.
     * @param song the song to be added
     * @param position the position to insert the song at
     */
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
        size++;
    }

    /**
     * Removes a song from the playlist by title.
     * @param title the title of the song to be removed
     */
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
                size--;
                return;
            }
            currentSong = currentSong.next;
        } while (currentSong != head);
    }

    /**
     * Removes a song from the playlist by position.
     * @param position the position of the song to be removed
     */
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
        size--;
    }

    /**
     * Plays a song based on its title.
     * @param title the title of the song to play
     */
    public void playSong(String title) {
        if (size == 0) {
            System.out.println("No songs available.");
            return;
        }
        Song currentSong = head;
        do {
            if (currentSong.getTitle().equals(title)) {
                System.out.println("Playing: '" + currentSong.getTitle() + "' by '" + currentSong.getArtist() + "'");
                if (isContinuousPlayEnabled) {
                    System.out.println("Next: '" + currentSong.next.getTitle() + "' by '" + currentSong.next.getArtist() + "'");
                }
                return;
            }
            currentSong = currentSong.next;
        } while (currentSong != head);
        System.out.println("Song not found in playlist.");
    }

    /**
     * Shuffles the playlist to randomize song order.
     */
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
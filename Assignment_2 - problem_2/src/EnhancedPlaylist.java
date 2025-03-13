import java.util.*;

public class EnhancedPlaylist {
    private Song head;
    private Song tail;
    private int size;

    /**
     * Initializes an empty playlist.
     */
    public EnhancedPlaylist() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    /**
     * Adds a song to the end of the playlist.
     * @param song the song to be added
     */
    public void addAtEnd(Song song) {
        if (size == 0) {
            this.head = song;
            this.tail = song;
        } else {
            this.tail.next = song;
            song.prev = tail;
            this.tail = song;
        }
        size++;
    }

    /**
     * Calculates the total duration of all songs in the playlist.
     * @return the total duration of the playlist
     */
    public double calculateTotalDuration() {
        double totalDuration = 0;
        Song currentSong = head;
        while (currentSong != null) {
            totalDuration += currentSong.getDuration();
            currentSong = currentSong.next;
        }
        return totalDuration;
    }

    /**
     * Adds a song at a specific position in the playlist.
     * @param song     the song to be added
     * @param position the position at which to insert the song
     */
    public void addAtPosition(Song song, int position) {
        if (position <= 0 || position > size) {
            System.out.println("Invalid Position!");
            return;
        }
        if (position == 1) {
            song.next = head;
            head.prev = song;
            head = song;
        } else {
            Song currentSong = head;
            for (int i = 1; i < position - 1; i++) {
                currentSong = currentSong.next;
            }
            song.next = currentSong.next;
            if (currentSong.next != null) {
                currentSong.next.prev = song;
            }
            currentSong.next = song;
            song.prev = currentSong;
        }
        size++;
    }

    /**
     * Removes a song from the playlist based on its title.
     * @param title the title of the song to be removed
     */
    public void removeSong(String title) {
        if (size == 0) {
            System.out.println("No Song Found!");
            return;
        }
        Song currentSong = head;
        while (currentSong != null) {
            if (title.equals(currentSong.getTitle())) {
                if (currentSong == head) {
                    head = currentSong.next;
                } else {
                    currentSong.prev.next = currentSong.next;
                }
                if (currentSong == tail) {
                    tail = currentSong.prev;
                } else {
                    currentSong.next.prev = currentSong.prev;
                }
                size--;
                return;
            }
            currentSong = currentSong.next;
        }
    }

    /**
     * Removes a song from the playlist based on its position.
     * @param position the position of the song to be removed
     */
    public void removeSong(int position) {
        if (size == 0 || position <= 0 || position > size) {
            System.out.println("Invalid Position!");
            return;
        }
        Song currentSong = head;
        for (int i = 1; i < position; i++) {
            currentSong = currentSong.next;
        }
        if (currentSong == head) {
            head = currentSong.next;
        } else {
            currentSong.prev.next = currentSong.next;
        }
        if (currentSong == tail) {
            tail = currentSong.prev;
        } else {
            currentSong.next.prev = currentSong.prev;
        }
        size--;
    }

    /**
     * Displays all songs in the playlist.
     */
    public void displayPlayList() {
        if (size == 0) {
            System.out.println("No Song Found!");
            return;
        }
        Song currentSong = head;
        while (currentSong != null) {
            System.out.print(currentSong);
            currentSong = currentSong.next;
        }
    }

    /**
     * Plays the next song after the given song title.
     * @param title the title of the current song
     */
    public void playNextSong(String title) {
        Song currentSong = head;
        while (currentSong != null) {
            if (currentSong.getTitle().equals(title) && currentSong.next != null) {
                System.out.println("Playing: '" + currentSong.next.getTitle() + "' by '" + currentSong.next.getArtist() + "'");
                return;
            }
            currentSong = currentSong.next;
        }
        System.out.println("No next song found!");
    }

    /**
     * Plays the previous song before the given song title.
     *
     * @param title the title of the current song
     */
    public void playPreviousSong(String title) {
        Song currentSong = head;
        while (currentSong != null) {
            if (currentSong.getTitle().equals(title) && currentSong.prev != null) {
                System.out.println("Playing: '" + currentSong.prev.getTitle() + "' by '" + currentSong.prev.getArtist() + "'");
                return;
            }
            currentSong = currentSong.next;
        }
        System.out.println("No previous song found!");
    }

    /**
     * Shuffles the playlist randomly.
     */
    public void shufflePlayList() {
        if (size <= 1) return;
        List<Song> songs = new ArrayList<>();
        Song currentSong = head;
        while (currentSong != null) {
            songs.add(currentSong);
            currentSong = currentSong.next;
        }
        Collections.shuffle(songs, new Random());
        this.head = songs.get(0);
        Song current = this.head;
        for (int i = 1; i < songs.size(); i++) {
            current.next = songs.get(i);
            songs.get(i).prev = current;
            current = current.next;
        }
        this.tail = current;
        this.tail.next = null;
    }
}
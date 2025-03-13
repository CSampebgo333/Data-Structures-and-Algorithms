public class BasicPlaylist {
    private Song head;
    private Song tail;
    private int size;

    /**
     * Initialization of an empty playlist.
     * The head and tail are set to null, and the size is initialized to zero.
     */
    public BasicPlaylist() {
        this.head = null;
        this.tail = null;
        size = 0;
    }

    /**
     * Displays all songs in the playlist.
     * If the playlist is empty, it prints a message.
     */
    public void displayPlayList() {
        if (size == 0) {
            System.out.println("No Song Found!");
        } else {
            Song currentSong = head;
            while (currentSong != null) {
                System.out.print(currentSong);
                currentSong = currentSong.next;
            }
        }
    }

    /**
     * Adds a song to the end of the playlist.
     *
     * @param song the song to be added
     */
    public void addAtEnd(Song song) {
        if (size == 0) {
            this.head = song;
            this.tail = song;
        } else {
            this.tail.next = song;
        }
        size += 1;
    }

    /**
     * Adds a song at a specific position in the playlist.
     * If the position is invalid, it prints an error message.
     *
     * @param song the song to be added
     * @param position the position at which to insert the song
     */
    public void addAtPosition(Song song, int position) {
        if (position <= 0 || position > size) {
            System.out.println("Invalid position!");
        } else if (position == 1) {
            song.next = head;
            head = song;
            size += 1;
        } else {
            int count = 1;
            Song currentSong = head;
            while (currentSong.next != null) {
                if (count + 1 == position) {
                    song.next = currentSong.next;
                    currentSong.next = song;
                    size += 1;
                }
                currentSong = currentSong.next;
                count += 1;
            }
        }
    }

    /**
     * Removes a song from the playlist based on its title.
     * If the song is not found, nothing happens.
     * @param title the title of the song to be removed
     */
    public void removeSong(String title) {
        if (size == 0) {
            System.out.println("No Song To Remove!");
        } else if (size == 1) {
            if (head.getTitle().equals(title)) {
                head = null;
                tail = null;
                size -= 1;
            }
        } else if (title.equals(head.getTitle())) {
            head = head.next;
        } else {
            Song currentSong = head;
            Song previousSong = currentSong;
            while (currentSong != null) {
                if (title.equals(currentSong.getTitle())) {
                    previousSong.next = currentSong.next;
                    size -= 1;
                }
                previousSong = currentSong;
                currentSong = currentSong.next;
            }
        }
    }

    /**
     * Removes a song from the playlist based on its position.
     * If the position is invalid, nothing happens.
     *
     * @param pos the position of the song to be removed
     */
    public void removeSong(int pos) {
        if (size == 0) {
            System.out.println("No Song To Remove!");
        } else {
            int count = 1;
            Song currentSong = head;
            Song previousSong = currentSong;
            while (currentSong != null) {
                if (count == pos) {
                    previousSong.next = currentSong.next;
                    size -= 1;
                }
                previousSong = currentSong;
                currentSong = currentSong.next;
                count += 1;
            }
        }
    }

    /**
     * Calculates the total duration of all songs in the playlist.
     * @return the total duration of the playlist
     */
    public double calculateTotalDuration() {
        Song currentSong = head;
        double totalDuration = 0;

        if (size == 0) {
            return 0;
        } else {
            while (currentSong != null) {
                totalDuration += currentSong.getDuration();
                currentSong = currentSong.next;
            }
            return totalDuration;
        }
    }
}
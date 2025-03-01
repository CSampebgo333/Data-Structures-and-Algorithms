public class BasicDriver {
    public static void main(String[] args){

        // INSTANTIATE A REGGAE PLAYLIST
        BasicPlaylist ReggaePlayList = new BasicPlaylist();

        System.out.println("\n======================================");
        // ADD AT THE END OF THE PLAYLIST (Initially Empty)
        System.out.println("-- Adding 'One Love' to an empty playlist --");
        ReggaePlayList.addAtEnd(new Song("One Love", "Bob Marley", 3.00));
        ReggaePlayList.displayPlayList();
        // Calculate duration after removal
        System.out.println("\n Total Playlist Duration: " + ReggaePlayList.calculateTotalDuration() + " minutes");

        System.out.println("\n======================================");
        // ADD AT THE END OF A NON-EMPTY PLAYLIST
        System.out.println("-- Adding 'Sweat' to the playlist --");
        ReggaePlayList.addAtEnd(new Song("Sweat (A La La La La Long)", "Inner Circle", 3.46));
        ReggaePlayList.displayPlayList();
        // Calculate duration after removal
        System.out.println("\n Total Playlist Duration: " + ReggaePlayList.calculateTotalDuration() + " minutes");

        System.out.println("\n======================================");
        // ADD AT A SPECIFIC POSITION (Position 2)
        System.out.println("-- Adding 'Bad Boys' at position 2 --");
        ReggaePlayList.addAtPosition(new Song("Bad Boys", "Inner Circle", 3.55), 2);
        ReggaePlayList.displayPlayList();
        // Calculate duration after removal
        System.out.println("\n Total Playlist Duration: " + ReggaePlayList.calculateTotalDuration() + " minutes");

        System.out.println("\n======================================");
        // ADD AT POSITION 1 - "No Woman, No Cry"
        System.out.println("-- Adding 'No Woman, No Cry' at position 1 --");
        ReggaePlayList.addAtPosition(new Song("No Woman, No Cry", "Bob Marley", 4.06), 3);
        ReggaePlayList.displayPlayList();
        // Calculate duration after removal
        System.out.println("\n Total Playlist Duration: " + ReggaePlayList.calculateTotalDuration() + " minutes");

        System.out.println("\n======================================");
        // REMOVE A SONG BY TITLE ('Bad Boys')
        System.out.println("-- Removing 'Bad Boys' by title --");
        ReggaePlayList.removeSong("Bad Boys");
        ReggaePlayList.displayPlayList();
        // Calculate duration after removal
        System.out.println("\n Total Playlist Duration: " + ReggaePlayList.calculateTotalDuration() + " minutes");

        // REMOVE A SONG BY POSITION (Position 2)
        System.out.println("\n======================================");
        System.out.println("-- Removing song at position 3 (Sweat) --");
        ReggaePlayList.removeSong(3);
        ReggaePlayList.displayPlayList();
        // Calculate duration after removal
        System.out.println("\n Total Playlist Duration: " + ReggaePlayList.calculateTotalDuration() + " minutes");

    }
}
public class EnhancedDriver {
    public static void main(String [] args){

        // INSTANTIATE A ZOUGLOU PLAYLIST: -> Note: Zouglou is a type of music from Côte d'Ivoire.
        EnhancedPlaylist ZouglouPlayList = new EnhancedPlaylist();

        System.out.println("\n======================================");
        // ADD AT THE END OF THE PLAYLIST (Initially Empty)
        System.out.println("-- Adding 'Abidjan est risqué' by Yodé & Siro --");
        ZouglouPlayList.addAtEnd(new Song("Abidjan est risqué", "Yodé & Siro", 4.15));
        ZouglouPlayList.displayPlayList();
        // Calculate duration
        System.out.println("\n Total Playlist Duration: " + ZouglouPlayList.calculateTotalDuration() + " minutes");

        System.out.println("\n======================================");
        // ADD AT THE END OF A NON-EMPTY PLAYLIST
        System.out.println("-- Adding 'Gbêtô' by Magic System --");
        ZouglouPlayList.addAtEnd(new Song("Gbêtô", "Magic System", 3.58));
        ZouglouPlayList.displayPlayList();
        // Calculate duration
        System.out.println("\n Total Playlist Duration: " + ZouglouPlayList.calculateTotalDuration() + " minutes");

        System.out.println("\n======================================");
        // ADD AT A SPECIFIC POSITION (Position 2)
        System.out.println("-- Adding 'Allons à Gagnoa' by Espoir 2000 at position 2 --");
        ZouglouPlayList.addAtPosition(new Song("Allons à Gagnoa", "Espoir 2000", 4.20), 2);
        ZouglouPlayList.displayPlayList();
        // Calculate duration
        System.out.println("\n Total Playlist Duration: " + ZouglouPlayList.calculateTotalDuration() + " minutes");

        System.out.println("\n======================================");
        // ADD AT POSITION 3 - "Zizigui" by Les Patrons
        System.out.println("-- Adding 'Zizigui' by Les Patrons at position 3 --");
        ZouglouPlayList.addAtPosition(new Song("Zizigui", "Les Patrons", 4.10), 3);
        ZouglouPlayList.displayPlayList();
        // Calculate duration
        System.out.println("\n Total Playlist Duration: " + ZouglouPlayList.calculateTotalDuration() + " minutes");

        System.out.println("\n======================================");
        // REMOVE A SONG BY TITLE ('Allons à Gagnoa')
        System.out.println("-- Removing 'Allons à Gagnoa' by title --");
        ZouglouPlayList.removeSong("Allons à Gagnoa");
        ZouglouPlayList.displayPlayList();
        // Calculate duration
        System.out.println("\n Total Playlist Duration: " + 	ZouglouPlayList.calculateTotalDuration() + " minutes");

        System.out.println("\n======================================");
        // REMOVE A SONG BY POSITION (Position 3)
        System.out.println("-- Removing song at position 3 (Gbêtô) --");
        ZouglouPlayList.removeSong(2);
        ZouglouPlayList.displayPlayList();
        // Calculate duration
        System.out.println("\n Total Playlist Duration: " + 	ZouglouPlayList.calculateTotalDuration() + " minutes");
    }
}

public class FullyFunctionalPlaylistDriver {
    public static void main(String[] args) {

        // INSTANTIATE A BURKINABÈ PLAYLIST
        FullyFunctionalPlaylist BurkinabePlayList = new FullyFunctionalPlaylist();

        System.out.println("\n======================================");
        // ADD AT THE END OF THE PLAYLIST (Initially Empty)
        System.out.println("-- Adding 'Wend Mi' by Floby --");
        BurkinabePlayList.addAtEnd(new Song("Wend Mi", "Floby", 4.15));
        BurkinabePlayList.displayPlayList();
        System.out.println("\nTotal Playlist Duration: " + BurkinabePlayList.calculateTotalDuration() + " minutes");

        System.out.println("\n======================================");
        // ADD AT THE END OF A NON-EMPTY PLAYLIST
        System.out.println("-- Adding 'Le chapeau du chef' by Smarty --");
        BurkinabePlayList.addAtEnd(new Song("Le chapeau du chef", "Smarty", 3.58));
        BurkinabePlayList.displayPlayList();
        System.out.println("\n Total Playlist Duration: " + BurkinabePlayList.calculateTotalDuration() + " minutes");

        System.out.println("\n======================================");
        // ADD AT A SPECIFIC POSITION (Position 2)
        System.out.println("-- Adding 'Travailler' by Imilo Lechanceux at position 2 --");
        BurkinabePlayList.addAtPosition(new Song("Travailler", "Imilo Lechanceux", 4.20), 2);
        BurkinabePlayList.displayPlayList();
        System.out.println("\n Total Playlist Duration: " + BurkinabePlayList.calculateTotalDuration() + " minutes");

        System.out.println("\n======================================");
        // ADD AT POSITION 3 - "N'do" by Greg Burkimbila
        System.out.println("-- Adding 'N'do' by Greg Burkimbila at position 3 --");
        BurkinabePlayList.addAtPosition(new Song("N'do", "Greg Burkimbila", 4.10), 3);
        BurkinabePlayList.displayPlayList();
        System.out.println("\n Total Playlist Duration: " + BurkinabePlayList.calculateTotalDuration() + " minutes");

        System.out.println("\n======================================");
        // REMOVE A SONG BY TITLE ('Travailler')
        System.out.println("-- Removing 'Travailler' by title --");
        BurkinabePlayList.removeSong("Travailler");
        BurkinabePlayList.displayPlayList();
        System.out.println("\n Total Playlist Duration: " + BurkinabePlayList.calculateTotalDuration() + " minutes");

        System.out.println("\n======================================");
        // REMOVE A SONG BY POSITION (Position 2)
        System.out.println("-- Removing song at position 2 ('N'do') --");
        BurkinabePlayList.removeSong(2);
        BurkinabePlayList.displayPlayList();
        System.out.println("\n Total Playlist Duration: " + BurkinabePlayList.calculateTotalDuration() + " minutes");

        System.out.println("\n======================================");
        // ADD AT THE END OF THE PLAYLIST
        System.out.println("-- Adding 'Ouaga est bon' by Hamed Smani --");
        BurkinabePlayList.addAtEnd(new Song("Ouaga est bon", "Hamed Smani", 5.50));
        BurkinabePlayList.displayPlayList();
        System.out.println("\n Total Playlist Duration: " + BurkinabePlayList.calculateTotalDuration() + " minutes");

        System.out.println("\n======================================");
        // ADD FINAL SONG TO ENSURE SIX SONGS IN PLAYLIST
        System.out.println("-- Adding 'Fasonin' by Sana Bob --");
        BurkinabePlayList.addAtEnd(new Song("Fasonin", "Sana Bob", 4.05));
        BurkinabePlayList.displayPlayList();
        System.out.println("\n Total Playlist Duration: " + BurkinabePlayList.calculateTotalDuration() + " minutes");


        System.out.println("\n======================================");
        // PLAY SONG CONTINUOUSLY
        System.out.println("-- Playing song continuously before 'Le chapeau du chef' --");
        BurkinabePlayList.continuousPlay("Le chapeau du chef");

        System.out.println("\n======================================");
        // SHUFFLING PLAYLIST
        System.out.println("-- Playlist after being shuffled --");
        BurkinabePlayList.shufflePlayList();
        BurkinabePlayList.displayPlayList();
    }
}
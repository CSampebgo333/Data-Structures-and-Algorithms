public class Song {
    private String title;
    private String artist;
    private double duration;
    public Song next;
    public Song prev;

    public Song(String title, String artist, double duration){
        this.title = title;
        this.artist = artist;
        this.duration = duration;
        this.next = null;
    }

    public String getTitle(){
        return this.title;
    }

    public double getDuration(){
        return this.duration;
    }

    @Override
    public String toString() {
        return "\n Song title: " + this.title + " | " +  "Artist: " + this.artist + " | " + "Duration: " + this.duration + " minutes";
    }
}

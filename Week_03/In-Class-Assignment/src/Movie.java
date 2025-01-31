public class Movie {

    // Instances
    private String title;
    private int releaseYear;
    private double rating; // The rating is over 5 eg (../5)

    // Constructor
    public Movie(String title, int releaseYear, double rating){
        this.title = title;
        this.releaseYear = releaseYear;
        this.rating = rating;
    }

    // Some Methods for Movie
    public String getTitle(){
        return this.title;
    }

    public double getRating(){
        return this.rating;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", releaseYear=" + releaseYear +
                ", rating=" + rating +
                '}';
    }
}

public class Movie {
    private String title;
    private int releaseYear;
    private double rating;

    public Movie(String title, int releaseYear, double rating){
        this.title = title;
        this.releaseYear = releaseYear;
        this.rating = rating;
    }

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

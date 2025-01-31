import java.io.ObjectInputStream;

public class Main{
    public static void main(String[] args)
    {
        System.out.println("Almost Done!");
        BasicArrayList<Movie> movies = new BasicArrayList<>();

        movies.add(new Movie("Squid Game", 2022, 5));
        movies.add(new Movie("Captain America", 2019, 4.5));
        movies.add(new Movie("Merlin", 2008, 4.7));
        movies.add(new Movie("Greg Burkimbila", 2015, 4.8));
        movies.add(new Movie("Le 15 Avril", 2016, 4.3));

        movies.displayArray();
        double averageRating = calculateAverage(movies);
        System.out.println("Average Rating = " + averageRating);

        int indexOfElementToBeremoved = getIndexOf("Captain America", movies);
        movies.remove(indexOfElementToBeremoved);

        movies.displayArray();
        double averageRating2 = calculateAverage(movies);
        System.out.println("Average Rating = " + averageRating2);


    }
    public static double calculateAverage(BasicArrayList<Movie> movies){
        double totalRating = 0;
        int numRating = 0;
        for(int i = 0; i < movies.size(); i ++){
            totalRating += movies.get(i).getRating();
            numRating ++;
        }
        return (totalRating / numRating);
    }

    public static int getIndexOf(String title, BasicArrayList<Movie> movies){
        for (int i = 0; i < movies.size(); i ++){
            if (movies.get(i).getTitle().equals(title)){
                return i;
            }
        }
        return -1;
    }
}
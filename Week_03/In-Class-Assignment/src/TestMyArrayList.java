public class TestMyArrayList {
    public static void main(String[] args){

        MyArrayList<Movie> movies = new MyArrayList<>();

        // Adding Movies
        movies.add(new Movie("Squid Game", 2022, 5));
        movies.add(new Movie("Wrong Turn", 2003, 4.7));
        movies.add(new Movie("James Bond", 1983, 4.0));
        movies.add(new Movie("Greg Burkimbila", 2016, 4.9));
        movies.add(new Movie("Fast and Furious", 2019, 4.8));
        movies.add(new Movie("L'As Du Lycée", 2009, 5));
        movies.add(new Movie("Avengers", 2020, 4.5));

        // Before removing anything form my current list of Movies
        System.out.println("\nList of Movies before Remove:");
        movies.displayArray();
        double averageRating1 = calculateAverageRating(movies);
        System.out.println("Average rating before remove: " + averageRating1);

        // Remove a movie using its title;
        Movie removedMovie1 = movies.remove(getIndexOf("Squid Game", movies));
        Movie removedMovie2 = movies.remove(getIndexOf("Wrong Turn", movies));

        // After Removing 02 movies:
        System.out.println("\nList of Movies after Remove: \n");
        movies.displayArray();
        System.out.println("Title of movies removed: " + removedMovie1.getTitle() + " and " + removedMovie2.getTitle());
        double averageRating2 = calculateAverageRating(movies);
        System.out.println("Average rating After remove: " + averageRating2);



    }

    public static double calculateAverageRating(MyArrayList<Movie> movies){
        double totalRating = 0;
        int countMovie = 0;
        for (int i = 0; i < movies.size(); i++){
            totalRating += movies.get(i).getRating();
            countMovie += 1;
        }
        return totalRating / countMovie;
    }

    public static int getIndexOf(String movieTitle, MyArrayList<Movie> movies){
        for (int i = 0; i < movies.size(); i++){
            if (movieTitle.equals(movies.get(i).getTitle())){
                return i;
            }
        }
        return -1;
    }
}
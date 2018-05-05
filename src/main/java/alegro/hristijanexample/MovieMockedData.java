package alegro.hristijanexample;

import java.util.ArrayList;
import java.util.List;

public class MovieMockedData {

    private List<Movie> movies;
    private static MovieMockedData mockedData = null;

    private MovieMockedData(){
        movies = new ArrayList<Movie>();
        movies.add(new Movie(1,"The Godfather",
                "The aging patriarch of an organized crime dynasty transfers control of " +
                        "his clandestine empire to his reluctant son"));
        movies.add(new Movie(2,"The Shawshank Redemption",
                "Two imprisoned men bond over a number of years, finding solace and " +
                        "eventual redemption through acts of common decency"));
        movies.add(new Movie(3, "The Dark Knight", "When the menace known as" +
                " the Joker emerges from his mysterious past, he wreaks havoc and chaos on the people of" +
                " Gotham. The Dark Knight must accept one of the greatest psychological and physical tests" +
                " of his ability to fight injustice"));
        movies.add(new Movie(4, "Schindler's List", "In German-occupied Poland during" +
                " World War II, Oskar Schindler gradually becomes concerned for his Jewish workforce after " +
                "witnessing their persecution by the Nazi Germans"));
    }

    public static MovieMockedData getInstance(){
        if(mockedData == null)
            mockedData = new MovieMockedData();

        return mockedData;
    }

    /**
     * @return a list of all movies
     */
    public List<Movie> returnMovies(){
       return movies;
    }

    /**
     * @param id the id of the movie to be returned
     * @return a movie matching the id, null if it doesn't match
     */
    public Movie movieById(int id){
        for(Movie m : movies){
            if(m.getId() == id)
                return m;
        }

        return null;
    }

    /**
     * @param searchText the text to be searched in the title or the description of the movie
     * @return a list of movies matching containing the searched text
     */
    public List<Movie> searchMovies(String searchText){
        List<Movie> matchingMovies = new ArrayList<Movie>();

        for(Movie m : movies){
            if(m.getNameMovie().toLowerCase().contains(searchText) ||
                    m.getDescription().toLowerCase().contains(searchText))
            {
                   matchingMovies.add(m);
            }
        }

        return matchingMovies;
    }

    /**
     * @param movieName the name of the movie
     * @param description the description od the movie
     * @return the newly created movie
     */
    public Movie createMovie(String movieName, String description){
        // Taking the last element of the array and incrementing it's id to get the new id for the movie
        int arraySize = movies.size();
        int newId = movies.get(arraySize-1).getId() + 1;
        Movie newMovie = new Movie(newId,movieName,description);

        movies.add(newMovie);
        return newMovie;
    }

    /**
     * @param id the id of the movie to be updated
     * @param movieName the new name of the movie
     * @param description the new description of the movie
     * @return the newly updated movie, null if no movie with the id was found
     */
    public Movie updateBlog(int id, String movieName, String description){
        for(Movie m : movies){
            if(m.getId() == id){
                int movieIndex = movies.indexOf(m);
                m.setNameMovie(movieName);
                m.setDescription(description);
                movies.set(movieIndex,m);
                return m;
            }
        }
        return null;
    }

    /**
     * @param id the id of the movie to be deleted
     * @return true if the movie is deleted, false if no movie with the id was found
     */
    public boolean deleteMovie(int id){
        int movieIndex = -1;

        for(Movie m : movies){
            if(m.getId() == id){
                movieIndex = movies.indexOf(m);
            }
        }

        // Movie deleted outside of the for loop to avoid ConcurrentModificationException
        if(movieIndex > -1){
            movies.remove(movieIndex);
            return true;
        }

        return false;
    }
}

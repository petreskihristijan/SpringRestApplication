package alegro.hristijanexample;

public class Movie {
    private int id;
    private String nameMovie;
    private String description;

    public Movie(){}

    public Movie(int id, String nameMovie, String description){
        this.id = id;
        this.nameMovie = nameMovie;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameMovie() {
        return nameMovie;
    }

    public void setNameMovie(String nameMovie) {
        this.nameMovie = nameMovie;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Movie " + id + ": " +
                nameMovie + " /*" + description + "*/";
    }
}

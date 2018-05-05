package alegro.hristijanexample;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class MovieController {
    MovieMockedData mockedData = MovieMockedData.getInstance();

    @GetMapping("/movies")
    public List<Movie> index(){
        return mockedData.returnMovies();
    }

    @GetMapping("/movies/{id}")
    public Movie show(@PathVariable String id){
        int movieId = Integer.parseInt(id);
        return mockedData.movieById(movieId);
    }

    @PostMapping("/movies/search")
    public List<Movie> search(@RequestBody Map<String,String> body){
        String searchText = body.get("text");
        return mockedData.searchMovies(searchText);
    }

    @PostMapping("/movies")
    public Movie create(@RequestBody Map<String,String> body){
        String title = body.get("title");
        String content = body.get("content");
        return mockedData.createMovie(title,content);
    }

    @PutMapping("/movies/{id}")
    public Movie update(@PathVariable String id, @RequestBody Map<String,String> body){
        int movieId = Integer.parseInt(id);
        String title = body.get("title");
        String content = body.get("content");
        return mockedData.updateBlog(movieId, title, content);
    }

    @DeleteMapping("/movies/{id}")
    public boolean delete(@PathVariable String id){
        int movieId = Integer.parseInt(id);
        return mockedData.deleteMovie(movieId);
    }
}

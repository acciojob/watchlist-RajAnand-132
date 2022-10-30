package com.driver;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("movies")
public class MovieController {

    @Autowired
    MovieService movieService;

    @PostMapping("/add-movie")
    public ResponseEntity<String> addMovie(@RequestBody Movie movie){
        movieService.addMovie(movie);
        return new ResponseEntity<>("Success", HttpStatus.ACCEPTED);
    }

    @PostMapping("add-director")
    public ResponseEntity<String> addDirector(@RequestBody Director director){
        movieService.addDirector(director);
        return new ResponseEntity<>("Success",HttpStatus.ACCEPTED);
    }


    @PutMapping("add-movie-director-pair")
    public ResponseEntity<String> addMovieDirectorPair(@RequestParam("movie")String Mname,@RequestParam("director") String Dname){
        movieService.PairMAndD(Mname,Dname);
        return new ResponseEntity<>("Success",HttpStatus.OK);
    }

    @GetMapping("get-movie-by-name/{name}")
    public ResponseEntity<Movie> getMovieByName(@PathVariable("name") String name){
        return new ResponseEntity<>(movieService.FindMovie(name),HttpStatus.FOUND);
    }

    @GetMapping("get-director-by-name/{name}")
    public ResponseEntity<Director> getDirectorByName(@PathVariable("name") String name){
        return new ResponseEntity<>(movieService.FindDirector(name),HttpStatus.FOUND);
    }

    @GetMapping("get-movies-by-director-name/{director}")
    public ResponseEntity<List<String>> getMoviesByDirectorName(@PathVariable("director") String name){
        return new ResponseEntity<>(movieService.getMoviesByDirector(name),HttpStatus.FOUND);
    }

    @GetMapping("/get-all-movies")
    public ResponseEntity<List<String>> findAllMovies(){
        return new ResponseEntity<>(movieService.findAllMovies(),HttpStatus.FOUND);
    }


    @DeleteMapping("delete-director-by-name")
    public ResponseEntity<String> deleteDirectorByName(@RequestParam("name") String name){
        movieService.DeleteMovieByDirectorName(name);
        return new ResponseEntity<>("Success",HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/delete-director-by-nameN")
    public ResponseEntity<String> deleteAllDirectors(){
        movieService.DeleteAll();
        return new ResponseEntity<>("Success",HttpStatus.ACCEPTED);
    }
}

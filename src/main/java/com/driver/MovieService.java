package com.driver;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;

    public void addMovie(Movie movie) {
        movieRepository.AddMovieToDB(movie);
    }

    public void addDirector(Director director) {
        movieRepository.AddDirectorToDB(director);
    }

    public void PairMAndD(String movieName, String directorName){
        movieRepository.PairMovieAndDirectorToDB(movieName,directorName);
    }

    public Movie FindMovie(String name){
        return movieRepository.findMovieInDB(name);
    }

    public Director FindDirector(String name){
        return movieRepository.findDirectorInDB(name);
    }

    public List<String> getMoviesByDirector(String name){
        return movieRepository.ListofMoviesInDBByDirector(name);
    }

    public List<String> findAllMovies(){
        return movieRepository.findAllMoviesInDB();
    }

    public void DeleteMovieByDirectorName(String name){
        movieRepository.DeleteMovieFromDBbyName(name);
    }

    public void DeleteAll(){
        movieRepository.DeleteAllMappedInDB();
    }

}



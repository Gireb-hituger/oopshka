package org.example.oopshka.api;


import Movie.Movie;
import org.example.oopshka.dao.MovieDao;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    private final MovieDao dao;

    public MovieController(MovieDao dao) {
        this.dao = dao;
    }

    @GetMapping
    public List<Movie> getAll() {
        try {
            return dao.getAllMovies();
        } catch (SQLException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e);
        }
    }

    @PostMapping
    public int create(@RequestBody Movie movie) {
        try {
            return dao.insertMovie(movie);
        } catch (SQLException e) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    e.getMessage(),
                    e
            );
        }
    }

    @DeleteMapping("/{idkk}")
    public void delete(@PathVariable int idkk) {
        try {
            dao.deleteMovie(idkk);
        } catch (SQLException e) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    e.getMessage(),
                    e
            );
        }
    }

    @PutMapping("/{id}")
    public void updatenig(@PathVariable int id, @RequestParam String name){
        try {
            if (name != null) {
                dao.updateMovieName(id, name);
            };
        } catch (SQLException e) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    e.getMessage(),
                    e
            );
        }
    }

    @PatchMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody Movie movie){
        try {
            if (movie.getName() != null) {
                dao.updateMovieName(id, movie.getName());
            };
            if (movie.getDescription() != null) {
                dao.updateMovieDescription(id, movie.getDescription());
            };
            if (movie.getYear() != null) {
                dao.updateMovieYear(id, movie.getYear());
            }
        } catch (SQLException e) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    e.getMessage(),
                    e
            );
        }
    }
}

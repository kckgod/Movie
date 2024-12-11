package kr.ac.mjc.movie.controller;

import kr.ac.mjc.movie.domain.MovieList;
import kr.ac.mjc.movie.dto.AddMovieRequest;
import kr.ac.mjc.movie.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class MovieController {

    @Autowired
    private MovieService movieService;

    @PostMapping("/api/movies") // 이 주소로 Post 요청을 보내면 아래 메서드 실행
    public ResponseEntity<MovieList> addMovieList(@RequestBody AddMovieRequest request) {
        MovieList savedMovieList = movieService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedMovieList);
    }
}
package kr.ac.mjc.movie.service;

import kr.ac.mjc.movie.domain.MovieList;
import kr.ac.mjc.movie.domain.User;
import kr.ac.mjc.movie.dto.AddMovieRequest;
import kr.ac.mjc.movie.repository.MovieRepository;
import kr.ac.mjc.movie.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private UserRepository userRepository;

    public MovieList save(AddMovieRequest request) {
        return movieRepository.save(request.toEntity());
    }

    // MovieViewController에서 전체 영화 목록 출력하기 위한 코드 - findAll
    public List<MovieList> findAll() {
        List<MovieList> movieList = movieRepository.findAll();
        return movieList;
    }

    // MovieViewController에서 선택한 영화 상세 정보 출력하기 위한 코드 - findOne
    public MovieList findOne(long id) {
        MovieList movieList = movieRepository.findById(id).orElseThrow(); // 찾아내지 못할 경우 에러가 발생하게 처리 -> orElseThrow
        return movieList;
    }
}

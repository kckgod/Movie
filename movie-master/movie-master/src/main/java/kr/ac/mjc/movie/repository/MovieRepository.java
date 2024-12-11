package kr.ac.mjc.movie.repository;

import kr.ac.mjc.movie.domain.MovieList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MovieRepository extends JpaRepository<MovieList, Long> {
}

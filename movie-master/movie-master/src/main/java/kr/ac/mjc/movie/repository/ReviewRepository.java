package kr.ac.mjc.movie.repository;

import kr.ac.mjc.movie.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    List<Review> findByMovieId(long movieId);
}
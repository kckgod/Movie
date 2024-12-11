package kr.ac.mjc.movie.service;

import jakarta.transaction.Transactional;
import kr.ac.mjc.movie.domain.MovieList;
import kr.ac.mjc.movie.domain.Review;
import kr.ac.mjc.movie.domain.User;
import kr.ac.mjc.movie.dto.AddReviewRequest;
import kr.ac.mjc.movie.dto.UpdateReviewRequest;
import kr.ac.mjc.movie.repository.ReviewRepository;
import kr.ac.mjc.movie.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private UserRepository userRepository;

    public Review save(AddReviewRequest request, String userId, long movieId) {
        Review review = request.toEntity();
        User user = userRepository.findByEmail(userId);
        review.setWriter(user);
        MovieList movie = new MovieList(movieId);
        review.setMovie(movie);
        return reviewRepository.save(review);
    }

    public List<Review> findAll() {
        List<Review> reviews = reviewRepository.findAll();
        return reviews;
    }

    public Review findOne(long id) {
        Review reviews = reviewRepository.findById(id).orElseThrow(); // 찾아내지 못할 경우 에러가 발생하게 처리 -> orElseThrow
        return reviews;
    }

    public List<Review> findReviewsByMovie(long movieId) {
        List<Review> reviews = reviewRepository.findByMovieId(movieId);
        return reviews;
    }

    @Transactional // 어노테이션을 사용해야 업데이트가 진행된 후 데이터베이스에 적용, import 할 때 spring에 있는 것을 사용해야 함
    public Review update(long id, UpdateReviewRequest request) {
        Review review = reviewRepository.findById(id).orElseThrow();
        review.update(request.getContent());
        return review;
    }
}

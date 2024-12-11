package kr.ac.mjc.movie.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import kr.ac.mjc.movie.domain.Review;
import kr.ac.mjc.movie.dto.AddReviewRequest;
import kr.ac.mjc.movie.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class ReviewController {

    @Autowired
    ReviewService reviewService;

    // 전체 관람평 목록 출력
    @GetMapping("/api/reviews")
    public ResponseEntity<List<Review>> findAllReview() { // 전체 관람평 목록이 와야 하기 때문에 <List<Review>>로 작성
        List<Review> reviews = reviewService.findAll();
        return ResponseEntity.ok().body(reviews);
    }

    // 해당 id 값에 따른 관람평 목록 출력
    @GetMapping("/api/reviews/{id}")
    public ResponseEntity<Review> findReview(@PathVariable long id) { // url에 들어온 id 값을 변수로 받아오기 -> @PathVariable
        Review reviews = reviewService.findOne(id);
        return ResponseEntity.ok().body(reviews);
    }

    // 해당 영화에 대한 관람평 작성
    @PostMapping("/api/reviews")
    public ResponseEntity<Review> addReview(@RequestBody AddReviewRequest request, HttpServletRequest httpServletRequest) {
        HttpSession session = httpServletRequest.getSession(true);
        String userId = (String) session.getAttribute("userId");
        String movieId_ = (String) session.getAttribute("movieId");
        long movieId = Long.parseLong(movieId_);

        if(userId == null) {
            return ResponseEntity.badRequest().body(null);
        }

        Review savedReview = reviewService.save(request, userId, movieId);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedReview);
    }
}
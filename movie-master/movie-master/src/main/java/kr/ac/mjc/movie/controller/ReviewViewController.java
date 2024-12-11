package kr.ac.mjc.movie.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import kr.ac.mjc.movie.domain.MovieList;
import kr.ac.mjc.movie.domain.Review;
import kr.ac.mjc.movie.service.MovieService;
import kr.ac.mjc.movie.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ReviewViewController {

    @Autowired
    ReviewService reviewService;

    @Autowired
    MovieService movieService;

    // 전체 관람평 목록 출력
    @GetMapping("/reviews")
    public ModelAndView getReviews() {
        ModelAndView mav = new ModelAndView();
        List<Review> reviews = reviewService.findAll();
        mav.addObject("reviews", reviews);
        mav.setViewName("AllReview");
        return mav;
    }

    // 해당 영화에 대한 전체 관람평 출력
    @GetMapping("/reviews/{movieId}/reviews")
    public ModelAndView getReviewsByMovie(@PathVariable long movieId) {
        ModelAndView mav = new ModelAndView();
        List<Review> reviews = reviewService.findReviewsByMovie(movieId);
        mav.addObject("reviews", reviews);
        mav.setViewName("SelectedReview");
        return mav;
    }

    // 관람평 작성(로그인이 되어 있는지 확인 후 작성 가눙)
    @GetMapping("/new-reviews")
    public ModelAndView createReview(HttpServletRequest httpServletRequest, Model model, @RequestParam("movieId") String movieId) { //** html에서 movieId를 RequestParam 받음
        HttpSession session = httpServletRequest.getSession(true);
        session.setAttribute("movieId", movieId); // movieId를 세션에 저장
        String userId = (String)session.getAttribute("userId");
        ModelAndView mv1 = new ModelAndView();
        mv1.setViewName("NewReview");
        if (userId == null) {
            ModelAndView mv2 = new ModelAndView("login");
            mv2.addObject("errorMessage", "errorMessage");
            return mv2;
        }
        return mv1;
    }
}

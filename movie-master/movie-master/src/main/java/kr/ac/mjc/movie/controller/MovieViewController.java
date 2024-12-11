package kr.ac.mjc.movie.controller;

import jakarta.servlet.http.HttpSession;
import kr.ac.mjc.movie.domain.MovieList;
import kr.ac.mjc.movie.domain.User;
import kr.ac.mjc.movie.service.MovieService;
import kr.ac.mjc.movie.service.ReviewService;
import kr.ac.mjc.movie.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class MovieViewController {

    @Autowired
    MovieService movieService;

    @Autowired
    UserService userService;

    @Autowired
    ReviewService reviewService;

    // 전체 영화 목록 출력
    @GetMapping("/movies")
    public ModelAndView getMovies(HttpSession session) {
        ModelAndView mav = new ModelAndView();
        List<MovieList> movies = movieService.findAll();
        String userId= (String)session.getAttribute("userId");

        boolean isLoggedIn = userId != null;
        if(isLoggedIn){
            User user=userService.findByEmail(userId);
            mav.addObject("user",user);
        }

        mav.addObject("isLoggedIn", isLoggedIn);
        mav.addObject("movies", movies);
        mav.setViewName("MovieChart");
        return mav;
    }

    // 선택한 영화 상세 정보 출력
    @GetMapping("/movies/{id}")
    public ModelAndView getMovies(@PathVariable long id, HttpSession session) {
        ModelAndView mav = new ModelAndView();
        MovieList movies = movieService.findOne(id);
        String userId= (String)session.getAttribute("userId");

        boolean isLoggedIn = userId != null;
        if(isLoggedIn){
            User user=userService.findByEmail(userId);
            mav.addObject("user",user);
        }

        mav.addObject("isLoggedIn", isLoggedIn);
        mav.addObject("movies", movies);
        mav.setViewName("MovieInformation");
        return mav;
    }
}

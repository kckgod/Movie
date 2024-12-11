package kr.ac.mjc.movie.controller;

import jakarta.servlet.http.HttpSession;
import kr.ac.mjc.movie.domain.Reservation;
import kr.ac.mjc.movie.domain.User;
import kr.ac.mjc.movie.service.ReservationService;
import kr.ac.mjc.movie.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserViewController {

    @Autowired
    UserService userService;

    @Autowired
    ReservationService reservationService;

    // 회원가입
    @GetMapping("/join")
    public String join() {

        return "Join";
    }

    // 로그인
    @GetMapping("/login")
    public String login() {

        return "Login";
    }

    // 내 정보 수정(마이페이지)
    @GetMapping("/users/modify/{id}")
    public ModelAndView modifyUser(@PathVariable long id) {
        ModelAndView mav = new ModelAndView();
        User user = userService.findOne(id);
        mav.addObject("user", user);
        mav.setViewName("UserModify");
        return mav;
    }
}

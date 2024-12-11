package kr.ac.mjc.movie.controller;

import kr.ac.mjc.movie.domain.ReservationDate;
import kr.ac.mjc.movie.service.DateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

@Controller
public class DateViewController {

    @Autowired
    DateService dateService;

    // 전체 예약 날짜 목록 출력
    @GetMapping("/reservationDate")
    public ModelAndView getDates() {
        ModelAndView mav = new ModelAndView();
        List<ReservationDate> reservationDate = dateService.findAll();
        mav.addObject("reservationDate", reservationDate);
        mav.setViewName("ReservationDate");
        return mav;
    }
}

package kr.ac.mjc.movie.controller;

import kr.ac.mjc.movie.domain.ReservationSeat;
import kr.ac.mjc.movie.service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

@Controller
public class SeatViewController {

    @Autowired
    SeatService seatService;

    // 전체 예약 좌석 목록 출력
    @GetMapping("/reservationSeat")
    public ModelAndView getReviews() {
        ModelAndView mav = new ModelAndView();
        List<ReservationSeat> reservationSeat = seatService.findAll();
        mav.addObject("reservationSeat", reservationSeat);
        mav.setViewName("ReservationSeat");
        return mav;
    }
}

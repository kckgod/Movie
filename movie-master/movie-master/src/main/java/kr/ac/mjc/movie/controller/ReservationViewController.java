package kr.ac.mjc.movie.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import kr.ac.mjc.movie.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ReservationViewController {

    @Autowired
    private ReservationService reservationService;

    @GetMapping("/move-reservation")
    public ModelAndView moveReservation(HttpServletRequest httpServletRequest, @RequestParam("movieId") String movieId) {
        HttpSession session = httpServletRequest.getSession(true);
        String userId = (String) session.getAttribute("userId");
        session.setAttribute("movieId",movieId);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("Ticketing");

        if (userId == null) {
            // 클라이언트에게 알림을 전송하기 위해 ModelAndView를 사용
            ModelAndView mv2 = new ModelAndView("login");
            mv2.addObject("errorMessage", "errorMessage");
            return mv2;
        }

        return mv;
    }

    @PostMapping("/new-reservation")
    public ModelAndView createReservation(HttpServletRequest httpServletRequest,
                                          @RequestParam("selectedDate") String date,
                                          @RequestParam("selectedTime") String time,
                                          @RequestParam("selectedSeatRow") String seatRow,
                                          @RequestParam("selectedSeatColumn") String seatColumn
    ) {
        HttpSession session = httpServletRequest.getSession(true);
        session.setAttribute("reservationDate",date+ time);
        session.setAttribute("reservationSeat",seatRow+ seatColumn);
        String userId = (String)session.getAttribute("userId");
        ModelAndView mv1 = new ModelAndView();
        mv1.setViewName("MovieReservation");
        mv1.addObject("date",date);
        mv1.addObject("time",time);
        mv1.addObject("seatRow",seatRow);
        mv1.addObject("seatColumn",seatColumn);

        if (userId == null) {
            // 클라이언트에게 알림을 전송하기 위해 ModelAndView를 사용
            ModelAndView mv2 = new ModelAndView("login");
            mv2.addObject("errorMessage", "errorMessage");
            return mv2;
        }

        return mv1;
    }
}

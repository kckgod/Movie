package kr.ac.mjc.movie.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import kr.ac.mjc.movie.domain.Reservation;
import kr.ac.mjc.movie.dto.AddReservationRequest;
import kr.ac.mjc.movie.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    // 영화 예매하기
    @PostMapping("/api/reservation")
    public ResponseEntity<Reservation> addReview(@RequestBody AddReservationRequest request, HttpServletRequest httpServletRequest) {
        HttpSession session = httpServletRequest.getSession(true);
        String movieId_ = (String) session.getAttribute("movieId");
        long movieId = Long.parseLong(movieId_);
        String userId = (String) session.getAttribute("userId");

        String res_DateValue = request.getReservationDate();
        String res_TimeValue = request.getReservationTime();
        String res_SeatValue = request.getReservationSeat();
        String res_RownumValue = request.getReservationRowNum();

        String reservationDate = res_DateValue + " " + res_TimeValue;
        String reservationSeat = res_SeatValue + "열 " + res_RownumValue + "번";

        if(userId == null) {
            return ResponseEntity.badRequest().body(null);
        }

        Reservation saveReservation = reservationService.save(userId,movieId,reservationDate,reservationSeat);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(saveReservation);
    }
}

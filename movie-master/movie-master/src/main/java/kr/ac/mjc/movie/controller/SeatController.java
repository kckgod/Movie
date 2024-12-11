package kr.ac.mjc.movie.controller;

import kr.ac.mjc.movie.domain.ReservationSeat;
import kr.ac.mjc.movie.service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class SeatController {

    @Autowired
    SeatService seatService;

    // 전체 좌석 목록 출력
    @GetMapping("/api/seats")
    public ResponseEntity<List<ReservationSeat>> findAllSeat() {
        List<ReservationSeat> reservationSeat = seatService.findAll();
        return ResponseEntity.ok().body(reservationSeat);
    }
}

package kr.ac.mjc.movie.controller;

import kr.ac.mjc.movie.domain.ReservationDate;
import kr.ac.mjc.movie.service.DateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class DateController {

    @Autowired
    DateService dateService;

    // 전체 날짜 목록 출력
    @GetMapping("/api/dates")
    public ResponseEntity<List<ReservationDate>> findAllDate() {
        List<ReservationDate> reservationDate = dateService.findAll();
        return ResponseEntity.ok().body(reservationDate);
    }
}

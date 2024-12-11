package kr.ac.mjc.movie.service;

import kr.ac.mjc.movie.domain.ReservationSeat;
import kr.ac.mjc.movie.repository.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeatService {

    @Autowired
    private SeatRepository seatRepository;

    public List<ReservationSeat> findAll() {
        List<ReservationSeat> reservationSeat = seatRepository.findAll();
        return reservationSeat;
    }
}

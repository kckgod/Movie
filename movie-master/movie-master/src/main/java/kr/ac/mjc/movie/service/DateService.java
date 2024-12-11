package kr.ac.mjc.movie.service;

import kr.ac.mjc.movie.domain.ReservationDate;
import kr.ac.mjc.movie.repository.DateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DateService {

    @Autowired
    private DateRepository dateRepository;

    public List<ReservationDate> findAll() {
        List<ReservationDate> reservationDate = dateRepository.findAll();
        return reservationDate;
    }
}

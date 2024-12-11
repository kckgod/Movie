package kr.ac.mjc.movie.service;

import kr.ac.mjc.movie.domain.MovieList;
import kr.ac.mjc.movie.domain.Reservation;
import kr.ac.mjc.movie.domain.User;
import kr.ac.mjc.movie.repository.ReservationRepository;
import kr.ac.mjc.movie.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private UserRepository userRepository;

    public Reservation save(String userId, long movieId, String reservation_date, String reservation_seat) {
        User user = userRepository.findByEmail(userId);
        MovieList movie = new MovieList(movieId);

        Reservation reservation = new Reservation(user,movie,reservation_date, reservation_seat);

        return reservationRepository.save(reservation);
    }
}

package kr.ac.mjc.movie.repository;

import kr.ac.mjc.movie.domain.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}

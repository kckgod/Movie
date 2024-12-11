package kr.ac.mjc.movie.repository;

import kr.ac.mjc.movie.domain.ReservationSeat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeatRepository extends JpaRepository<ReservationSeat, Long> {
}

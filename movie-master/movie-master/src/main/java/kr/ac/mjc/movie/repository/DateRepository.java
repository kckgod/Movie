package kr.ac.mjc.movie.repository;

import kr.ac.mjc.movie.domain.ReservationDate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DateRepository extends JpaRepository<ReservationDate, Long> {
}

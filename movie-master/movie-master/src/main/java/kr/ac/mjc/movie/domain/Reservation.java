package kr.ac.mjc.movie.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Reservation {

    // 예약 번호
    @Id // primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
    @Column(name = "id", updatable = false)
    private Long id;

    // 예약 영화 시간
    @Column(name = "reservationDate", nullable = false)
    private String reservationDate;

    // 예약 좌석 번호
    @Column(name = "reservationSeat", nullable = false)
    private String reservationSeat;

    // 한 명의 예약자는 여러개의 영화를 예매할 수 있기 때문에 -> 1 : N 관계
    @ManyToOne
    private User user_id;

    // 한 개의 영화는 여러개의 예약 정보를 가질 수 있기 때문에 -> 1 : N 관계
    @ManyToOne
    private MovieList movie_id;

    // 생성자
    @Builder
    public Reservation(String reservationDate, String reservationSeat) {
        this.reservationDate = reservationDate;
        this.reservationSeat = reservationSeat;
    }

    // 생성자
    @Builder
    public Reservation(User user_id, MovieList movie_id, String reservationDate, String reservationSeat) {
        this.user_id = user_id;
        this.movie_id = movie_id;
        this.reservationSeat = reservationSeat;
        this.reservationDate = reservationDate;
    }

    public void setEmail(User user_id) {
        this.user_id = user_id;
    }

    public void setMovie(long movie) {
        this.movie_id = movie_id;
    }
}

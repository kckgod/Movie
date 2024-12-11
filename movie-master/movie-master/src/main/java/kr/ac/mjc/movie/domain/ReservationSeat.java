package kr.ac.mjc.movie.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReservationSeat {

    // 좌석 번호
    @Id // primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
    @Column(name = "id", updatable = false)
    private Long id;

    // 좌석 자리 번호
    @Column(name = "seat")
    private String seat;

    // 생성자
    @Builder
    public ReservationSeat(String seat) {
        this.seat = seat;
    }

    // 캡슐화
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }
}

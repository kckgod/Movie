package kr.ac.mjc.movie.domain;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class) // 시간
public class Review {

    // 작성된 리뷰 번호
    @Id // primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
    @Column(name = "id", updatable = false)
    private Long id;

    // 작성된 리뷰 내용
    @Column(name = "content", nullable = false)
    private String content;

    // 한 명의 작성자는 여러 개의 리뷰를 작성할 수 있기 때문에 -> 1 : N 관계
    @ManyToOne
    private User writer;

    // 한 개의 영화는 여러 개의 리뷰를 가질 수 있기 때문에 -> 1 : N 관계
    @ManyToOne
    private MovieList movie;

    // 리뷰가 작성된 시간
    @CreatedDate
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    // 생성자
    @Builder
    public Review(String content) {
        this.content = content;
    }

    // MovieController의 @PutMapping("/api/movies/{id}")와 관련
    public void update(String content) {
        this.content = content;
    }

    // 시간 정보를 보기 좋게 출력
    public String getFormattedCreatedDate() { // 7주차 내용
        if(createdAt == null) {
            return "";
        }
        DateTimeFormatter pattern = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return createdAt.format(pattern);
    }

    // 캡슐화
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getWriter() {
        return writer;
    }

    public void setWriter(User writer) {
        this.writer = writer;
    }

    public MovieList getMovie() {
        return movie;
    }

    public void setMovie(MovieList movie) {
        this.movie = movie;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}

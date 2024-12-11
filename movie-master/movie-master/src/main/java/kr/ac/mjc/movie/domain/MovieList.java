package kr.ac.mjc.movie.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MovieList {

    // 영화 번호
    @Id // primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
    @Column(name = "id", updatable = false)
    private Long id;

    // 영화 이름
    @Column(name = "name")
    private String name;

    // 영화 감독
    @Column(name = "director")
    private String director;

    // 영화 배우
    @Column(name = "actor")
    private String actor;

    // 영화 장르
    @Column(name = "type")
    private String type;

    // 영화 상영 시간
    @Column(name = "time")
    private String time;

    // 영화 개봉 날짜
    @Column(name = "releaseDate")
    private String releaseDate;

    // 영화 포스터
    @Column(name = "imageUrl")
    private String imageUrl;

    // 영화 줄거리, 줄거리 입력할 때 기본적으로 255자 밖에 입력이 안 되기 때문에 columnDefinition = "TEXT"
    @Column(name="story", columnDefinition = "TEXT")
    private String story;

    // 생성자
    @Builder
    public MovieList(long id) {
        this.id = id;
    }

    // 생성자
    @Builder
    public MovieList(String name, String director, String actor, String type, String time, String releaseDate, String imageUrl, String story) {
        this.name = name;
        this.director = director;
        this.actor = actor;
        this.type = type;
        this.time = time;
        this.releaseDate = releaseDate;
        this.imageUrl = imageUrl;
        this.story = story;
    }

    // 캡슐화
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getStory() {
        return story;
    }

    public void setStory(String story) {
        this.story = story;
    }
}

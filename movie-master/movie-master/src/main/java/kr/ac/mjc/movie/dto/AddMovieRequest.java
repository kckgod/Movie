package kr.ac.mjc.movie.dto;

import kr.ac.mjc.movie.domain.MovieList;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AddMovieRequest {

    private String name;

    private String director;

    private String actor;

    private String type;

    private String time;

    private String releaseDate;

    private String imageUrl;

    private String story;

    public MovieList toEntity() {
        MovieList movieList = new MovieList(name, director, actor, type, time, releaseDate, imageUrl, story);
        return movieList;
    }
}

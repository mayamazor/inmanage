package com.example.inmanage;

public class Movie {

    public final static Movie instance = new Movie();
    private String title , poster , overview;
    private Double rating;

    public Movie() {

    }
//, String poster , String overview , Double rating
    public Movie(String title,String poster ){
        this.title = title;
        this.poster = poster;
//        this.overview = overview;
//        this.rating = rating;
    }



    public String getTitle() {
        return title;
    }

    public String getPoster() {
        return poster;
    }
//
//    public String getOverview() {
//        return overview;
//    }
//
//    public Double getRating() {
//        return rating;
//    }
}

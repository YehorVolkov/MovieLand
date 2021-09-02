package com.yehor.movieland.entity;


import java.util.Date;

public class Movie {
    private int id;
    private String name_russian;
    private String name_native;
    private Date year_of_release;
    private String description;
    private double rating;
    private double price;
    private String picture_path;
    private int votes;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName_russian() {
        return name_russian;
    }

    public void setName_russian(String name_russian) {
        this.name_russian = name_russian;
    }

    public String getName_native() {
        return name_native;
    }

    public void setName_native(String name_native) {
        this.name_native = name_native;
    }

    public Date getYear_of_release() {
        return year_of_release;
    }

    public void setYear_of_release(Date year_of_release) {
        this.year_of_release = year_of_release;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getPicture_path() {
        return picture_path;
    }

    public void setPicture_path(String picture_path) {
        this.picture_path = picture_path;
    }

    public int getVotes() {
        return votes;
    }

    public void setVotes(int votes) {
        this.votes = votes;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", name_russian='" + name_russian + '\'' +
                ", name_native='" + name_native + '\'' +
                ", year_of_release=" + year_of_release +
                ", description='" + description + '\'' +
                ", rating=" + rating +
                ", price=" + price +
                ", picture_path='" + picture_path + '\'' +
                ", votes=" + votes +
                '}';
    }
}

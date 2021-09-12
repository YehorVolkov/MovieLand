package com.yehor.movieland.util;

public class MovieRequest {

    private SortingField sortingField;
    private SortingDirection sortingDirection;
    private Integer genreId;

    public MovieRequest(){}

    public void setSortingField(String sortingField) {
        this.sortingField = SortingField.valueOf(sortingField.toUpperCase());
    }

    public void setSortingDirection(String sortingDirection) {
        this.sortingDirection = SortingDirection.valueOf(sortingDirection.toUpperCase());
    }

    public void setGenreId(int genreId) {
        this.genreId = genreId;
    }

    public SortingField getSortingField() {
        return sortingField;
    }

    public SortingDirection getSortingDirection() {
        return sortingDirection;
    }

    public Integer getGenreId() {
        return genreId;
    }
}

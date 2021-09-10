package com.yehor.movieland.util;

public class MovieRequest {

    // todo maybe we should provide Strings instead of Enums?
    //  for now we simply do double-conversion string-enum-string without any sense
    private SortingField sortingField;
    private SortingDirection sortingDirection;

    public MovieRequest() {
        this.sortingField = SortingField.NONE;
        this.sortingDirection = SortingDirection.NOT_APPLICABLE;
    }

    public MovieRequest(String sortingField, String sortingDirection) {
        if (enumContains(SortingField.class, sortingField)) {
            this.sortingField = SortingField.valueOf(sortingField.toUpperCase());
        }
        if (enumContains(SortingDirection.class, sortingDirection)) {
            this.sortingDirection = SortingDirection.valueOf(sortingDirection.toUpperCase());
        }
    }

    public void setSortingField(String sortingField) {
        if (enumContains(SortingField.class, sortingField)) {
            this.sortingField = SortingField.valueOf(sortingField.toUpperCase());
        }
    }

    public void setSortingDirection(String sortingDirection) {
        if (enumContains(SortingDirection.class, sortingDirection)) {
            this.sortingDirection = SortingDirection.valueOf(sortingDirection.toUpperCase());
        }
    }

    public SortingField getSortingField() {
        return sortingField;
    }

    public SortingDirection getSortingDirection() {
        return sortingDirection;
    }

    private <E extends Enum<E>> boolean enumContains(Class<E> currEnum, String value) {
        if (value != null) {
            for (Enum<E> enumVal: currEnum.getEnumConstants()) {
                if (enumVal.name().equals(value.toUpperCase())) {
                    return true;
                }
            }
        }
        return false; // todo returns false if value is null, ok behavior?
    }
}

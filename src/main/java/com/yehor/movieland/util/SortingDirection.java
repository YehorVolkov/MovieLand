package com.yehor.movieland.util;

// todo SortingDirection enum theoretically could be used without SortingField enum
//  maybe better to create enum "Sorting", with SortingField and SortingDirection inside, binding them together?
public enum SortingDirection {
    ASC,
    DESC,
    NOT_APPLICABLE // todo weird???
}

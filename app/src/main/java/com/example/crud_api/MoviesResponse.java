package com.example.crud_api;

import java.util.List;

public class MoviesResponse<T> {
    List<T> results;

    public List<T> getResult() {
        return results;
    }

    public void setResult(List<T> result) {
        this.results = result;
    }
}

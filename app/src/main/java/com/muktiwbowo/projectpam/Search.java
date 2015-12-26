package com.muktiwbowo.projectpam;

/**
 * Created by muktiwbowo on 19/12/15.
 */
public class Search {
    private String keyword;
    private String results;

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getResults() {
        return results;
    }

    public void setResults(String results) {
        this.results = results;
    }

    @Override
    public String toString()
    {
        return this.keyword;
    }
}

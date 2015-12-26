package com.muktiwbowo.projectpam;

/**
 * Created by muktiwbowo on 26/12/15.
 */
public class Android {
    private String aKeyword;
    private String aResult;

    public String getaKeyword() {
        return aKeyword;
    }

    public void setaKeyword(String aKeyword) {
        this.aKeyword = aKeyword;
    }

    public String getaResult() {
        return aResult;
    }

    public void setaResult(String aResult) {
        this.aResult = aResult;
    }

    @Override
    public String toString()
    {
        return this.aKeyword;
    }
}

package com.example.my1stapp;

/**
***   saimonx  Sklad Art   2020-03-14
 */

public class mySample {
    private String skl;
    private String art;

    public String getSkl() {
        return skl;
    }

    public void setSkl(String skl) {
        this.skl = skl;
    }

    public String getArt() {
        return art;
    }

    public void setArt(String art) {
        this.art = art;
    }

    @Override
    public String toString() {
        return "mySample{" +
                "art='" + art + '\'' +
                ", skl=" + skl +
                '}';
    }
}

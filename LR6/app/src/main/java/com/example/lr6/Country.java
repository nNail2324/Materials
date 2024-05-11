package com.example.lr6;

public class Country {

    private String name;
    private int flag;

    public Country(String name, int flag){

        this.name=name;
        this.flag=flag;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFlagResource() {
        return this.flag;
    }

    public void setFlagResource(int flagResource) {
        this.flag = flagResource;
    }
}

package com.example.parsejson;

/**
 * Created by matt on 3/25/18.
 */

public class Pet {
    private String name;
    private String file;

    public Pet(String name, String file){

        this.name = name;
        this.file = file;
    }
    public String getName(){
        return name;
    }
    public String getFile(){
        return file;
    }
}

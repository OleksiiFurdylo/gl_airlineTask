package com.exceptions;

/**
 * Created by OleksiiF on 11.05.2018.
 */
public class NoSuchAircraftType extends Exception {
    public NoSuchAircraftType(String massage){
        super(massage);
    }
}

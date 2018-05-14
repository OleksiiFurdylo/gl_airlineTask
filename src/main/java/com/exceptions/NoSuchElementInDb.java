package com.exceptions;

/**
 * Created by OleksiiF on 14.05.2018.
 */
public class NoSuchElementInDb extends Exception {
    public NoSuchElementInDb(String massage){
        super(massage);
    }
}

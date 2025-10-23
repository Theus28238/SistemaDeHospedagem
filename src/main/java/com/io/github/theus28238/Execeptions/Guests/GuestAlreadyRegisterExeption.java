package com.io.github.theus28238.Execeptions.Guests;


public class GuestAlreadyRegisterExeption extends RuntimeException {
    public GuestAlreadyRegisterExeption(){
        super("Guest already register");
    }

    public GuestAlreadyRegisterExeption(String message){
        super(message);
    }
}

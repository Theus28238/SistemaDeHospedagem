package com.io.github.theus28238.Execeptions.Reservations;

public class RoomNotFound extends RuntimeException {

    public RoomNotFound(){
        super("Reservation not found");
    }
    public RoomNotFound(String message){
       super(message);
    }
}

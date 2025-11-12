package com.io.github.theus28238.Execeptions.Reservations;

public class ReservationNotFoundExeception extends RuntimeException {
    public ReservationNotFoundExeception() {
        super("This reservation cannot be found");
    }
}

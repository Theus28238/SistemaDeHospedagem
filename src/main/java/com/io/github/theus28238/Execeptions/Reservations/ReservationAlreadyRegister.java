package com.io.github.theus28238.Execeptions.Reservations;

public class ReservationAlreadyRegister extends RuntimeException {

  public ReservationAlreadyRegister(){
    super("This reservation could not be doing");
  }
    public ReservationAlreadyRegister(String message) {
        super(message);
    }
}

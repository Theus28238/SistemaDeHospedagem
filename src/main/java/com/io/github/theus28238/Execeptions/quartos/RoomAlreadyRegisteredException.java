package com.io.github.theus28238.Execeptions.quartos;

public class RoomAlreadyRegisteredException extends RuntimeException {
    public RoomAlreadyRegisteredException() {
        super("Room already registered");
    }
}

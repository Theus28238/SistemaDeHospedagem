package com.io.github.theus28238.Execeptions.pagamentos;

public class AlreadyPaidExeception extends RuntimeException {
    public AlreadyPaidExeception() {
        super("This reservation is already paid");
    }
}

package com.io.github.theus28238.Execeptions.pagamentos;

public class PaidNotFoundExeception extends RuntimeException {
    public PaidNotFoundExeception() {
        super("Paid not could be found");
    }
}

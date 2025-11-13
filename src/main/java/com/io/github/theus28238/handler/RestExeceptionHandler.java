package com.io.github.theus28238.handler;

import com.io.github.theus28238.Execeptions.Guests.GuestAlreadyRegisterExeption;
import com.io.github.theus28238.Execeptions.Guests.GuestNotFoundExeption;
import com.io.github.theus28238.Execeptions.Reservations.ReservationAlreadyRegister;
import com.io.github.theus28238.Execeptions.Reservations.ReservationNotFoundExeception;
import com.io.github.theus28238.Execeptions.pagamentos.AlreadyPaidExeception;
import com.io.github.theus28238.Execeptions.pagamentos.PaidNotFoundExeception;
import com.io.github.theus28238.Execeptions.quartos.RoomNotFound;
import com.io.github.theus28238.Execeptions.quartos.RoomAlreadyRegisteredException;
import org.springframework.boot.autoconfigure.batch.BatchTaskExecutor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class RestExeceptionHandler extends ResponseEntityExceptionHandler {


    // TRATAMENTO DE ERRO DE HOSPEDES
    @ResponseBody
    @ExceptionHandler(GuestAlreadyRegisterExeption.class)
    public ResponseEntity<RestErrorMessage> guestAlreadyRegister(GuestAlreadyRegisterExeption exeption){
        RestErrorMessage threatMessage = new RestErrorMessage(
                LocalDateTime.now(),HttpStatus.CONFLICT,exeption.getMessage(),"Could not register 2 guests");
        return ResponseEntity.status(HttpStatus.CONFLICT).body(threatMessage);
    }

    @ResponseBody
    @ExceptionHandler(GuestNotFoundExeption.class)
    public ResponseEntity<RestErrorMessage> guestNotFound(GuestNotFoundExeption exeption){
        RestErrorMessage threatMessage = new RestErrorMessage(
                LocalDateTime.now(), HttpStatus.NOT_FOUND,exeption.getMessage(), "This guest could not be found");
        return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(threatMessage);
    }

    // TRATAMENTO DE ERRO DE RESERVAS
    @ResponseBody
    @ExceptionHandler(ReservationAlreadyRegister.class)
    public ResponseEntity<RestErrorMessage> reservationAlreadyDo(ReservationAlreadyRegister ex){
        RestErrorMessage threatMessage = new RestErrorMessage(
                LocalDateTime.now(), HttpStatus.CONFLICT, ex.getMessage(), "It is not possible to add 2 reservation in the same dates");
        return ResponseEntity.status(HttpStatus.CONFLICT).body(threatMessage);
    }

    @ResponseBody
    @ExceptionHandler(RoomNotFound.class)
    public ResponseEntity<RestErrorMessage> roomNotFound(RoomNotFound ex){
        RestErrorMessage threatMessage = new RestErrorMessage(LocalDateTime.now(), HttpStatus.NOT_FOUND, ex.getMessage(), "This room could not be found");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(threatMessage);
    }

    @ResponseBody
    @ExceptionHandler(ReservationNotFoundExeception.class)
    public ResponseEntity<RestErrorMessage> reservationNotFound(ReservationNotFoundExeception exeption){
        RestErrorMessage threatMessage = new RestErrorMessage(
                LocalDateTime.now(), HttpStatus.NOT_FOUND,exeption.getMessage(), "This reservation could not be found"
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(threatMessage);
    }


    // TRATAMENTO DE ERRO DE QUARTOS
    @ResponseBody
    @ExceptionHandler(RoomAlreadyRegisteredException.class)
    public ResponseEntity<RestErrorMessage> roomAlreadyRegistered(RoomAlreadyRegisteredException ex) {
        RestErrorMessage threatMessage = new RestErrorMessage(
                LocalDateTime.now(),
                HttpStatus.CONFLICT,
                ex.getMessage(),
                "It is not possible to register 2 rooms with the same number");
        return ResponseEntity.status(HttpStatus.CONFLICT).body(threatMessage);
    }

    // TRATAMENTO DE ERRO DE PAGAMENTOS
    @ResponseBody
    @ExceptionHandler(AlreadyPaidExeception.class)
    public ResponseEntity<RestErrorMessage> AlreadyPaid(AlreadyPaidExeception exeption ){
        RestErrorMessage threatMessage = new RestErrorMessage(
                LocalDateTime.now(),
                HttpStatus.CONFLICT,
                exeption.getMessage(),
                "Already paid the reservation"
        );
        return  ResponseEntity.status(HttpStatus.CONFLICT).body(threatMessage);
    }


    @ResponseBody
    @ExceptionHandler(PaidNotFoundExeception.class)
    public ResponseEntity<RestErrorMessage> PaidNotFound(PaidNotFoundExeception exeception){
        RestErrorMessage threatMessage = new RestErrorMessage(
                LocalDateTime.now(),
                HttpStatus.NOT_FOUND,
                exeception.getMessage(),"This paid could not be found"
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(threatMessage);
    }

}

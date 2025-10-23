package com.io.github.theus28238.handler;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Setter
public class RestErrorMessage  {

    private LocalDateTime timeStamp;
    private HttpStatus status;
    private String error;
    private String massage;



}



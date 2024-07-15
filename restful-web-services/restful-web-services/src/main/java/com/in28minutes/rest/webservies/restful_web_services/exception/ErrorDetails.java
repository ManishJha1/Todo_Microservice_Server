package com.in28minutes.rest.webservies.restful_web_services.exception;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ErrorDetails {
    private LocalDateTime timestamp;
    private String message;
    private String deails;

    public ErrorDetails(LocalDateTime timestamp, String message, String deails){
        super();
        this.timestamp = timestamp;
        this.message = message;
        this.deails = deails;
    }

    public LocalDateTime getTimestamp(){
        return timestamp;
    }

    public String getMessage(){
        return message;
    }

    public String getDeails(){
        return deails;
    }
}

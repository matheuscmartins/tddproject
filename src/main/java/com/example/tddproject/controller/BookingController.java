package com.example.tddproject.controller;

import com.example.tddproject.model.BookingModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController //sinalizando que ele é um REstController
@RequestMapping("/bookings")
public class BookingController {

    @GetMapping
    @ResponseBody
    public String getAll(){
        return "OK";
    }
    @PostMapping
    public ResponseEntity<BookingModel> save(BookingModel bookingModel){
        return ResponseEntity.status(HttpStatus.OK).body(bookingModel);
    }
}

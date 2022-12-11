package com.example.tddproject.service;

import com.example.tddproject.model.BookingModel;
import com.example.tddproject.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Period;
import java.util.Optional;

@Service
public class BookingService {
    @Autowired
    BookingRepository bookingRepository;
    public int daysCalculatorWithDatabase(String name) {
        Optional<BookingModel> bookingModelOptional = bookingRepository.findByReserveName(name);
        // simula a busca no DB

        return Period.between(bookingModelOptional.get().getCheckIn(), bookingModelOptional.get().getCheckOut()).getDays();
        //pega o periodo em dias para retornar
    }
}

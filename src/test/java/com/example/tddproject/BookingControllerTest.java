package com.example.tddproject;

import com.example.tddproject.model.BookingModel;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import com.fasterxml.jackson.databind.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
public class BookingControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void bookingTestGetAll() throws Exception {
        mockMvc.perform(get("/booking"))
                .andExpect(status().isOk());
    }

    @Test
    public void bookingTestSave() throws Exception {

        LocalDate checkIn = LocalDate.parse("2022-12-10");
        LocalDate checkOut = LocalDate.parse("2022-12-20");

        BookingModel bookingModel = new BookingModel("1", "Matheus", checkIn, checkOut, 2);
        //instacia um bookingModel

        mockMvc.perform(post("/bookings") //test simulando um post para /bookings
                        .contentType("application/json") //tipo json
                        .content(objectMapper.writeValueAsString(bookingModel))) //simular uma instancia objMapper com um json
                .andExpect(status().isOk()); //espera um satus ok
    }
}


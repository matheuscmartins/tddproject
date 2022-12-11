package com.example.tddproject;

import com.example.tddproject.model.BookingModel;
import com.example.tddproject.repository.BookingRepository;
import com.example.tddproject.service.BookingService;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.Optional;

@RunWith(SpringRunner.class) //faz uma ponte entre os recursos do Spring e JUnit
public class BookingServiceTest {

    @TestConfiguration //garante que esse Bean sera usado somente no escopo de teste
    static class BookingServiceTestConfiguration{ //cria um beanserve para retorno o ponto de injeção

        @Bean
        public BookingService bookingService(){
            return  new BookingService();
        }
    }
    @Autowired
    BookingService bookingService; //ponto de injeção

    @MockBean
    BookingRepository bookingRepository;

    @Test
    public void bookingTestServiceDaysCalculator(){
        String name = "Matheus";
        int days = bookingService.daysCalculatorWithDatabase(name);

        Assertions.assertEquals(days, 10);
    }

    @Before //para ser executado antes de tudo
    public void setUp(){ //simula as datas a serem salvas
        LocalDate checkIn = LocalDate.parse("2022-12-10");
        LocalDate checkOut = LocalDate.parse("2022-12-20");
        BookingModel bookingModel = new BookingModel("1","Matheus",checkIn, checkOut,2);

        Mockito.when(bookingRepository.findByReserveName(bookingModel.getReserveName()))
                .thenReturn(java.util.Optional.of(bookingModel)); //simula um repository
    }

}

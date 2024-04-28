package codoacodo.vuelosapi.utils;

import codoacodo.vuelosapi.models.Flight;
import codoacodo.vuelosapi.models.FlightDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class FlightUtilsTest {

    @Autowired
    FlightUtils flightUtils;

    @Test
    void detectOffersTest() {
        List<Flight> flightList = new ArrayList<>();

        Flight flight1 = new Flight(1L, "EZE", "COR", "08:00", "10:00", 100.0, "Daily");
        Flight flight2 = new Flight(2L, "MIA", "NYC", "12:00", "14:00", 200.0, "Weekly");
        Flight flight3 = new Flight(3L, "LAX", "SFO", "09:30", "11:30", 150.0, "Daily");

        flightList.add(flight1);
        flightList.add(flight2);
        flightList.add(flight3);

        // Utilizamos FlightUtils para detectar ofertas
        FlightUtils flightUtils = new FlightUtils();
        List<Flight> offers = flightUtils.detectOffers(flightList, 100);

        // Verificamos que se detecten las ofertas esperadas
        assertEquals(2, offers.size()); // Suponiendo que hay dos ofertas en la lista proporcionada
        // Puedes agregar más aserciones según lo que esperes de tu método detectOffers
    }
    @BeforeEach
    public void setUp(){
        List<Flight> flightList;
        List<FlightDto> flightDtoList;
    }

    @Test
    void flightMapperTest() {
        double dolarPrice = 1015;
        List<Flight> flightList = new ArrayList<>();
        List<FlightDto> flightDtoList = new ArrayList<>();

        Flight flight = new Flight();
        flight.setId(1L);
        flight.setOrigin("COR");
        flight.setDestiny("EZE");
        flight.setArrivingTime("SomeDate");
        flight.setArrivingTime("AnotherDate");
        flight.setPrice(100);
        flight.setFrequency("Weekly");

        flightList.add(flight);


        flightDtoList = flightUtils.flightMapper(flightList, dolarPrice);

        FlightDto flightDto = flightDtoList.get(0);

        assertEquals(1, flightDto.getId());
        assertEquals(flight.getPrice() * dolarPrice, flightDto.getConvertedPrice());
    }
}
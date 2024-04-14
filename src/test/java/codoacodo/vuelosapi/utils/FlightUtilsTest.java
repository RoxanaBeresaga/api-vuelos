package codoacodo.vuelosapi.utils;

import codoacodo.vuelosapi.models.Flight;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


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
}
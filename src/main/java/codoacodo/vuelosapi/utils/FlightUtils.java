package codoacodo.vuelosapi.utils;

import codoacodo.vuelosapi.models.Flight;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class FlightUtils {

    public List<Flight> detectOffers(List<Flight> flights, Integer offerPrice) {
       /* List<Flight> offers = new ArrayList<>();

        for (Flight flight : flights){
            if(flight.getPrice() < offerPrice){
                offers.add(flight);
            }
        }
        return offers; */
        return flights.stream()
                .filter(flight -> flight.getPrice() < offerPrice)
                .collect(Collectors.toList());
    }
}

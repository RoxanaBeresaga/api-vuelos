package codoacodo.vuelosapi.services;

import codoacodo.vuelosapi.configuration.FlightConfiguration;
import codoacodo.vuelosapi.models.Dolar;
import codoacodo.vuelosapi.models.Flight;
import codoacodo.vuelosapi.repository.FlightRepository;
import codoacodo.vuelosapi.utils.FlightUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class FlightService {

    @Autowired
    FlightRepository flightRepository;
    @Autowired
    FlightUtils flightUtils;

    @Autowired
    FlightConfiguration flightConfiguration;

    public void createFlight(Flight flight){

        flightRepository.save(flight);
    }

    public Optional<Flight> findFlightById(Long id) {

        return flightRepository.findById(id);
    }

    public void deleteFlightById(Long id) {

        flightRepository.deleteById(id);
    }

    public List<Flight> getAllFlights(){

        return flightRepository.findAll();
    }

    public Optional<Flight> update(Flight flight) {

        flightRepository.save(flight);
        return flightRepository.findById(flight.getId());
    }

    public List<Flight> getByOrigin(String origin) {
        return flightRepository.findByOrigin(origin);
    }

    public List<Flight> getByOriginAndDestiny(String origin,String destiny) {
        return flightRepository.findByOriginAndDestiny(origin,destiny);
    }

    public List<Flight> getOffers(Integer offerPrice) {
        List<Flight> flights = flightRepository.findAll();
        return flightUtils.detectOffers(flights, offerPrice);
    }
    /*
    public Dolar getDolar() {
        return flightConfiguration.fetchDolar();
    }
     */

    public double getDolar() {
        return flightConfiguration.fetchDolar().getPromedio();
    }
}


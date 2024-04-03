package codoacodo.vuelosapi.services;

import codoacodo.vuelosapi.models.Flight;
import codoacodo.vuelosapi.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class FlightService {

    @Autowired
    FlightRepository flightRepository;

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
}


package codoacodo.vuelosapi.controller;

import codoacodo.vuelosapi.models.Flight;
import codoacodo.vuelosapi.services.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/flights")
public class FlightController {

    @Autowired
    FlightService flightService;

    @PostMapping("/add")
    public void createFlight(@RequestBody Flight flight){

        flightService.createFlight(flight);
    }

    @GetMapping("/{id}")
    public Optional<Flight> findFlightById(@PathVariable Long id) {

        return flightService.findFlightById(id);
    }

    @DeleteMapping("/eliminate/{id}")

    public void deleteFlight(@PathVariable Long id) {

        flightService.deleteFlightById(id);
    }

    @GetMapping("")
    public List<Flight> getAllFlights() {

        return flightService.getAllFlights();
    }

    @PutMapping("/update")
    public Optional<Flight> updateFlight(@RequestBody Flight flight){

        return flightService.update(flight);
    }
}

package codoacodo.vuelosapi.controller;

import codoacodo.vuelosapi.models.Dolar;
import codoacodo.vuelosapi.models.Flight;
import codoacodo.vuelosapi.models.FlightDto;
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
    public Flight createFlight(@RequestBody Flight flight, @RequestParam Long companyId){
        return flightService.createFlight(flight, companyId);
    }

    @GetMapping("/{id}")
    public Optional<Flight> findFlightById(@PathVariable Long id) {

        return flightService.findFlightById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteFlight(@PathVariable Long id) {

        flightService.deleteFlightById(id);
    }

    @GetMapping("")
    public List<FlightDto> getAllFlights() {

        return flightService.allFlights();
    }

    @PutMapping("/update")
    public Optional<Flight> updateFlight(@RequestBody Flight flight){

        return flightService.update(flight);
    }

    @GetMapping("/origin")
    public List<Flight> getFlightsByLocations(@RequestParam String origin) {

        return flightService.getByOrigin(origin);
    }

    @GetMapping("/offers")
    public List<Flight> getOffers() {
        Integer offerPrice = 200;
        return flightService.getOffers(offerPrice);
    }


    @GetMapping("/locations")
    public List<Flight> getFlightsByLocations(@RequestParam String origin,@RequestParam String destiny) {
        return flightService.getByOriginAndDestiny(origin,destiny);
    }

    @GetMapping("/dolar")
    public Dolar getDolar() {
        return flightService.getDolar();
    }

    @GetMapping("/dolarprice")
    public double getDolarPrice() {

        return flightService.getDolarPrice();
    }

    @GetMapping("/allDolars")
    public List<Dolar> getAllDolars() {
        return flightService.getAllDolars();
    }

}

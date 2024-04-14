package codoacodo.vuelosapi.repository;

import static org.assertj.core.api.Assertions.assertThat;

import codoacodo.vuelosapi.models.Flight;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class FlightRepositoryTest {

    @Autowired
    private FlightRepository flightRepository;

    private Flight flight;

    @BeforeEach
    void setup() {
        flightRepository.deleteAll(); // Limpiar la base de datos
        flight = new Flight("COR", "AEP", "8.00","11.00",200.0,"Diaria");
    }

    @Test
    void saveFlightTest(){

        Flight flightDB = flightRepository.save(flight);

       assertThat(flightDB).isNotNull();
       assertThat(flightDB.getId()).isGreaterThan(0);

    }

    @Test
    void flightFindByIdTest() {

        flightRepository.save(flight);


        Flight flightDB = flightRepository.findById(flight.getId()).get();

        assertThat(flightDB).isNotNull();

    }

    @Test
    void flightFindAllTest() {

        Flight flight2 = new Flight("MAD", "COR", "8.00","11.00",200.0,"Diaria");

        flightRepository.save(flight);
        flightRepository.save(flight2);

        List<Flight> flightList = flightRepository.findAll();
        assertThat(flightList).isNotNull();
        assertThat(flightList.size()).isEqualTo(2);
    }

    @Test
    void flightDeleteById(){

        flightRepository.save(flight);

        flightRepository.deleteById(flight.getId());

        Optional<Flight> deleteFlight = flightRepository.findById(flight.getId());

        assertThat(deleteFlight).isEmpty();
    }

    @Test
    void flightUpdateTest(){
        flightRepository.save(flight);
        Flight flightDB = flightRepository.findById(flight.getId()).get();

        flight.setOrigin("GRU");
        flight.setDestiny("EZE");

        Flight flightUpdate = flightRepository.save(flightDB);

        assertThat(flightUpdate.getOrigin()).isEqualTo("GRU");
        assertThat(flightUpdate.getDestiny()).isEqualTo("EZE");


    }
}

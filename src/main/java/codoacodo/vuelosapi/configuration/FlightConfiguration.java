package codoacodo.vuelosapi.configuration;

import codoacodo.vuelosapi.models.Dolar;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Configuration
public class FlightConfiguration {

    @Bean
    public RestTemplate restTemplate(){

        return new RestTemplate();
    }

    public Dolar fetchDolar(){
        RestTemplate restTemplate = restTemplate();
        String apiUrl = "https://dolarapi.com/v1/dolares/tarjeta";
        return restTemplate.getForObject(apiUrl,Dolar.class);
    }
    public Dolar[] fetchAllDollars() {
        RestTemplate restTemplate = restTemplate();
        String apiUrl = "https://dolarapi.com/v1/dolares";
        return restTemplate.getForEntity(apiUrl,Dolar[].class).getBody();
    }
}

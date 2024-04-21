package codoacodo.vuelosapi.models;

import lombok.Data;

@Data
public class FlightDto {
    private Long id;
    private String origin;
    private String destiny;
    private String departureTime;
    private String arrivingTime;
    private double convertedPrice;
}

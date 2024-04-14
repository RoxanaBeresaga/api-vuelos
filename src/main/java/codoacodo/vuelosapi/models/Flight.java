package codoacodo.vuelosapi.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Flight {
   @Getter
   @Id
   @GeneratedValue(strategy=GenerationType.AUTO)
   private Long id;
   private String origin;
   private String destiny;
   private String departureTime;
   private String arrivingTime;
   @Getter
   private double price;
   private String frequency;

   public Flight(String origin, String destiny, String departureTime, String arrivingTime, double price, String frequency) {
      this.origin = origin;
      this.destiny = destiny;
      this.departureTime = departureTime;
      this.arrivingTime = arrivingTime;
      this.price = price;
      this.frequency = frequency;
   }

}

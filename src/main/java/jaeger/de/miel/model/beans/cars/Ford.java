package jaeger.de.miel.model.beans.cars;

import lombok.Getter;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Component
@ToString
public class Ford extends Car {
    @Getter
    private String brand = "Ford";
}

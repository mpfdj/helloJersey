package jaeger.de.miel.model.beans.bicycles;

import lombok.ToString;
import org.springframework.stereotype.Component;

@Component
@ToString
public class TrekMini extends Trek {
    private String brand = "Trek mini";
}

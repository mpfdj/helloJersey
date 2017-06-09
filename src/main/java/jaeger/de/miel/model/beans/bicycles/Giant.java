package jaeger.de.miel.model.beans.bicycles;

import lombok.ToString;
import org.springframework.stereotype.Component;

@Component
@ToString
public class Giant implements Bicycle {
    private String brand = "Giant";
}

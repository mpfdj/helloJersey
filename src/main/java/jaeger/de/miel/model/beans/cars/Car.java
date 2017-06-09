package jaeger.de.miel.model.beans.cars;

import lombok.ToString;
import org.springframework.stereotype.Component;

@Component
@ToString
public class Car {
    private String brand = "This is the generic car class.";

    public void startEngine() {
        System.out.println("Starting engine.");
    }

    public void stopEngine() {
        System.out.println("Stopping engine.");
    }

    public void steerLeft() {
        System.out.println("Steering left.");
    }

    public void steerRight() {
        System.out.println("Steering right.");
    }

    public void shiftGear() {
        System.out.println("Shifting gear.");
    }

    public void accelerating() {
        System.out.println("Accelerating.");
    }

    public void breaking() {
        System.out.println("Breaking.");
    }
}

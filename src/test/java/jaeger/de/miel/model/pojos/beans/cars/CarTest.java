package jaeger.de.miel.model.pojos.beans.cars;

import jaeger.de.miel.configuration.SpringConfig;
import jaeger.de.miel.model.beans.cars.Car;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class CarTest {

    @Resource
    private List<Car> cars;

    @Test
    public void test() {
        System.out.println("My car collection: " + cars);

        for (Car car : cars) {
            System.out.println(car.getClass().getSimpleName() + " is modelled in class: " + car.getClass());

            // Skip the superclass Car here (do car specific stuff here...)
            // Hmmmm looks like this is not possible
            // using instanceof or Car.class.isInstance(car)

//            if (car instanceof Car) {
//
//            }
        }
    }

}

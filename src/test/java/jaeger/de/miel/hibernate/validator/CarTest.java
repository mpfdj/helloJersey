package jaeger.de.miel.hibernate.validator;

import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import jaeger.de.miel.hibernate.validator.Car;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CarTest {



    @Test
    public void test() {
        assertTrue(true);
    }


    private static Validator validator;

    @BeforeClass
    public static void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void manufacturerIsNull() {
        Car car = new Car(null, "DD-AB-123", 4);
        Set<ConstraintViolation<Car>> constraintViolations = validator.validate(car);
        assertEquals(1, constraintViolations.size());
        assertEquals("may not be null", constraintViolations.iterator().next().getMessage());

        System.out.println(constraintViolations);

    }

//    @Test
//    public void licensePlateTooShort() {
//        Car car = new Car("Morris", "D", 4);
//        Set<ConstraintViolation<Car>> constraintViolations = validator.validate(car);
//        assertEquals(1, constraintViolations.size());
//        assertEquals("size must be between 2 and 14", constraintViolations.iterator().next().getMessage());
//    }
//
//    @Test
//    public void seatCountTooLow() {
//        Car car = new Car("Morris", "DD-AB-123", 1);
//        Set<ConstraintViolation<Car>> constraintViolations = validator.validate(car);
//        assertEquals(1, constraintViolations.size());
//        assertEquals("must be greater than or equal to 2", constraintViolations.iterator().next().getMessage());
//    }
//
//    @Test
//    public void carIsValid() {
//        Car car = new Car("Morris", "DD-AB-123", 2);
//        Set<ConstraintViolation<Car>> constraintViolations = validator.validate(car);
//        assertEquals(0, constraintViolations.size());
//    }

//    @Test
//    public void jaeger.de.miel.test.test() {
//        Car car = new Car("Ford", "ZN-25-SP", 0);
//        Set<ConstraintViolation<Car>> constraintViolations = validator.validate(car);
//        assertEquals(0, constraintViolations.size());
//    }
}
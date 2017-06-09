package jaeger.de.miel.model.pojos.beans.bicycles;

import jaeger.de.miel.configuration.SpringConfig;
import jaeger.de.miel.model.beans.bicycles.Bicycle;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class BicycleTest {

    @Resource
    List<Bicycle> bicycles;  // All bicycles are injected by the spring container isn't this amazing!

    @Test
    public void test() {

        // See CarTest

        for(Bicycle bicycle: bicycles) {
            System.out.println(bicycle);
        }

    }
}

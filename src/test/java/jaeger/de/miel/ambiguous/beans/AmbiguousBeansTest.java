package jaeger.de.miel.ambiguous.beans;

//import jaeger.de.miel.ambiguous.beans.a.Hello;
//import jaeger.de.miel.ambiguous.beans.b.Hello;
import jaeger.de.miel.configuration.SpringConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class AmbiguousBeansTest {

    @Autowired
    jaeger.de.miel.ambiguous.beans.a.Hello helloA;

    @Autowired
    jaeger.de.miel.ambiguous.beans.b.Hello helloB;

    @Test
    public void ambiguousBeanTest() {
        assertThat(helloA.sayHello(), is("helloA"));
        assertThat(helloB.sayHello(), is("helloB"));
    }
}

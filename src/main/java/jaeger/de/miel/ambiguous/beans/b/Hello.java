package jaeger.de.miel.ambiguous.beans.b;

import org.springframework.stereotype.Component;

//@Service
//@Repository
//@Controller
@Component("helloB")
public class Hello {

    public String sayHello() {
        return "helloB";
    }
}

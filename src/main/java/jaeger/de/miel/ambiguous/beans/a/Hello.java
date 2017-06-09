package jaeger.de.miel.ambiguous.beans.a;

import org.springframework.stereotype.Component;

@Component("helloA")
public class Hello {

    public String sayHello() {
        return "helloA";
    }

}

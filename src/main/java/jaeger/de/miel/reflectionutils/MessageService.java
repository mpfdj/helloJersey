package jaeger.de.miel.reflectionutils;

import org.jvnet.hk2.annotations.Service;

@Service
public class MessageService {
    public String getMessage() {
        return "Hello, ";
    }
}

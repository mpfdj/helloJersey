package jaeger.de.miel.reflectionutils;

import org.jvnet.hk2.annotations.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class MyService {

    @Autowired
    private MessageService messageService;

    public String say(String name) {
        return messageService.getMessage() + name;
    }
}

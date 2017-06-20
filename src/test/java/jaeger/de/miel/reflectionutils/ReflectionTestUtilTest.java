package jaeger.de.miel.reflectionutils;


// http://mrhaki.blogspot.nl/2010/09/private-spring-dependency-injections.html

// We want to unit test MyService and provide a mock implementation for MessageService, so we only test the code in MyService.
// We use Mockito to provide the mock functionality. And because messageService is a private field we must use ReflectionTestUtils.setField() method.

// Spring allows the use of the @Autowired annotation on a private field. And that means we don't have a public setter method.
// We must use org.springframework.test.util.ReflectionTestUtils.setField() to assign a new value to the field.

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.util.ReflectionTestUtils;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ReflectionTestUtilTest {

    @Test
    public void testInjectingAPrivateFieldUsingReflectionTestUtils() {
        MessageService messageService = mock(MessageService.class);
        when(messageService.getMessage()).thenReturn("Hi, ");

        MyService myService = new MyService();
        // Inject mock into private field:
        ReflectionTestUtils.setField(myService, "messageService", messageService);

        assertThat(myService.say("Miel"), is("Hi, Miel"));

    }


}

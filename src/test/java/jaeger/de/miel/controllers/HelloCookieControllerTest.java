package jaeger.de.miel.controllers;

import org.junit.Test;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;

public class HelloCookieControllerTest {


    @Test
    public void test() {

        WebTarget webTarget = ClientBuilder.newClient().target("http://localhost:9292/api/hellojersey");

        final Response response = webTarget
                .path("/hellocookie")
                .request()
                .buildGet()
                .invoke();

        Map<String, NewCookie> cookies = response.getCookies();

        for (Map.Entry<String, NewCookie> cookie : cookies.entrySet()) {
            System.out.println("Cookie: " + cookie.getKey() + " value: " + cookie.getValue());
        }

        assertThat(cookies.get("USERNAME"), is(notNullValue()));
        assertThat(cookies.get("XSRF-TOKEN"), is(notNullValue()));
    }

}


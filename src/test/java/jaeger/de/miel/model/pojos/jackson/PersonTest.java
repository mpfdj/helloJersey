package jaeger.de.miel.model.pojos.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jaeger.de.miel.model.jackson.Person;
import jaeger.de.miel.model.jackson.SwimmingCertificate;
import org.junit.Test;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PersonTest {

    @Test
    public void testMiel() throws JsonProcessingException {
        // @JsonInclude(JsonInclude.Include.NON_NULL)
        // fields with null values are not serialized

        Date dateOfBirth = converToDate("04-07-1980");

        Person person = new Person();
        person.setName("Miel");
        person.setDateOfBirth(dateOfBirth);
        person.setSwimmingCertificate(null);  // Value is not serialized

        ObjectMapper objectMapper = new ObjectMapper();
        System.out.println(objectMapper.writeValueAsString(person));
    }

    @Test
    public void testKim() throws JsonProcessingException {
        Date dateOfBirth = converToDate("24-08-2009");
        Person person = Person.of("Kim", dateOfBirth, SwimmingCertificate.C);
        ObjectMapper objectMapper = new ObjectMapper();
        System.out.println(objectMapper.writeValueAsString(person));
    }

    @Test
    public void testDeserializeStringToObject() throws IOException {
        // @JsonIgnoreProperties(ignoreUnknown = true)
        // unknown json field are ignored
        // UnrecognizedPropertyException: Unrecognized field "dummy"
        String json = "{\"name\":\"Miel\",\"dateOfBirth\":\"04-07-1980\", \"dummy\":\"dummy\"}";
        ObjectMapper objectMapper = new ObjectMapper();

        Person person = objectMapper.readValue(json, Person.class);
        System.out.println(person.toString());
    }

    private Date converToDate(String dateString) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date date = null;
        try {
            date = simpleDateFormat.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

}

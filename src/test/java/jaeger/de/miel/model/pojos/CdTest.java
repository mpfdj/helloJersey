package jaeger.de.miel.model.pojos;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jaeger.de.miel.model.pojos.Cd;
import org.junit.Test;

public class CdTest {

    @Test
    public void printCdJsonFormat() {

        Cd cd1 = new Cd();
        cd1.setArtist("Nirvana");
        cd1.setCatalogId(3214982);  // this field is ignored!
        cd1.setGenre("Grunge");
        cd1.setTitle("MTV unplugged New York");

        Cd cd2 = new Cd();
        cd2.setArtist("Nirvana");
        cd2.setCatalogId(245788753);  // this field is ignored!
        cd2.setGenre("Grunge");
        cd2.setTitle("Nevermind");

        Cd cd3 = new Cd();
        cd3.setArtist("Nirvana");
        cd3.setCatalogId(5365234);  // this field is ignored!
        cd3.setGenre("Grunge");
        cd3.setTitle("In Utero");

        try {
            System.out.println(new ObjectMapper().writeValueAsString(cd1));
            System.out.println(new ObjectMapper().writeValueAsString(cd2));
            System.out.println(new ObjectMapper().writeValueAsString(cd3));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testInvalidCd() {

        Cd cd = new Cd();
        cd.setArtist("Nirvana");
    }

}

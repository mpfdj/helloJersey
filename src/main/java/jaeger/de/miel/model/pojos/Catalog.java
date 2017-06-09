package jaeger.de.miel.model.pojos;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;


@ToString
public class Catalog {

    @Getter
    @Setter
    private String name;

    @Getter
    private List<Cd> cds;

    public Catalog() {
        cds = new ArrayList<>();
    }

    public void addCd(Cd cd) {
        cds.add(cd);
    }
}

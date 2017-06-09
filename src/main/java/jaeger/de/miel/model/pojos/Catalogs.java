package jaeger.de.miel.model.pojos;

import lombok.Getter;
import lombok.ToString;

import java.util.HashMap;
import java.util.Map;

@ToString
public class Catalogs {

    @Getter
    private Map<String, Catalog> catalogs;

    public Catalogs() { catalogs = new HashMap<>(); }
    public void addCatalog(Catalog catalog){
        catalogs.put(catalog.getName(), catalog);
    }

}

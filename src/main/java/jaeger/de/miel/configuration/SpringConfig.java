package jaeger.de.miel.configuration;

import jaeger.de.miel.model.pojos.Catalog;
import jaeger.de.miel.model.pojos.Catalogs;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("jaeger.de.miel")
public class SpringConfig {

    // ------------------------------------
    // Bean definitions go here!!!
    // ------------------------------------

    @Bean
    public Catalog catalog() {
        Catalog catalog = new Catalog();
        catalog.setName("test");
        return catalog;
    }


    // No qualifying bean of type [jaeger.de.miel.model.pojos.Catalog] is defined: expected single matching bean but found 2: catalog,catalog2
/*    @Bean
    public Catalog catalog2() {
        Catalog catalog = new Catalog();
        catalog.setName("test");
        return catalog;
    }*/

    @Bean
    public Catalogs catalogs() {
        Catalogs catalogs = new Catalogs();

        Catalog miel = new Catalog();
        miel.setName("miel");
        catalogs.addCatalog(miel);

        Catalog kim = new Catalog();
        kim.setName("kim");
        catalogs.addCatalog(kim);

        Catalog bella = new Catalog();
        bella.setName("bella");
        catalogs.addCatalog(bella);

        return catalogs;
    }

}
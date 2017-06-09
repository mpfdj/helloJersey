package jaeger.de.miel.configuration;

import jaeger.de.miel.model.pojos.Catalog;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertNotNull;


public class SpringConfigTest {

    private static AnnotationConfigWebApplicationContext context;

    @BeforeClass
    public static void setUp() {
        context = new AnnotationConfigWebApplicationContext();
        context.register(SpringConfig.class);
        context.refresh();
    }

    @Test
    public void test() {
        Catalog catalog = context.getBean(Catalog.class);
        assertNotNull(catalog);
    }

    @Test
    public void printContext() {
        List<String> names = new ArrayList<String>(Arrays.asList(context.getBeanDefinitionNames()));
        Collections.sort(names);

        int i = 1;
        for (String name : names) {
            System.out.println(i + ": " + name);
            i++;
        }

    }

    @Test
    public void printConfig() {
        SpringConfig springConfig = (SpringConfig) context.getBean("springConfig");

    }

}

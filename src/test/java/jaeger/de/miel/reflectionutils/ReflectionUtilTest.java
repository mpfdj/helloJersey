package jaeger.de.miel.reflectionutils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.junit.Test;
import org.springframework.util.ReflectionUtils;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@Getter
@Setter
@AllArgsConstructor
@ToString
class Person {
    String name;
    @Dummy
    int age;
}

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface Dummy {
}

public class ReflectionUtilTest {

    public <T> void isACollectionTest(T obj) {
        System.out.println(obj.getClass());

        if (Collection.class.isAssignableFrom(obj.getClass())) {
            System.out.println("Is a Collection.");
        } else {
            System.out.println("Is an Object.");
        }
    }

    public <T> void printFields(T obj) {

        ReflectionUtils.FieldCallback fc = new ReflectionUtils.FieldCallback() {
            @Override
            public void doWith(Field field) throws IllegalArgumentException, IllegalAccessException {
                System.out.println("field: " + field);
                System.out.println("field name: " + field.getName());
                System.out.println("field type: " + field.getType());
                System.out.println();

            }
        };

        ReflectionUtils.doWithFields(obj.getClass(), fc);
    }

    public <T> void printFieldsWithFilter(T obj) {

        ReflectionUtils.FieldCallback fc = new ReflectionUtils.FieldCallback() {
            @Override
            public void doWith(Field field) throws IllegalArgumentException, IllegalAccessException {
                System.out.println(field);
            }
        };

        ReflectionUtils.FieldFilter ff = new ReflectionUtils.FieldFilter() {
            @Override
            public boolean matches(Field field) {
                return field.getName().equals("name");
            }
        };

        ReflectionUtils.doWithFields(obj.getClass(), fc, ff);
    }


    public <T> void printFieldsWithAnnotationFilter(T obj) {

        // Java 7 doesn't support lambda's so we do it the old fashioned way...
        ReflectionUtils.FieldCallback fc = new ReflectionUtils.FieldCallback() {
            @Override
            public void doWith(Field field) throws IllegalArgumentException, IllegalAccessException {
                System.out.println(field);
            }
        };

        ReflectionUtils.FieldFilter ff = new ReflectionUtils.FieldFilter() {
            @Override
            public boolean matches(Field field) {
                return field.isAnnotationPresent(Dummy.class);
            }
        };

        ReflectionUtils.doWithFields(obj.getClass(), fc, ff);
    }

    @Test
    public void testIsACollection() {
        List<String> myList = new ArrayList<>();
        isACollectionTest(myList);
    }

    @Test
    public void testPrintFields() {
        Person p = new Person("Miel", 37);
        printFields(p);
    }

    @Test
    public void testPrintFieldsWithFilter() {
        Person p = new Person("Miel", 37);
        printFieldsWithFilter(p);
    }

    @Test
    public void testPrintFieldsWithAnnotationFilter() {
        Person p = new Person("Miel", 37);
        printFieldsWithAnnotationFilter(p);
    }

    @Test
    public void testSetField() {

        // Get fields
        Field name = ReflectionUtils.findField(Person.class, "name");
        Field age = ReflectionUtils.findField(Person.class, "age");

        // Make fields accessible
        ReflectionUtils.makeAccessible(name);
        ReflectionUtils.makeAccessible(age);

        Person p = new Person("Miel", 37);

        assertThat(p.name, is("Miel"));
        assertThat(p.age, is(37));

        ReflectionUtils.setField(name, p, "Kim");
        ReflectionUtils.setField(age, p, 7);

        assertThat(p.name, is("Kim"));
        assertThat(p.age, is(7));
    }

}

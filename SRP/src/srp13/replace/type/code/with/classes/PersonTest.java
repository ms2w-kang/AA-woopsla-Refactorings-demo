package srp13.replace.type.code.with.classes;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class PersonTest {
    @Test
    public void testTwoPersonsWithSameGroup() throws Exception {
        Person tom = new Person(Person.A);
        Person jerry = new Person(Person.A);

        assertTrue(tom.getBloodGroup() == jerry.getBloodGroup());
    }

    @Test
    public void testTwoPersonsWithDifferentGroups() throws Exception {
        Person tom = new Person(Person.A);
        Person jerry = new Person(Person.B);

        assertTrue(tom.getBloodGroup() != jerry.getBloodGroup());
    }
}

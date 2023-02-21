package ba.unsa.etf.rpr.domain;

import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;

public class DomainTest {

    @Test
    public void testSetterGetter1() {
        User user = new User();
        user.setId(6);
        user.setFirstName("Selma");
        user.setLastName("Selmic");
        user.setUsername("selma123");
        user.setPassword("sunceimore");

        assertEquals(6, user.getId());
        assertEquals("Selma",user.getFirstName());
        assertEquals("Selmic",user.getLastName());
        assertEquals("selma123",user.getUsername());
        assertEquals("sunceimore",user.getPassword());
    }
    @Test
    public void testSetterGetter2() {
        Book book = new Book();
        book.setId(7);
        book.setTitle("Tisine");
        book.setAuthor("Mesa Selimovic");
        book.setNumberOfCopies(6);
        book.setAvailableCopies(6);

        assertEquals(7, book.getId());
        assertEquals("Tisine",book.getTitle());
        assertEquals("Mesa Selimovic",book.getAuthor());
        assertEquals(6,book.getNumberOfCopies());
        assertEquals(6,book.getAvailableCopies());
    }

}

package attractions;

import org.junit.Before;
import org.junit.Test;
import people.Visitor;

import static org.junit.Assert.assertEquals;

public class DodgemTest {

    Dodgems dodgems;
    Visitor visitor1;
    Visitor visitor2;
    Visitor visitor3;


    @Before
    public void setUp() throws Exception {
        dodgems = new Dodgems("Bumper Cars", 5);
        visitor1 = new Visitor(11, 150, 15.0);
        visitor2 = new Visitor(12, 146, 15.0);
        visitor3 = new Visitor(13, 146, 15.0);
    }


    @Test
    public void hasName() {
        assertEquals("Bumper Cars", dodgems.getName());
    }

    @Test
    public void hasRating() {
        assertEquals(5, dodgems.getRating());
    }

    @Test
    public void hasVisitCount() {
        assertEquals(0, dodgems.getVisitCount());
    }
    @Test
    public void chargesHalfPriceForChildrenUnder12() {
        assertEquals(2.25, dodgems.priceFor(visitor1), 0.01);
    }
    @Test
    public void chargesFullPriceForChildrenWhoAre12() {
        assertEquals(4.5, dodgems.priceFor(visitor2), 0.01);
    }
    @Test
    public void chargesFullPriceForChildrenOver12() {
        assertEquals(4.5, dodgems.priceFor(visitor3),0.01);
    }
}

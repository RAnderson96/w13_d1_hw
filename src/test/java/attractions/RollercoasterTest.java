package attractions;

import org.junit.Before;
import org.junit.Test;
import people.Visitor;

import static org.junit.Assert.assertEquals;

public class RollercoasterTest {

    RollerCoaster rollerCoaster;
    Visitor visitor1;
    Visitor visitor2;
    Visitor visitor3;
    Visitor visitor4;
    Visitor visitor5;
    Visitor visitor6;
    Visitor visitor7;

    @Before
    public void setUp() {
        rollerCoaster = new RollerCoaster("Blue Ridge", 10);
        visitor1 = new Visitor(13, 150, 15.0);
        visitor2 = new Visitor(14, 146, 15.0);
        visitor3 = new Visitor(13, 146, 15.0);
        visitor4 = new Visitor(12, 150, 15.0);
        visitor5 = new Visitor(13, 145, 15.0);
        visitor6 = new Visitor(13, 201, 15.0);
        visitor7 = new Visitor(13, 200, 15.0);
    }

    @Test
    public void hasName() {
        assertEquals("Blue Ridge", rollerCoaster.getName());
    }

    @Test
    public void hasRating() {
        assertEquals(10, rollerCoaster.getRating());
    }

    @Test
    public void hasVisitCount() {
        assertEquals(0, rollerCoaster.getVisitCount());
    }

    @Test
    public void canGoOnRideIf13AndIs150CMTall(){
        assertEquals(true, rollerCoaster.isAllowedTo(visitor1));
    }
    @Test
    public void canGoOnRideIf14And146Tall(){
        assertEquals(true, rollerCoaster.isAllowedTo(visitor2));
    }
    @Test
    public void canGoOnRideIf13AND146Tall(){
        assertEquals(true, rollerCoaster.isAllowedTo(visitor3));
    }
    @Test
    public void cannotGoOnRideIf12And150Tall(){
        assertEquals(false, rollerCoaster.isAllowedTo(visitor4));
    }
    @Test
    public void cannotGoOnRideIf13And145Tall(){
        assertEquals(false, rollerCoaster.isAllowedTo(visitor5));
    }
    @Test
    public void chargesTallPeopleOver200CMDouble(){
        assertEquals(16.80, rollerCoaster.priceFor(visitor6),0.01);
    }
    @Test
    public void chargesPeople200CMDefaultPrice(){
        assertEquals(8.40, rollerCoaster.priceFor(visitor7),0.01);
    }


}

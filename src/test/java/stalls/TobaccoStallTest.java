package stalls;

import org.junit.Before;
import org.junit.Test;
import people.Visitor;

import static org.junit.Assert.assertEquals;

public class TobaccoStallTest {

    TobaccoStall tobaccoStall;
    Visitor visitor1;
    Visitor visitor2;
    Visitor visitor3;

    @Before
    public void setUp() throws Exception {
        tobaccoStall = new TobaccoStall("Jacks Drum", "Jack Jarvis", ParkingSpot.B1, 2);
        visitor1 = new Visitor(19, 125, 15.0);
        visitor2 = new Visitor(18, 125, 15.0);
        visitor3 = new Visitor(16, 125, 15.0);
    }

    @Test
    public void hasName() {
        assertEquals("Jacks Drum", tobaccoStall.getName());
    }

    @Test
    public void hasOwner() {
        assertEquals("Jack Jarvis", tobaccoStall.getOwnerName());
    }

    @Test
    public void hasParkingSpot() {
        assertEquals(ParkingSpot.B1, tobaccoStall.getParkingSpot());
    }

    @Test
    public void returnsTrueForOver18() {
        assertEquals(true, tobaccoStall.isAllowedTo(visitor1));
    }
    @Test
    public void returnsTrueFor18() {
        assertEquals(true, tobaccoStall.isAllowedTo(visitor2));
    }
    @Test
    public void returnsFalseForUnder18() {
        assertEquals(false, tobaccoStall.isAllowedTo(visitor3));
    }

}

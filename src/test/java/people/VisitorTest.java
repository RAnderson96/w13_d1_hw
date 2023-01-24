package people;

import attractions.Dodgems;
import attractions.Park;
import attractions.Playground;
import attractions.RollerCoaster;
import behaviours.IReviewed;
import org.junit.Before;
import org.junit.Test;
import stalls.CandyflossStall;
import stalls.IceCreamStall;
import stalls.ParkingSpot;
import stalls.TobaccoStall;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class VisitorTest {

    Visitor visitor;
    Dodgems dodgems;
    private Playground playground;
    private RollerCoaster rollerCoaster;
    private CandyflossStall candyflossStall;
    private IceCreamStall iceCreamStall;
    private ParkingSpot parkingSpot;
    private TobaccoStall tobaccoStall;

    @Before
    public void before(){
        visitor = new Visitor(14, 1.2, 40.0);
        dodgems = new Dodgems("Dodgey Dans Dodgems", 2);
        playground = new Playground("Playground", 2);
        rollerCoaster = new RollerCoaster("Rollycoaster", 5);

        candyflossStall = new CandyflossStall("Candy Floss Store", "CandyMan", parkingSpot.A1 , 1);
        iceCreamStall = new IceCreamStall("Ice Cream Store", "Bob", parkingSpot.A2,2);
        tobaccoStall = new TobaccoStall("Tobacco 4 kids", "Dodgy Dan", parkingSpot.A4, 3);

    }

    @Test
    public void hasAge() {
        assertEquals(14, visitor.getAge());
    }

    @Test
    public void hasHeight() {
        assertEquals(1.2, visitor.getHeight(), 0.1);
    }

    @Test
    public void hasMoney() {
        assertEquals(40.0, visitor.getMoney(), 0.1);
    }

    @Test
    public void canAddVisitedAttraction(){
        visitor.addVisitedAttraction(dodgems);
        visitor.addVisitedAttraction(rollerCoaster);
        ArrayList<IReviewed> returnedVisitedItems = new ArrayList<>(Arrays.asList(dodgems, rollerCoaster));
        assertEquals(returnedVisitedItems, visitor.getVisitedAttractions());
    }
}

import attractions.Dodgems;
import attractions.Park;
import attractions.Playground;
import attractions.RollerCoaster;
import behaviours.IReviewed;
import behaviours.ISecurity;
import org.junit.Before;
import org.junit.Test;
import people.Visitor;
import stalls.CandyflossStall;
import stalls.IceCreamStall;
import stalls.ParkingSpot;
import stalls.TobaccoStall;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

import static org.junit.Assert.assertEquals;


public class ThemeParkTest {

    private ThemePark themePark;
    private Visitor visitor;
    private Visitor visitor2;
    private Visitor visitor3;
    private Dodgems dodgems;
    private Park park;
    private Playground playground;
    private RollerCoaster rollerCoaster;
    private CandyflossStall candyflossStall;
    private IceCreamStall iceCreamStall;
    private ParkingSpot parkingSpot;
    private TobaccoStall tobaccoStall;
    private ArrayList<IReviewed> attractionsAndStalls;





    @Before
    public void setUp() {
        themePark = new ThemePark();
        visitor = new Visitor(19,126, 20.0 );
        dodgems = new Dodgems("Bob", 5);
        park = new Park("Park", 4);
        playground = new Playground("Playground", 2);
        rollerCoaster = new RollerCoaster("Rollycoaster", 5);

        candyflossStall = new CandyflossStall("Candy Floss Store", "CandyMan", parkingSpot.A1,2);
        iceCreamStall = new IceCreamStall("Ice Cream Store", "Bob", parkingSpot.A2,3);

        tobaccoStall = new TobaccoStall("Tobacco 4 kids", "Dodgy Dan", parkingSpot.A4,4);
        attractionsAndStalls = new ArrayList<>(Arrays.asList(dodgems, park, playground, rollerCoaster, candyflossStall, iceCreamStall, tobaccoStall));
        themePark.setAttractionsAndStalls(attractionsAndStalls);
    }

    @Test
    public void canStoreAllAttractionsAndStalls(){

        assertEquals(attractionsAndStalls, themePark.getAttractionsAndStalls() );
    }
    @Test
    public void canGetAllReviewedAttractions(){
//        ArrayList<IReviewed> reviewedAttractionsAndStalls = new ArrayList<>(Arrays.asList(dodgems, park, playground, rollerCoaster, candyflossStall, iceCreamStall, tobaccoStall));
        assertEquals( attractionsAndStalls , themePark.getAllReviewed() );
    }

    @Test
    public void canIncrementVisitCountandAddAttractionToVisitedAttractions(){
        themePark.visit(visitor, dodgems);
        ArrayList<IReviewed> visitedAttractions = new ArrayList<>(Arrays.asList(dodgems));
        assertEquals(visitedAttractions, visitor.getVisitedAttractions());
        assertEquals(1, dodgems.getVisitCount());
        assertEquals(1, visitor.getVisitedAttractions().size());

    }

    @Test
    public void canIncrementVisitCountandAddAttractionToVisitedMultipleAttractions(){
        themePark.visit(visitor, dodgems);
        themePark.visit(visitor, dodgems);
        themePark.visit(visitor, rollerCoaster);
        ArrayList<IReviewed> visitedAttractions = new ArrayList<>(Arrays.asList(dodgems, dodgems, rollerCoaster ));
        assertEquals(visitedAttractions, visitor.getVisitedAttractions());
        assertEquals(2, dodgems.getVisitCount());
        assertEquals(1, rollerCoaster.getVisitCount());
        assertEquals(3, visitor.getVisitedAttractions().size());

    }

    @Test
    public void canReturnHashMapContainingAllReviews(){



        themePark.createReviewHashMap();
        assertEquals(7, themePark.getReviewHashMap().size());
        assertEquals(5, themePark.getReviewHashMap().get("Bob").intValue());
    }

    @Test
    public void canGetALlAllowedForVisitor10YrOldAnd50cm(){
        visitor2 = new Visitor(10,50, 20.0 );
        ArrayList<IReviewed> allowedAttractions = new ArrayList<>(Arrays.asList(dodgems, park, playground, candyflossStall, iceCreamStall));
        ArrayList<ISecurity> restrictedAttractions = new ArrayList<>(Arrays.asList(tobaccoStall, rollerCoaster, playground));

        assertEquals(allowedAttractions, themePark.getAllAllowedForVisitor(visitor2, restrictedAttractions));
    }

    @Test
    public void canGetALlAllowedForVisitor18And2M(){
        visitor3 = new Visitor(18,200, 20.0 );
        ArrayList<IReviewed> allowedAttractions = new ArrayList<>(Arrays.asList(dodgems, park, rollerCoaster, candyflossStall, iceCreamStall, tobaccoStall));
        ArrayList<ISecurity> restrictedAttractions = new ArrayList<>(Arrays.asList(tobaccoStall, rollerCoaster, playground));

        assertEquals(allowedAttractions, themePark.getAllAllowedForVisitor(visitor3, restrictedAttractions));
    }




}

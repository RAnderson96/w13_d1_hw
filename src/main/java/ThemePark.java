import attractions.Dodgems;
import attractions.Playground;
import attractions.RollerCoaster;
import behaviours.IReviewed;
import behaviours.ISecurity;
import behaviours.IVisited;
import people.Visitor;
import stalls.TobaccoStall;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;

public class ThemePark  {

    private ArrayList<IReviewed> AttractionsAndStalls;
    private HashMap<String, Integer> reviewHashMap;
    private ArrayList<ISecurity> restrictedAttractionsAndStalls;

    private TobaccoStall tobaccoStall;
    private RollerCoaster rollerCoaster;
    private Playground playground;

    public ThemePark() {
        this.AttractionsAndStalls = new ArrayList<>();
    }

    public ArrayList<IReviewed> getAllReviewed(){
        ArrayList<IReviewed> reviewList = new ArrayList<>();
        for (IReviewed i : AttractionsAndStalls){
            if (i.getRating() >= 0 ){
                reviewList.add(i);
            }

        }
        return reviewList;
    }

    public ArrayList<IReviewed> getAttractionsAndStalls() {
        return AttractionsAndStalls;
    }

    public void setAttractionsAndStalls(ArrayList<IReviewed> attractionsAndStalls) {
        AttractionsAndStalls = attractionsAndStalls;
    }


    public void visit(Visitor visitor, IVisited iVisited ) {
        visitor.addVisitedAttraction(iVisited);
        iVisited.increaseVisitCount();
    }

    public HashMap<String, Integer> getReviewHashMap() {
        return reviewHashMap;
    }

    public void setReviewHashMap(HashMap<String, Integer> reviewHashMap) {
        this.reviewHashMap = reviewHashMap;
    }

    public HashMap<String, Integer> createReviewHashMap() {
        HashMap<String, Integer> reviewHashMap = new HashMap<>();
        for (IReviewed i : AttractionsAndStalls){
            if (i.getRating() >= 0 ){

                reviewHashMap.put(i.getName(), i.getRating());
            }

        }
        setReviewHashMap(reviewHashMap);
        return reviewHashMap;
    }



    public ArrayList<IReviewed> getAllAllowedForVisitor(Visitor visitor, ArrayList<ISecurity> restrictedAttractionsAndStalls) {

        ArrayList<IReviewed> attractionsAndStallsAllowed = AttractionsAndStalls;

        for (ISecurity i : restrictedAttractionsAndStalls){
            if (!i.isAllowedTo(visitor)){
                attractionsAndStallsAllowed.remove(i);
            }

        }
        return attractionsAndStallsAllowed;
    }
}

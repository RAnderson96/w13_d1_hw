package people;

import attractions.Dodgems;
import behaviours.IReviewed;
import behaviours.ITicketed;
import behaviours.IVisited;

import java.util.ArrayList;

public class Visitor implements ITicketed {

    private int age;
    private double height;
    private double money;
    private ArrayList<IVisited> visitedAttractions;

    public Visitor(int age, double height, double money) {
        this.age = age;
        this.height = height;
        this.money = money;
        this.visitedAttractions = new ArrayList<>();
    }

    public int getAge() {
        return age;
    }

    public double getHeight() {
        return height;
    }

    public double getMoney() {
        return money;
    }

    public double defaultPrice() {
        return 0;
    }

    public double priceFor(Visitor visitor) {
        return 0;
    }

    public ArrayList<IVisited> getVisitedAttractions() {
        return visitedAttractions;
    }

    public void addVisitedAttraction(IVisited iVisited) {
        visitedAttractions.add(iVisited);
    }

//    public void setVisitedAttractions(ArrayList<IReviewed> visitedAttractions) {
//        this.visitedAttractions = visitedAttractions;
//    }


}

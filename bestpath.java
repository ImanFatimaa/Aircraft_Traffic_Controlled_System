package oop_project;

public class Bestpath {
    int length;
    String type;
    int cost;

    public Bestpath(int len, String ty, int cst) {
        length = len;
        type = ty;
        cost = cst;
    }

    public String compare(Bestpath otherObject) {
       
    	if (cost < otherObject.cost) {
            return type;
        }
        return otherObject.type;
    }
    public String compare2(Bestpath otherObject) {
        // Compare cost and length of two objects
        if (length < otherObject.length) {
            return type;
        } 
        
        return otherObject.type;
    }
}

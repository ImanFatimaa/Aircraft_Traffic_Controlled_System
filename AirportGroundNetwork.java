package oop_project;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Airportgroundnetwork {
    public static boolean runway;
    private boolean taxiway;
    private boolean gate;
    private int numberOfRunways;
    private List<Integer> occupiedrunway;
    private List<Integer> occupiedtaxiway;
    private List<Integer> occupiedgate;

    private Map<Integer, Integer> airplanegate;
    private Map<Integer, Integer> airplanetaxiway;
    private Map<Integer, Integer> airplanerunway;

    public Airportgroundnetwork(int numofRunways) {
    	setNumberOfRunways(numofRunways);
        runway = true; //these are true when these are close
        taxiway = true;
        gate = true;
        

        occupiedrunway = new ArrayList<>();
        occupiedtaxiway = new ArrayList<>();
        occupiedgate = new ArrayList<>();

        airplanegate = new HashMap<>();
        airplanetaxiway = new HashMap<>();
        airplanerunway = new HashMap<>();
    }
    public int getNumberOfRunways() {
		return numberOfRunways;
	}
	public void setNumberOfRunways(int numOfRunways) {
		numberOfRunways = numOfRunways;
	}
    public void openRunway() {
        runway = true;
    }

    public void closeRunway() {
        runway = false;
        occupiedrunway.clear();
    }

    public void openTaxiway() {
        taxiway = true;
    }

    public void closeTaxiway() {
        taxiway = false;
        occupiedtaxiway.clear();
    }

    public void openGate() {
        gate = true;
    }

    public void closeGate() {
        gate = false;
        occupiedgate.clear();
        airplanegate.clear();
    }

    public void occupyRunway(int airplaneID, int runwayID) {
        if (runway && occupiedrunway.size() < numberOfRunways) {
            occupiedrunway.add(runwayID);
            airplanerunway.put(airplaneID, runwayID);
        } else {
            System.out.println("Cannot occupy runway. All runways are already in use.");
        }
    }

  
    public void occupyTaxiway(int airplaneID,int taxiwayID) {
        if (taxiway) {
            occupiedtaxiway.add(taxiwayID);
            airplanetaxiway.put( airplaneID,taxiwayID); 
        }
    }
    public void occupyGate(int airplaneID,int gateID) {
        if (gate) {
            occupiedgate.add(gateID);
            airplanegate.put( airplaneID,gateID);
        }
    }

    public void printgroundnetworkstatus() {
        if (runway) {
            System.out.println("Runway State: CLOSE");
            System.out.println("DETAIL OF USE");
            System.out.println("Occupied runways: " + occupiedrunway); 
             System.out.println(" Airplane IDs: " + airplanerunway.keySet()+"are occupying runways"+ occupiedrunway);
        } else {
            System.out.println("Runway State: AVAILABLE");
        }

        if (taxiway) {
            System.out.println("Taxiway State: CLOSE");
            System.out.println("DETAIL OF USE");
            System.out.println("Occupied taxiways: " + occupiedtaxiway); 
            System.out.println(" Airplane IDs: " + airplanetaxiway.keySet()+ "are occupying taxiways"+ occupiedtaxiway);
        } else {
            System.out.println("Taxiway State: Available");
        }

        if (gate) {
            System.out.println("Gate State: CLOSE");
            System.out.println("DETAIL OF USE");
            System.out.println("Occupied gates: " + occupiedgate); 
            System.out.println(" Airplane IDs: " + airplanegate.keySet()+"are occupying gates"+ occupiedgate );
            
        } else {
            System.out.println("Gate State: AVAILABLE");
        }
    }
	


}

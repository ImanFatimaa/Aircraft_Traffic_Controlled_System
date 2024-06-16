package oop_project;

import java.util.ArrayList;
import java.util.List;

public class Airplanelist {
    private List<Airplane> airplanes;

    public Airplanelist() {
        airplanes = new ArrayList<>();
    }
//creating an airplane foe scheduling or arrival
    public Airplane createAirplane() {
        Airplane airplane = new Airplane();
        airplanes.add(airplane);
        return airplane;
    }
//setting id to anew airplane
    public void assignAirplaneID(Airplane airplane, int id) {
        airplane.setID(id);
    }
//method to add new created plane to list of previous planes
    public void addAirplane(Airplane airplane) {
        airplanes.add(airplane);
    }
//removing an airplane from the list
    public void removeAirplane(Airplane airplane) {
        airplanes.remove(airplane);
    }
//sending task to an airplane on the basis of its main id
    public void sendTask(int id, String task) {
        for (Airplane airplane : airplanes) {
            if (airplane.getID() == id) {
                airplane.receiveTask(task);
                break;
            }
        }
    }
//getting details of target plane using its id
    public Airplane getAirplane(int id) {
        for (Airplane airplane : airplanes) {
            if (airplane.getID() == id) {
                return airplane;
            }
        }
        return null;
    }
}

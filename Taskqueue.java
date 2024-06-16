package oop_project;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Taskqueue {
	
	static ArrayList<String> queue = new ArrayList<>();
	

	public static void initializeTaskLabels() {
		
		
		queue.add("open a link(traffic network available)");
		queue.add("releasing an airplane from a runway\\taxiway\\gate");
		queue.add("move an airplane");
		queue.add("exiting Runway");
		queue.add("departed");
		queue.add("in air");
		queue.add("landing");
		queue.add("reaching destination and entering airport");
        queue.add("receiving an airplane in a runway\\taxiway\\gate");
		queue.add("park an airplane");
        queue.add("close a link(traffic network not available)");

    	
        
        
    }
	
	public static void emergency() {
		ArrayList<String> queue2 = new ArrayList<>();
		queue2.add("hold an airplane");
		for(int i=0;i<queue.size();i++) {
			queue2.add(queue.get(i));
		}
		queue=queue2;
		queue2.clear();
		
	}
	
	public static void deletingTask() {
        
        try {
                queue.remove(0);

                System.out.println("Task dispatched successfully.");
                System.out.println("Task deleted successfully.");
                
            
        } catch (Exception e) {
            System.out.println("An error occurred while deleting the task.");
            e.printStackTrace();
        }
    }
	
	
}

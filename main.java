package oop_project;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        // Create an instance of Airportgroundnetwork
    	System.out.println("Enter file name you want to access");
    	Scanner in= new Scanner(System.in);
    	String filename=in.nextLine();
    	
    	turtle_animation turtle= new turtle_animation();
    	
        Airportgroundnetwork airportGroundNetwork = new Airportgroundnetwork(2);
         Globalclock clk=new Globalclock();
        // Open runway, taxiway, and gate
        airportGroundNetwork.openRunway();
        airportGroundNetwork.openTaxiway();
        airportGroundNetwork.openGate();

        // Create an instance of Airplanelist
        Airplanelist airplaneList = new Airplanelist();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Split the line by comma 
                String[] values = line.split(",");

                // Create an airplane and add it to the list
                Airplane airplane = airplaneList.createAirplane();

                // Set airplane properties based on the file data
                airplane.setID(Integer.parseInt(values[0]));
                airplane.setOrientation(values[1]);
                airplane.setDestination(values[2]);
                airplane.setFrom(values[3]);
                airplane.setTo(values[4]);
                airplane.setTotal_cost(Integer.parseInt(values[5]));
                airplane.setReach_destination(values[6]);
                airplane.setPath(values[7]);
                airplane.setStart(Long.parseLong(values[8]));
                airplane.setEnd(Long.parseLong(values[9]));
                airplane.receiveTask(values[10]);
                airplane.setTotal_time(Long.parseLong(values[11]));
                
                System.out.println("Flight Details");
                System.out.println("Airplane ID: "+airplane.getID());
                System.out.println("Flight Destination: "+airplane.getDestination());
                System.out.println("Flight will depart from "+airplane.getFrom()+" Airport");
                System.out.println("Flight will land in "+airplane.getTo()+" Airport");
                System.out.println("Take Off Time: "+airplane.getStart());
                System.out.println("Landing Time: "+airplane.getEnd());
                System.out.println("Flight Duration: "+airplane.getTotal_time());
                System.out.println("................................................................");
                System.out.println("");
                

                // Assign an ID to the airplane
                airplaneList.assignAirplaneID(airplane, Integer.parseInt(values[0]));
                
                	Taskqueue.initializeTaskLabels();
                    // Send a task to the airplane
                	while(!Taskqueue.queue.isEmpty()) 
                    {
                    
                    	if(Taskqueue.queue.get(0).equals("open a link(traffic network available)")){
                    		
                    		 airplaneList.sendTask(Integer.parseInt(values[0]), Taskqueue.queue.get(0));

                             // Print the current state of the airplane
                             System.out.println("Airplane " + airplane.getID() + " State: " + airplane.getTask());
                             //close means available 
                    		airportGroundNetwork.closeRunway();
                    		
                    		airportGroundNetwork.closeTaxiway();
                    		airportGroundNetwork.closeGate();
                    		
                             airportGroundNetwork.printgroundnetworkstatus();
                             clk.displaytime();

                    		Taskqueue.deletingTask();
                    		System.out.println("................................................................");
                            System.out.println("");
                    	}
                    	
                    
                    else if(Taskqueue.queue.get(0).equals("releasing an airplane from a runway\\taxiway\\gate")){
                		
               		 airplaneList.sendTask(Integer.parseInt(values[0]), Taskqueue.queue.get(0));
               			System.out.println("Airplane " + airplane.getID() + " State: " + airplane.getTask());
               		airportGroundNetwork.openGate();
               		airportGroundNetwork.occupyGate(Integer.parseInt(values[0]), 1);
               	                         
               		airportGroundNetwork.openTaxiway();
               		airportGroundNetwork.occupyTaxiway(Integer.parseInt(values[0]), 1);
               		airportGroundNetwork.openRunway();
               		airportGroundNetwork.occupyRunway(Integer.parseInt(values[0]), 1);
               		
                        
               		
               		
               		
               		 clk.displaytime();
                        airportGroundNetwork.printgroundnetworkstatus();
                        
                        Taskqueue.deletingTask();
                        System.out.println("................................................................");
                        System.out.println("");
               		
               	}
               	
               else if(Taskqueue.queue.get(0).equals("move an airplane")){
               		
               		 airplaneList.sendTask(Integer.parseInt(values[0]), Taskqueue.queue.get(0));
               		 System.out.println("Airplane " + airplane.getID() + " State: " + airplane.getTask());
               		 airportGroundNetwork.closeGate();
               		 airportGroundNetwork.closeTaxiway();
               		airportGroundNetwork.occupyRunway(Integer.parseInt(values[0]), 1);
               		if(true) {
               		       try (BufferedReader bt = new BufferedReader(new FileReader(airplane.getDestination()))) {
                                  String lines;
                                  while ((lines = bt.readLine()) != null) {
                                      // Split the line by comma 
                                      String[] value = lines.split(",");
                                      
                                      int len=Integer.parseInt(value[0]);
                                      String path = value[1];
                                      int cost=Integer.parseInt(value[2]);
                                      
                                      int len2=Integer.parseInt(value[3]);
                                      String path2 = value[4];
                                       int cost2=Integer.parseInt(value[5]); 
                                       Bestpath obj1 = new Bestpath(len, path, cost);
                                       Bestpath obj2 = new Bestpath(len2, path2,cost2);

                              // Compare cost and length of obj1 and obj2
                              String result = obj1.compare(obj2);
                              String result2 = obj1.compare2(obj2);
                              System.out.println("Best path with respect to cost: " + result);
                              System.out.println("Shortest path: " + result2);
                              System.out.println("Chosen path was:"+result);
                                  
                              }
                              } 
                        
                              
                           catch (IOException e) {
                                e.printStackTrace();
                                  }
               		}
               		
               		 clk.displaytime();
                        airportGroundNetwork.printgroundnetworkstatus();
                        Taskqueue.deletingTask();
                        System.out.println("................................................................");
                        System.out.println("");
               	}
               	
               	 else if(Taskqueue.queue.get(0).equals("exiting Runway")){
               		
               		
               		 airplaneList.sendTask(Integer.parseInt(values[0]), Taskqueue.queue.get(0));
               		 
               			System.out.println("Airplane " + airplane.getID() + " State: " + airplane.getTask());
               		
               		 clk.displaytime();
                        
                        Taskqueue.deletingTask();
                        System.out.println("................................................................");
                        System.out.println("");
               	}
               	
               else if(Taskqueue.queue.get(0).equals("departed")){
               		
               		 airplaneList.sendTask(Integer.parseInt(values[0]), Taskqueue.queue.get(0));
               		System.out.println("Airplane " + airplane.getID() + " State: " + airplane.getTask());
               		 clk.displaytime();
                        
                        Taskqueue.deletingTask();
                        System.out.println("................................................................");
                        System.out.println("");
               	}
               else if(Taskqueue.queue.get(0).equals("in air")){
               		
                		 airplaneList.sendTask(Integer.parseInt(values[0]), Taskqueue.queue.get(0));
                		System.out.println("Airplane " + airplane.getID() + " State: " + airplane.getTask());
                		 clk.displaytime();
                        
                         Taskqueue.deletingTask();
                         System.out.println("................................................................");
                         System.out.println("");
                         }
               else if(Taskqueue.queue.get(0).equals("landing")){
               		if(Airportgroundnetwork.runway==false) {
                 		 airplaneList.sendTask(Integer.parseInt(values[0]), Taskqueue.queue.get(0));
                 		System.out.println("Airplane " + airplane.getID() + " State: " + airplane.getTask());
                 		 clk.displaytime();
                         
                          Taskqueue.deletingTask();
                          System.out.println("................................................................");
                          System.out.println("");
               		}
               		else {
               			Taskqueue.emergency();
               		}
                          }
               	else if(Taskqueue.queue.get(0).equals("reaching destination and entering airport")){
               		
              		 airplaneList.sendTask(Integer.parseInt(values[0]), Taskqueue.queue.get(0));
              		System.out.println("Airplane " + airplane.getID() + " State: " + airplane.getTask());
              		 clk.displaytime();
                      
                       Taskqueue.deletingTask();
                       System.out.println("................................................................");
                       System.out.println("");
                       }
               	
               else if(Taskqueue.queue.get(0).equals("receiving an airplane in a runway\\taxiway\\gate")){
               		
               		airplaneList.sendTask(Integer.parseInt(values[0]), Taskqueue.queue.get(0));
           			System.out.println("Airplane " + airplane.getID() + " State: " + airplane.getTask());
           		airportGroundNetwork.openRunway();
           		airportGroundNetwork.occupyRunway(Integer.parseInt(values[0]), 1);
           		airportGroundNetwork.closeTaxiway();
           
                    
           		airportGroundNetwork.openTaxiway();
           		airportGroundNetwork.occupyTaxiway(Integer.parseInt(values[0]), 1);
           		airportGroundNetwork.closeGate();
           		 
                   
           		airportGroundNetwork.openGate();
           		airportGroundNetwork.occupyGate(Integer.parseInt(values[0]), 1);

   
           		 clk.displaytime();
                    airportGroundNetwork.printgroundnetworkstatus();
                    Taskqueue.deletingTask();
                    System.out.println("................................................................");
                    System.out.println("");
               		
               		
               	}
               	
               else if(Taskqueue.queue.get(0).equals("park an airplane")){
               		 airplaneList.sendTask(Integer.parseInt(values[0]), Taskqueue.queue.get(0));
                   		System.out.println("Airplane " + airplane.getID() + " State: " + airplane.getTask());
                   		 clk.displaytime();
                           
                            Taskqueue.deletingTask();
                            System.out.println("................................................................");
                            System.out.println("");
               	}
               	
                else if(Taskqueue.queue.get(0).equals("close a link(traffic network not available)")){
               		 airplaneList.sendTask(Integer.parseInt(values[0]), Taskqueue.queue.get(0));
                   		System.out.println("Airplane " + airplane.getID() + " State: " + airplane.getTask());
                   		 clk.displaytime();
                           
                            Taskqueue.deletingTask();
                            System.out.println("................................................................");
                            System.out.println("");
               	}
                else if(Taskqueue.queue.get(0).equals("hold an airplane"))
                {
                	airplaneList.sendTask(Integer.parseInt(values[0]), Taskqueue.queue.get(0));
                	System.out.println("Airplane " + airplane.getID() + " State: " + airplane.getTask());
               		clk.displaytime();
               		Taskqueue.deletingTask();
               		System.out.println("................................................................");
                    System.out.println("");
                }
                }

                	turtle.shape();
                    turtle.airplane_color();
                    turtle.set_width();
                    turtle.set_position();
                    turtle.move_turtle();
            }
            
        }
        
            

           catch (IOException e) 
           {
        	   e.printStackTrace();
           }
        
    }
}

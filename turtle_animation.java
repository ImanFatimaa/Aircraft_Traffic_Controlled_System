package oop_project;

import java.util.Random;

import Lab11task2.Turtle;

public class turtle_animation {
	
//graphically show
	Turtle airp=new Turtle();
	int step=100;
	Random random = new Random();
	
	public turtle_animation()
	{
	  
       airp=new Turtle();

  	 //setting background color of turtle console in default constructor
       Turtle.bgcolor("cyan");
       
	}
	//declaring shape of turtle to arrows it is  somehow same as airplane
	public void shape()
	{
		airp.shape("arrow");
		
	}
	//setting different colors for different aircrafts
	public void airplane_color()
	{
		airp.fillColor("red");
		airp.penColor("white");
		
	}
	//now setting the width of all the airplanes
	public void set_width()
	{
		airp.width(3);
	}
	//setting position for different planes
	public void set_position()
	{
		airp.up();
		airp.setPosition(-550,267);
		airp.down();
		
	}
	//creating plane movement on screen
	public void move_turtle() {
	    // Specify starting and ending points
		//Turtle bob = new Turtle();

		airp.speed(10);
	    int sides = 880;  // Increase the number of sides for a smoother circle

	    for (int i = 0; i < (2*sides/3); i++) {
	        airp.forward(2);  // Adjust the length of each side
	        airp.right(60.0 / sides);
	        }
	}
	
}

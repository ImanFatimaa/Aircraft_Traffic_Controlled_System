package oop_project;

public class Airplane {
    private  int ID;
    private String orientation;
    private String destination;
    private String from;
    private String to;
    private int total_cost;
    private String reach_destination;
    private String path;
    private long start;
    private long end;
    private long total_time;
    private String task;
//planes id
    public void setID(int id) {
        ID = id;
    }

    public int getID() {
        return ID;
    }
    //planes orientation
	public String getOrientation() {
		return orientation;
	}

	public void setOrientation(String i) {
		orientation = i;
	}
//planes destination
	public String getDestination() {
		return destination;
	}

	public void setDestination(String dest) {
		destination = dest;
	}
	//plane coming from point
	public String getFrom() {
		return from;
	}

	public void setFrom(String fr) {
		from = fr;
	}
///plane is moving towards
	public String getTo() {
		return to;
	}

	public void setTo(String t) {
		to = t;
	}
///total cost of flight
	public int getTotal_cost() {
		return total_cost;
	}   

	public void setTotal_cost(int total) {
		total_cost = total;
	}
//planes destination checking 
	public String getReach_destination() {
		return reach_destination;
	}

	public void setReach_destination(String reach) {
		reach_destination = reach;
	}
//planes complete route or path basically the best path
	public String getPath() {
		return path;
	}

	public void setPath(String pth) {
		path = pth;
	}
//planes starting time
	public long getStart() {
		return start;
	}

	public void setStart(long st) {
		start = st;
	}
//planes landing time
	public long getEnd() {
		return end;
	}

	public void setEnd(long ed) {
		end = ed;
	}
//recieving task from user
	public void receiveTask(String tsk) {
	  task=tsk;
		
	}
	public String getTask() {
		return task;
	}

	public long getTotal_time() {
		return total_time;
	}

	public void setTotal_time(long time) {
		total_time = time;
	}
}

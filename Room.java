import java.util.ArrayList;

public class Room {

	private int isTaken; 
	private String takenName;

	private ArrayList<Room> times;
	private ArrayList<ArrayList<Room>> rooms;

	private int x, y;


	public Room(int isTaken, String takenName){
		this.setTaken(isTaken);
		this.setTakenName(takenName);
	}

	public void set() {		
		times = new ArrayList<Room>();
		rooms = new ArrayList<ArrayList<Room>>();


		times = generateTimes(times);
		rooms = setRooms(times, rooms);
	}

	public ArrayList<Room> generateTimes(ArrayList<Room> times){
		//Times between 5am to 10pm
		for(int i = 5; i <= 22; i++){
			Room newTime = new Room(0, "");
			times.add(newTime);
		}
		return times;
	}

	public ArrayList<ArrayList<Room>> setRooms(ArrayList<Room> times, ArrayList<ArrayList<Room>> rooms) {
		// create week with 7 rooms
		for (int i = 1; i <= 3; i++) {
			rooms.add(times);
		}
		return rooms;
	}
	
	public ArrayList<ArrayList<Room>> getRooms()
	{
		return rooms;
	}

	public int isTaken() {
		return isTaken;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void setAxis(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	
	public void setTaken(int isTaken) {
		this.isTaken = isTaken;
	}

	public String getTakenName() {
		return takenName;
	}

	public void setTakenName(String takenName) {
		this.takenName = takenName;
	}

	public void check(int x, int y, int wi, int he, int lazy)
	{
		for(int k = 0; k < 3; k++)
		{
			for(int p = 0; p < 16; p++)
			{
				if(rooms.get(k).get(p).getX() <= x  && rooms.get(k).get(p).getX() >= x - wi/25 && rooms.get(k).get(p).getY() <= y - he/20 && rooms.get(k).get(p).getY() >= y - he/20*10/5)
				{
					rooms.get(k).get(p).setTaken(lazy);
				}

				else
				{
					rooms.get(k).get(p).setTaken(0);
				}
			}
		}
	}
}
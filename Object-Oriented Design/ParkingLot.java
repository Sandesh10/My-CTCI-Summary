/*
7.4 Parking Lot: Design a parking lot using object-oriented principles.
*/

Questions:
What types of vehicles? Whether the parking lot has multiple levels and so on.

Assumptions:
- multiple levels each with multiple rows of spots.
- can park motorcycles, cars and buses.
- parking lot has motorcycle spots, compact spots and large spots.
- motorcycle can park in any spot
- car can park in either compact or large spot.
- bus can park in five large spots that are consecutive in a same row.


public enum VehicleSize {Motorcycle, Compact, Large}

public abstract class Vehicle {
	protected ArrayList<ParkingSpot> parkingSpots = new ArrayList<ParkingSpot>();
	protected String licensePlate;
	protected int spotsNeeded;
	protected VehicleSize size;

	public int getSpotNeeded() {return spotsNeeded;}
	public VehicleSize getSize(){return size;}

	// park vehicle in the spot
	public void parkInSpot(ParkingSpot s) { parkingSpots.add(s);}

	// remove car from spot
	public void clearSpots() {}

	// checks if the spot is big enoigh for the vehicle
	public abstract boolean canFitInSpot(ParkingSpot spot);
}

public class Bus extend Vehicle {
	public Bus(){
		spotsNeeded = 5;
		size = VehicleSize.Large;
	}

	public boolean canFitInSpot(ParkingSpot spot) {}
}

public class Car extend Vehicle {
	public Bus(){
		spotsNeeded = 1;
		size = VehicleSize.Compact;
	}

	// check if the spot is compact or large
	public boolean canFitInSpot(ParkingSpot spot) {}
}

public class Motorcycle extend Vehicle {
	public Bus(){
		spotsNeeded = 1;
		size = VehicleSize.Motorcycle;
	}

	public boolean canFitInSpot(ParkingSpot spot) {}
}

/*
The ParkingLot class is essentially a wrapper class for an array of Levels.
By implementing this way, we are able to separate out logic that deals with
actually finding free spots and parking cars out from the broader actions of 
ParkingLot.
*/

public class ParkingLot {
	private Level[] levels;
	private final int NUM_LEVELS = 5;

	public ParkingLot(){}

	//park vehicle in this spot or multiple spots. return false if failed.
	public boolean parkVehicle(Vehicle vehicle){}
}

public class Level {
	private int floor;
	private ParkingSpot[] spots;
	private int availableSpots = 0;
	private static final int SPOTS_PER_ROW = 10;

	public Level(int floor, int numberSpots){}

	// other functions
	public boolean parkVehicle(Vehicle v) {} // find place to park return false if failed.
	public boolean parkStartingAtSpot(int num, Vehicle v){}
	public int findAvailableSpots(Vehicle v){}
	public void spotFreed() {availableSpots++;}
}

/*
ParkingSpot is implemented by having just a variable which represents the size of the spot.
*/
public class ParkingSpot{
	private Vehicle vehicle;
	private VehicleSize spotSize;
	private int row;
	private int spotNumber;
	private Level level;

	public boolean isAvailable() {return vehicle==true;}

	public boolean park(Vehicle v){}
	public void removeVehicle(){}
}
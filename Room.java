public class Room {
	private int roomNumber;
	private String roomType;
	private double cost;
	private boolean isOccupied;
	private Passenger passenger;

	//default constructor
	public Room() {
		this.roomNumber = 0;
		this.roomType = "Interior";
		this.cost = 0.0;
		this.isOccupied = false;
		this.passenger = null;
	}

	//constructor
	public Room(int roomNumber, String roomType, double cost, boolean isOccupied, Passenger passenger) {
		this.roomNumber = roomNumber;
		this.roomType = roomType;
		this.cost = cost;
		this.isOccupied = isOccupied;
		this.passenger = passenger;
	}

	//copy constructor
	public Room(Room other) {
		this.roomNumber = other.roomNumber;
		this.roomType = other.roomType;
		this.cost = other.cost;
		this.isOccupied = other.isOccupied;
		this.passenger = other.passenger;
	}
	//GET METHODS

	public int getRoomNumber() {
		return roomNumber;
	}

	public String getRoomType() {
		return roomType;
	}

	public double getCost() {
		return cost;
	}

	public boolean isOccupied() {
		return isOccupied;
	}

	public Passenger getPassenger() {
		return passenger;
	}

	//SET METHODS

	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public void setIsOccupied(boolean isOccupied) {
		this.isOccupied = isOccupied;
	}

	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}

	public boolean equals(Room other) {
		return this.roomNumber == other.roomNumber
				&& this.roomType.equals(other.roomType)
				&& this.cost == other.cost
				&& this.isOccupied == other.isOccupied()
				&& this.passenger != null && this.passenger.equals(other.passenger);
	}

	@Override
	public String toString() {
		if (passenger != null) {
			return "Room [ROOM NUMBER: " + roomNumber + ", ROOM TYPE: " + roomType + ", COST: " + cost + ", IS THE ROOM OCCUPIED?: " + isOccupied + ", PASSENGER: " + passenger.getName() + "]";
		} else {
			return "Room [ROOM NUMBER: " + roomNumber + ", ROOM TYPE: " + roomType + ", COST: " + cost + ", IS THE ROOM OCCUPIED?: " + isOccupied + ", PASSENGER: none]";
		}
	}
}





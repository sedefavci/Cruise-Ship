public class Cruise {
	private String shipName = "Feraye";
	private int numberOfInteriorRooms;
	private int numberOfWindowRooms;
	private int numberOfOccupiedRooms;
	private double interiorRoomCost;
	private double windowRoomCost;
	private Passenger[] passengers;
	private Room[] rooms;
	private static int passengerCount;
	private static int roomCount;

	//default constructor
	public Cruise() {
		this.shipName = "Feraye";
		this.numberOfInteriorRooms = 100;
		this.numberOfWindowRooms = 20;
		this.numberOfOccupiedRooms = 0;
		this.interiorRoomCost = 230.0;
		this.windowRoomCost = 330.0;
		this.rooms = new Room[120];
		this.passengers = new Passenger[120];

		//initializing and creating, unoccupied room objects
		for (int i = 0; i < numberOfInteriorRooms; i++) {
			rooms[i] = new Room(i + 1, "Interior", interiorRoomCost, false, null);
		}
		for (int i = 0; i < numberOfWindowRooms; i++) {
			rooms[i + numberOfInteriorRooms] = new Room(i + 1 + numberOfInteriorRooms, "Window", windowRoomCost, false, null);
		}
	}

	//constructor
	public Cruise(String shipName, int numberOfInteriorRooms, int numberOfOccupiedRooms,
				  int numberOfWindowRooms, double interiorRoomCost, double windowRoomCost,
				  Passenger[] passengers, Room[] rooms) {

		this.shipName = shipName;
		this.numberOfInteriorRooms = numberOfInteriorRooms;
		this.numberOfWindowRooms = numberOfWindowRooms;
		this.numberOfOccupiedRooms = 0;
		this.interiorRoomCost = interiorRoomCost;
		this.windowRoomCost = windowRoomCost;

		int totalRoom = numberOfInteriorRooms + numberOfWindowRooms;

		// null gelen dizileri tamamen yok sayıyoruz, kendimiz oluşturuyoruz
		this.rooms = new Room[totalRoom];
		this.passengers = new Passenger[totalRoom];

		// interior odalar
		for (int i = 0; i < numberOfInteriorRooms; i++) {
			this.rooms[i] = new Room(i + 1, "Interior", interiorRoomCost, false, null);
		}

		// window odalar
		for (int i = 0; i < numberOfWindowRooms; i++) {
			this.rooms[numberOfInteriorRooms + i] = new Room(numberOfInteriorRooms + i + 1, "Window", windowRoomCost, false, null);
		}
	}

	//copy constructor
	public Cruise(Cruise other) {
		this.shipName = shipName;
		this.numberOfInteriorRooms = other.numberOfInteriorRooms;
		this.numberOfWindowRooms = other.numberOfWindowRooms;
		this.numberOfOccupiedRooms = other.numberOfOccupiedRooms;
		this.interiorRoomCost = other.interiorRoomCost;
		this.windowRoomCost = other.windowRoomCost;

		this.passengers = new Passenger[other.passengers.length];
		for (int i = 0; i < other.passengers.length; i++) {
			if (other.passengers[i] != null) {
				this.passengers[i] = new Passenger(other.passengers[i]);
			}
		}
		this.rooms = new Room[other.rooms.length];
		for (int i = 0; i < other.rooms.length; i++) {
			this.rooms[i] = new Room(other.rooms[i]);
		}
	}

	//GET METHODS
	public String getShipName() {
		return shipName;
	}

	public int getNumberOfInteriorRooms() {
		return numberOfInteriorRooms;
	}

	public int getNumberOfWindowRooms() {
		return numberOfWindowRooms;
	}

	public int getNumberOfOccupiedRooms() {
		return numberOfOccupiedRooms;
	}

	public double getInteriorRoomCost() {
		return interiorRoomCost;
	}

	public double getWindowRoomCost() {
		return windowRoomCost;
	}

	//returns array
	public Passenger[] getPassengers() {
		return passengers;
	}
	//getPassenger-returns the element at the specific index
	public Passenger getPassenger(int index) {
		if (index >= 0 && index < passengers.length) {
			if (passengers[index] != null) {
				return passengers[index];
			} else {
				System.out.println("No passenger at this index");
				return null;
			}
		} else {
			System.out.println("Invalid index!");
			return null;
		}
	}

	//returns array
	public Room[] getRooms() {
		return rooms;
	}
	//getRoom-returns the element at the specific index
	public Room getRoom(int index) {
		if (index >= 0 && index < rooms.length) {
			if (rooms[index] != null) {
				return rooms[index];
			} else {
				System.out.println("No room at this index");
				return null;
			}
		} else {
			System.out.println("Invalid index!");
			return null;
		}
	}

	//SET METHODS
	public void setShipName(String shipName) {
		this.shipName = shipName;
	}

	public void setNumberOfInteriorRooms(int numberOfInteriorRooms) {
		this.numberOfInteriorRooms = numberOfInteriorRooms;
	}

	public void setNumberOfWindowRooms(int numberOfWindowRooms) {
		this.numberOfWindowRooms = numberOfWindowRooms;
	}

	public void setNumberOfOccupiedRooms(int numberOfOccupiedRooms) {
		this.numberOfOccupiedRooms = numberOfOccupiedRooms;
	}

	public void setInteriorRoomCost(double interiorRoomCost) {
		this.interiorRoomCost = interiorRoomCost;
	}

	public void setWindowRoomCost(double windowRoomCost) {
		this.windowRoomCost = windowRoomCost;
	}


	public void setPassengers(Passenger[] passengers) {
		this.passengers = passengers;
	}

	//assigns element to the array
	public void setPassenger(int index, Passenger passenger) {
		if (index >= 0 && index < passengers.length) {
			passengers[index] = passenger;
		} else {
			System.out.println("Invalid index!");
		}
	}

	public void setRooms(Room[] rooms) {
		this.rooms = rooms;
	}
	//assigns element to the array
	public void setRoom(int index, Room room) {
		if (index >= 0 && index < rooms.length) {
			rooms[index] = room;
		} else {
			System.out.println("Invalid index!");
		}
	}

	//OTHER METHODS
	//methods for counting passengers and rooms
	public static int getPassengerCount() {
		return passengerCount;
	}

	public static int getRoomCount() {
		return roomCount;
	}

	//a method that places this passenger in the first empty room
	public void addPassenger(Passenger pass) {

			for (int i = 0; i < passengers.length; i++) {
				if (passengers[i] == null) {
					passengers[i] = pass;

					int roomNumber = pass.getRoomNumber();
					for (int j = 0; j < rooms.length; j++) {
						if (rooms[j] != null && rooms[j].getRoomNumber() == roomNumber) {
							rooms[j].setIsOccupied(true);
							rooms[j].setPassenger(pass);
							break;
						}
					}
					break;
				}
			}
		}


	//a method that finds passenger name and returns reference to found passenger object
	public Passenger findPassenger(String name) {
		for (int i = 0; i < passengers.length; i++) {
			Passenger passenger = passengers[i];
			if (passenger != null && passenger.getName().equals(name)) {
				return new Passenger(passenger);
			}
		}
		return null;
	}
	//a method that gives passenger available room
	public Room getAvailableRoom(String roomType) {
		for (int i = 0; i < rooms.length; i++) {
			if (rooms[i] != null && rooms[i].getRoomType().equalsIgnoreCase(roomType) && !rooms[i].isOccupied()) {
				return rooms[i];
			}
		}
		return null; // No available room
	}


	//EQUALS METHOD-comparing two Cruise objects if they are equal or not
	public boolean equals(Cruise other) {
		if (!this.shipName.equals(other.shipName)
				|| this.numberOfInteriorRooms != other.numberOfInteriorRooms
				|| this.numberOfWindowRooms != other.numberOfWindowRooms
				|| this.numberOfOccupiedRooms != other.numberOfOccupiedRooms
				|| this.interiorRoomCost != other.interiorRoomCost
				|| this.windowRoomCost != other.windowRoomCost) {
			return false;
		}
		for (int i = 0; i < rooms.length; i++) {
			if (rooms[i] != null && !rooms[i].equals(other.rooms[i])) {
				return false;
			}
		}
		for (int i = 0; i < passengers.length; i++) {
			if (passengers[i] != null && !passengers[i].equals(other.passengers[i])) {
				return false;
			}
		}
		return true;
	}

	//TOSTRING METHOD
	@Override
	public String toString() {
		return "______________________________________________________________________________\n" +
				"Ship Name: " + shipName + "\n" +
				"______________________________________________________________________________\n" +
				"Rooms: " + rooms.length + " rooms total, " + numberOfWindowRooms + " Window, " + numberOfInteriorRooms + " Interior\n" +
				getRoomDetails() +
				"______________________________________________________________________________\n" +
				"Passengers: " + numberOfOccupiedRooms + " passengers total\n" +
				getPassengerDetails() +
				"______________________________________________________________________________\n";
	}

	private String getRoomDetails() {
		String text = "";
		for (int i = 0; i < rooms.length; i++) {
			Room room = rooms[i];
			if (room != null) {
				text += "Number: " + room.getRoomNumber();
				text += ", Type: " + room.getRoomType().charAt(0);
				text += ", Occupied: " + (room.isOccupied() ? "YES" : "NO");
				text += ", Cost: " + String.format("%.2f", room.getCost());
				if (room.isOccupied() && room.getPassenger() != null) {
					text += ", Passenger Name: " + room.getPassenger().getName();
				}
				text += "\n";
			}
		}
		return text;
	}

	private String getPassengerDetails() {
		String text = "";
		int count = 1;
		for (int i = 0; i < passengers.length; i++) {
			Passenger passenger = passengers[i];
			if (passenger != null) {
				Room r = null;
				for (int j = 0; j < rooms.length; j++) {
					if (rooms[j].getPassenger() == passenger) {
						r = rooms[j];
						break;
					}
				}
				text += "(" + count++ + ") Name: " + passenger.getName();
				text += ", Address: " + passenger.getAddress();
				text += ", Age: " + passenger.getAge();
				text += ", Room Info: Number: " + r.getRoomNumber();
				text += ", Type: " + r.getRoomType().charAt(0);
				text += ", Occupied: " + (r.isOccupied() ? "YES" : "NO");
				text += ", Cost: " + String.format("%.2f", r.getCost()) + "\n";
			}
		}
		return text;
	}
}

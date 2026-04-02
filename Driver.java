public class Driver {
	/**
	 * Driver Class for Unit Testing.
	 * * Purpose: This class acts as a test bench (driver) to verify the core
	 * functionalities of the Passenger and Room classes independently.
	 * It ensures that constructors, accessors (getters), mutators (setters),
	 * and object comparison logic (equals method) are working correctly
	 * before integrating them into the main Cruise system.
	 * * Note: This is a developer-centric test and does not represent
	 * the final application flow.
	 */
	public static void main(String[] args) {
		// created passenger and room
		Passenger p = new Passenger("Tom Smith", "1000 St. Wayne PA", 45, 1);
		Room r = new Room(1, "W", 150.0, false, null);

		System.out.println(p);
		System.out.println(r);

		System.out.println("------------------------------------------------------------------------------------------------------------------------");
		//set methods
		p.setName("Thomas Smith");
		p.setAddress("123 New Street");
		p.setAge(46);
		p.setRoomNumber(1);

		r.setIsOccupied(true);
		r.setPassenger(p);

		// after change with using set methods
		System.out.println(p);
		System.out.println(r);


		System.out.println("------------------------------------------------------------------------------------------------------------------------");
		// testing equals and other methods
		Passenger copy = new Passenger(p); // copy constructor
		System.out.println("Copy equals original? " + copy.equals(p));

		Room anotherRoom = new Room(1, "W", 150.0, true, p);
		System.out.println("Room equals anotherRoom? " + r.equals(anotherRoom));
	}
}



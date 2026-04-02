import java.util.Scanner;

//CruiseDriver
public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		// Creating the cruise
		Passenger[] emptyPassengers = new Passenger[2]; // assuming max 2 passengers
		Room[] emptyRooms = new Room[3]; // assuming max 3 rooms

		Cruise cruise = new Cruise("Feraye", 2, 0, 1, 200.00, 330.00, emptyPassengers, emptyRooms);

		// Display room types and numbers
		System.out.println("Rooms: " + cruise.getNumberOfOccupiedRooms() + " rooms total, " +
				cruise.getNumberOfWindowRooms() + " Window, " + cruise.getNumberOfInteriorRooms() + " Interior");

		// Passenger adding
		for (int i = 0; i < 2; i++) {
			System.out.print("Enter name: ");
			String name = input.nextLine();
			System.out.print("Enter address: ");
			String address = input.nextLine();
			System.out.print("Enter age: ");
			int age = input.nextInt();
			input.nextLine(); // Clean the buffer

			// Show available rooms
			System.out.println("Available Rooms:");
			System.out.println("1. Interior Room");
			System.out.println("2. Window Room");
			System.out.print("Choose the type of room (1 for Interior, 2 for Window): ");
			int roomChoice = input.nextInt();
			input.nextLine(); // Clean the buffer

			Room selectedRoom = null;
			if (roomChoice == 1) {
				selectedRoom = cruise.getAvailableRoom("Interior");
			} else if (roomChoice == 2) {
				selectedRoom = cruise.getAvailableRoom("Window");
			}

			// If a valid room was selected, create passenger and assign room
			if (selectedRoom != null) {
				Passenger p = new Passenger(name, address, age, selectedRoom.getRoomNumber());
				cruise.addPassenger(p);
				System.out.println("Passenger added to room number: " + selectedRoom.getRoomNumber());
			} else {
				System.out.println("No available rooms of selected type.");
			}
		}

		// Cruise information
		System.out.println(cruise);

		// Passenger searching
		System.out.print("Search passenger by name: ");
		String searchName = input.nextLine();
		Passenger found = cruise.findPassenger(searchName);
		if (found != null) {
			System.out.println("Passenger found: " + found);
		} else {
			System.out.println("Passenger not found.");
		}

		input.close();
	}
}

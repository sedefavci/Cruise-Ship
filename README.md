# 🚢 Cruise Management & Booking System

A robust Java-based management system designed to handle cruise ship operations, including room inventory, passenger registrations, and automated booking logic.

## System Architecture

This project showcases advanced **Object-Oriented Programming (OOP)** concepts through a real-world simulation:

1. **Class Relationships:**
   - **Composition & Association:** The `Cruise` class acts as a controller, managing arrays of `Room` and `Passenger` objects.
   - **Entity Linkage:** Each `Room` object can hold a reference to a `Passenger`, creating a bidirectional-like relationship managed by the central system.

2. **Memory Management (Deep Copying):**
   - Implemented **Copy Constructors** in all classes (`Passenger`, `Room`, `Cruise`) to ensure data integrity and prevent unwanted reference side effects (Deep Copying vs Shallow Copying).

3. **Core Logic & Algorithms:**
   - **Room Assignment:** Automated search for available rooms based on type (Interior vs Window).
   - **State Tracking:** Dynamic updates of occupancy status and static counters for global passenger/room tracking.
   - **Equality Logic:** Overridden `equals()` methods to compare complex objects based on their internal state rather than memory addresses.



## Key Functionalities

- **Dynamic Room Initialization:** Automatically generates a ship layout with configurable interior and window rooms.
- **Passenger Management:** Register passengers, assign them to specific room types, and maintain an address/age database.
- **Search Engine:** Find passenger details by name through the system's registry.
- **Detailed Reporting:** Custom `toString()` implementations provide formatted ship status reports, including occupancy details and costs.

## Classes Overview

- `Cruise.java`: The primary controller for ship operations.
- `Room.java`: Handles room-specific data (Type, Cost, Occupancy).
- `Passenger.java`: Manages individual passenger profiles.
- `Driver/Main.java`: Provides a CLI for interactive cruise management.

## Sample Interaction

```text
Enter name: Tom Smith
Choose the type of room (1 for Interior, 2 for Window): 2
Passenger added to room number: 101
Search passenger by name: Tom Smith
Passenger found: [NAME: Tom Smith, AGE: 45...]

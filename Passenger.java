public class Passenger {
	private String name;
	private String address;
	private int age;
	private int roomNumber;

	//default constructor
	public Passenger(){
		this.name="Sedef";
		this.address="Ankara";
		this.age=22;
		this.roomNumber=13;
	}
	//constructor
	public Passenger(String name, String address,int age,int roomNumber){
		this.name=name;
		this.address=address;
		this.age=age;
		this.roomNumber=roomNumber;
	}
	//copy constructor
	public Passenger(Passenger other){
		this.name=other.name;
		this.address=other.address;
		this.age=other.age;
		this.roomNumber=other.roomNumber;
	}
	//GET METHODS
	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public String getAddress() {
		return address;
	}

	public int getRoomNumber() {
		return roomNumber;
	}
	//SET METHODS
	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}

	public boolean equals(Passenger other){
		return this.name.equals(other.name)
				&& this.address.equals(other.address)
				&& this.age==other.age
				&& this.roomNumber==other.roomNumber;
	}
	@Override
	public String toString() {
		return "Passenger [NAME: " +name +", ADRESS: " +address+", AGE: "+age +", ROOM NUMBER: " +roomNumber +"]";
	}

}

package student;

public class Student {
	private String name;
	private String address;
	private double GPA;
	
	public Student(String name, String address, double GPA) {
		this.name = name;
		this.address = address;
		this.GPA = GPA;
	}
	
	//getters
	public String getName() {return this.name;}
	public String getAddress() {return this.address;}
	public double GPA() {return this.GPA;}
	
	//setters
	public void setName(String name) {this.name = name;}
	public void setAddress(String address) {this.address = address;}
	public void setGPA(double GPA) {this.GPA = GPA;}
	
	//toString
	@Override
	public String toString() {
		return "Name: " + name + ", GPA: " + GPA + ", Address: " + address;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

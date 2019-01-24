package practiseAgain;

public class Attendence implements AttendenceInterface{

	public String name;
	public String clas;
	
	Attendence() {
		
	}
	
	@Override
	public void show() {
		System.out.print(name + " Your Class is " + clas + " and ");
		System.out.println("Yor Attende is Good");
		
	}

}

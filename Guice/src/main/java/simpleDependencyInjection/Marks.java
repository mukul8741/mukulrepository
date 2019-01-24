package simpleDependencyInjection;


public class Marks implements MarksInterface{
	int marks;
	
	
	@Override
	public void find(String subject) {
		switch(subject) {
		case "Maths" : marks = 95;
		               System.out.println("" + subject + ":" + marks);
		break;
		
		case "Hindi" : marks = 80;
		               System.out.println("" + subject + ":" + marks);
		break;
		
		case "English" : marks = 75;
	                   	 System.out.println("" + subject + ":" + marks);
		break;
		
		case "Chemistry" : marks = 83;
		                   System.out.println("" + subject + ":" + marks);
		break;
		
		case "Physics" : marks = 70;
		                 System.out.println("" + subject + ":" + marks);
		break;
		
		default : System.out.println("There is no such subject");
		
		}
		
		
	}


}

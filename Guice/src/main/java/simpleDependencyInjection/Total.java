package simpleDependencyInjection;

public class Total implements MarksInterface{

	@Override
	public void find(String student) {
		if(student.equals("Total")) {
			System.out.println("Total :" + 500);
		}
		
	}

}

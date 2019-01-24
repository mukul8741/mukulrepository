package simpleDependencyInjection;

import com.google.inject.Inject;

public class Student {
	public final MarksInterface mark;
	
	@Inject
	Student(MarksInterface mark) {
		this.mark = mark;
		
	}
	
	void get(String subject) {
		mark.find(subject);
	}

}

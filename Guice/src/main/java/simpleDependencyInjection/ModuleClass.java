package simpleDependencyInjection;

import com.google.inject.AbstractModule;

public class ModuleClass extends AbstractModule { 
	@Override
	public void configure() {
		bind(MarksInterface.class).to(Marks.class);
		
	//	bind(MarksInterface.class).annotatedWith(Total1.class).to(Total.class);

	}

}

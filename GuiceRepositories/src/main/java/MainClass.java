import com.axelor.ProductRepository;
import com.google.inject.Guice;
import com.google.inject.Injector;

public class MainClass {
	public static void main(String[] args) {
		
		final String TEST_PERSISTENCE_UNIT_NAME = "mukul_data";
	    final String REPOSITORIES_BASE_PACKAGE_NAME = ProductRepository.class.getPackage().getName();

		
		Injector inject = Guice.createInjector(new GuiceModule(TEST_PERSISTENCE_UNIT_NAME, REPOSITORIES_BASE_PACKAGE_NAME));
		
		ProductService productservice = inject.getInstance(ProductService.class);
		
		
	}

}

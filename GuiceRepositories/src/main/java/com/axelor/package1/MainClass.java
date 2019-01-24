package com.axelor.package1;
import com.axelor.ProductRepository;
import com.google.inject.Guice;
import com.google.inject.Injector;

public class MainClass {
	public static void main(String[] args) {
		
		final String TEST_PERSISTENCE_UNIT_NAME = "mukul_data";
	    final String REPOSITORIES_BASE_PACKAGE_NAME = ProductRepository.class.getPackage().getName();

		
		Injector inject = Guice.createInjector(new GuiceModule(TEST_PERSISTENCE_UNIT_NAME, REPOSITORIES_BASE_PACKAGE_NAME));
		
		ProductService productservice = inject.getInstance(ProductService.class);
		
		productservice.add(new Product(1l, "Ligth bulb"));
        productservice.add(new Product(2l, "Dijon Mustarde"));
        productservice.add(new Product(3l, "Blue Berry"));
        productservice.add(new Product(4l, "Lemon"));
		 System.out.println("Completed");
	}

}



import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.experimental.categories.Category;

import JunitTest.categories1;
import JunitTest.categories2;


public class CategoriesTest {

	@Category(categories1.class)
	@Test
	public void test() {
		
		System.out.println("test");
	}
	
	@Category(categories2.class)
	@Test
	public void fun2() {
		System.out.println("fun2");
	}
	
	

}

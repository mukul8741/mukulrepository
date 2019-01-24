package JunitTest;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.experimental.categories.Category;

@Category(categories1.class)
public class categories2 {

	@Test
	public void test() {
		
		System.out.println("category 2");
	}

}

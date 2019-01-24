

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Categories.IncludeCategory;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

import JunitTest.categories1;
import JunitTest.categories2;

@RunWith(Categories.class)
@IncludeCategory({categories2.class,categories1.class})
@SuiteClasses(CategoriesTest.class)

public class suitTest{
	
}



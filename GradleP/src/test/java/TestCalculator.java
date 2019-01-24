

import calculator.*;

import static org.hamcrest.CoreMatchers.hasItems;

import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.rules.ExpectedException;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.hamcrest.core.Is;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Rule;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import JunitTest.categories1;

//import com.sun.tools.javac.code.Attribute.Array;
//import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.Collections;




/*@RunWith(Parameterized.class)
public class TestCalculator {

	Calculator obj = new Calculator();
	
	@Parameters
	public static Collection<Object>data() {
		Object a[][]= {{2,1,1},{4,2,2},{6,4,2}};
		return Arrays.asList(a);
	}

	private int num1,num2,result;
	public TestCalculator(int result,int num1,int num2) {
		this.result=result;
		this.num1=num1;
	    this.num2=num2;
	}
	
	@Test
	public void test() {
		assertEquals(result,obj.add(num1, num2));
	}
	TestCalculator
}*/
@RunWith(Parameterized.class)
public class TestCalculator{
	@Parameters
	public static Object[] data() {
	    return new Object[] { "first test", "second test" };
	}
    
    
    
  /*  @Parameter(0)
    public  int result;
    @Parameter(1)
    public int num1;
    @Parameter(2)
    public int num2;
	
	*/
	
    
    @Category(categories1.class)
    @Test
    public void test() {
    	/*System.out.println(""+result);
    	System.out.println(""+num1);
    	System.out.println(""+num2);*/
    	//assertEquals(result,Calculator.add(num1, num2));
    }
   
}

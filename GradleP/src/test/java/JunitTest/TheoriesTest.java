package JunitTest;

import static org.junit.Assert.*;
import static org.junit.Assume.assumeThat;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.not;

import org.junit.Test;
import org.junit.experimental.theories.DataPoint;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;


@RunWith(Theories.class)
public class TheoriesTest {

	
	
/*
	public static String Good_name="mukul";
	
	
	public static String bad_name="sin/gh";
	*/
	
	public static String naam = "muklll";
	
	
	@Theory
	public void test(
			@TestedOn(ints = {1,2,3,4}) ) {
		
		System.out.println("up");
		assumeThat(naam,not(containsString("/")));
		assertThat(naam,containsString("muk"));
		System.out.println(naam);
		
			}

}



import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.CoreMatchers.*;

import org.junit.Assert;
import org.junit.ClassRule;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.junit.rules.ExpectedException;
import org.junit.rules.ExternalResource;
import org.junit.rules.TemporaryFolder;
import org.junit.rules.TestName;
import org.junit.rules.TestRule;
import org.junit.rules.Timeout;
import org.junit.rules.Verifier;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import org.junit.runners.Suite;

import com.sun.security.ntlm.Server;


@RunWith(Parameterized.class)
//@Suite.SuiteClasses({CategoriesTest.class,A.class})
//@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class RulesTest {
	
    @Parameters
    public static Collection<Object[]> data() {
	    Object ob[][] = {{3,2,1}, {4,2,2}, {5,3,2}};
	    return Arrays.asList(ob);
    }

    //@Parameter(0)
    private int sum;

    //@Parameter(1)
    private int num1;

    //@Parameter(2)
    private int num2;

    public RulesTest(int sum,int num1,int num2) {
	    this.sum=sum;
	    this.num1=num1;
	    this.num2=num2;
    }

    A obj = new A();
    
    @Test
    public void fun1() {
	    assertEquals(sum, is(obj.add(num1, num2)));
    }

}



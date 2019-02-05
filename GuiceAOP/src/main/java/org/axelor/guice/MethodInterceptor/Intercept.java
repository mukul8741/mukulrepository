package org.axelor.guice.MethodInterceptor;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class Intercept implements MethodInterceptor{

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		
		Object[] temp = invocation.getArguments();
		if(temp[0].equals("Mukul")) {
//			System.out.println("Please Enter Other Name");
			
			temp[0] = "Hemant";
			return invocation.proceed();
//			return null;
		} else {
			return invocation.proceed();

		}
	}

}

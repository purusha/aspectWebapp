package it.at.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class LoggerAspect {
	
	@After(value="execution(public * it.at.NumbersPool.*(..))")
	public void advice() throws Throwable {
		System.out.println("Called instance of NumbersPool ... aspectJ catch this 4u");
	}
	
}

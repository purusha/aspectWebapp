package it.at.aspect;

public aspect ServletLoggerAspect {
	
	after() : execution(protected * it.at.servlet.*.*(..)) {
		String sn = thisJoinPoint.getTarget().getClass().getSimpleName();
		System.out.println("Created instance of Servlet [" + sn + "] ... aspectJ catch this 4u");
	}			
}
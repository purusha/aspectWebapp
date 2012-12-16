package it.at;

import it.at.servlet.AddNumbers;
import it.at.servlet.ListNumbers;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.google.inject.servlet.GuiceServletContextListener;
import com.google.inject.servlet.ServletModule;

public class MyGuiceServletConfig extends GuiceServletContextListener {
	private final Injector i;
	
	public MyGuiceServletConfig() {
		i = Guice.createInjector(guiceModule);
	}
	
	@Override
	protected Injector getInjector() {
		 return i;
	}
	
	private final static Module guiceModule = new ServletModule() {
		@Override
		protected void configureServlets() {
			serve("/add").with(AddNumbers.class);
			serve("/list").with(ListNumbers.class);
		};
    };	
}

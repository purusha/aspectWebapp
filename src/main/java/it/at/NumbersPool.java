package it.at;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

public class NumbersPool {
	
	private static final String SESSION_PARAMETER = "numbers";
	
	@SuppressWarnings("unchecked")
	public List<Integer> getNumbers(HttpSession session) {
		final Object asObject = session.getAttribute(SESSION_PARAMETER);
		
		if (asObject == null) {
			final ArrayList<Integer> l = new ArrayList<Integer>();
			session.setAttribute(SESSION_PARAMETER, l);
			
			return l;
		} else {
			return (List<Integer>)asObject;							
		}		
	}
	
}

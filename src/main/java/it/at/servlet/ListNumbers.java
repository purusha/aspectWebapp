package it.at.servlet;

import it.at.NumbersPool;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Singleton;

@Singleton
public class ListNumbers extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private final NumbersPool pool;
	
	@Inject
	public ListNumbers(Injector inj) {
		pool = inj.getInstance(NumbersPool.class);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		getOrPostHandler(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		getOrPostHandler(req, resp);
	}
	
	private void getOrPostHandler(HttpServletRequest req, HttpServletResponse resp) {	
		final List<Integer> numbers = pool.getNumbers(req.getSession(true));
		
		req.setAttribute("list", numbers);
		
		try {
			req.getRequestDispatcher("list.jsp").include(req, resp);
		} catch (final ServletException e) {
		} catch (final IOException e) {
		}		
	}
}

package it.at.servlet;

import it.at.NumbersPool;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Singleton;

@Singleton
public class AddNumbers extends HttpServlet {
	private static final String REQUEST_PARAMETER = "number";
	private static final long serialVersionUID = 1L;
	
	private final NumbersPool pool;
	
	@Inject
	public AddNumbers(Injector inj) {
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
		final String number = req.getParameter(REQUEST_PARAMETER);
		
		if (StringUtils.isNotBlank(number)) {
			final List<Integer> ns = pool.getNumbers(req.getSession(true));
			
			ns.add(Integer.valueOf(number));	
		}
		
		try {
			resp.sendRedirect("list");
		} catch (final IOException e) {
		}		
	}
}

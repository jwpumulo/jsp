package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MainControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
<<<<<<< HEAD
		// TODO Auto-generated method stub
		
		req.getRequestDispatcher("main/main.tiles").forward(req, resp);
=======
		req.getRequestDispatcher("/WEB-INF/views/main.jsp").forward(req,resp);

>>>>>>> branch 'master' of https://github.com/jwpumulo/jsp.git
	}

}

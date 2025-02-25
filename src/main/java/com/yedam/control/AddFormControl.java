package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddFormControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
<<<<<<< HEAD
		// TODO Auto-generated method stub
		
		req.getRequestDispatcher("board/addForm.tiles").forward(req, resp);
=======
		// 글등록화면 요청재지정.
		req.getRequestDispatcher("/WEB-INF/views/addForm.jsp").forward(req, resp);

>>>>>>> branch 'master' of https://github.com/jwpumulo/jsp.git
	}

}

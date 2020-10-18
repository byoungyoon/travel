package controller;

import service.*;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginAction")
public class LoginAction extends HttpServlet {
	/*
	 * 페이지 사용자가 맞는지 확인(로그인)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		request.getRequestDispatcher("/WEB-INF/views/login/login.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String loginId = request.getParameter("loginId");
		String loginPw = request.getParameter("loginPw");
		
		// 로그인 정보 출력
		System.out.println(loginId + "<-- 사용자 아이디");
		System.out.println(loginPw + "<-- 사용자 비닐번호");
		
		// 로그인 정보 객체에 저장
		Login paramLogin = new Login();
		paramLogin.setLoginId(loginId);
		paramLogin.setLoginPw(loginPw);
		
		LoginDao loginDao = new LoginDao();
		Login login = loginDao.loginCk(paramLogin);
		
		HttpSession session = request.getSession();
		if(login != null) {
			// 로그인이 성공한다면 loginId를 세션으로 입력
			session.setAttribute("loginId", loginId);
			request.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(request, response);
			return;
		}
		request.getRequestDispatcher("/WEB-INF/views/login/login.jsp").forward(request, response);
	}

}









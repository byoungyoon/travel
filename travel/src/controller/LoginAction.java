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
	 * ������ ����ڰ� �´��� Ȯ��(�α���)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		request.getRequestDispatcher("/WEB-INF/views/login/login.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String loginId = request.getParameter("loginId");
		String loginPw = request.getParameter("loginPw");
		
		// �α��� ���� ���
		System.out.println(loginId + "<-- ����� ���̵�");
		System.out.println(loginPw + "<-- ����� ��ҹ�ȣ");
		
		// �α��� ���� ��ü�� ����
		Login paramLogin = new Login();
		paramLogin.setLoginId(loginId);
		paramLogin.setLoginPw(loginPw);
		
		LoginDao loginDao = new LoginDao();
		Login login = loginDao.loginCk(paramLogin);
		
		HttpSession session = request.getSession();
		if(login != null) {
			// �α����� �����Ѵٸ� loginId�� �������� �Է�
			session.setAttribute("loginId", loginId);
			request.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(request, response);
			return;
		}
		request.getRequestDispatcher("/WEB-INF/views/login/login.jsp").forward(request, response);
	}

}









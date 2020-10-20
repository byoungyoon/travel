package travel.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import travel.service.*;
import travel.vo.Login;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	/*
	 * ������ ����ڰ� �´��� Ȯ��(�α���)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		HttpSession session = request.getSession();
		
		// �α��� ������ �ִ��� Ȯ��(���� �� Ȯ��)
		if(session.getAttribute("loginId") != null) {
			System.out.println(session.getAttribute("loginId") + ": �α��� ����");
			request.getRequestDispatcher("/WEB-INF/views/auth/index.jsp").forward(request, response);
			return;
		}
		
		request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String loginId = request.getParameter("loginId");
		String loginPw = request.getParameter("loginPw");
		
		// �α��� ���� ���
		System.out.println(loginId + "<-- ����� ���̵�");
		System.out.println(loginPw + "<-- ����� ��ҹ�ȣ");
		
		LoginService loginService = new LoginService();
		Login login = loginService.getLoginCk(loginId, loginPw);
		
		HttpSession session = request.getSession();
		if(login != null) {
			System.out.println("�α��� ���̵� �������� �߰�");
			session.setAttribute("loginId", loginId);
			request.getRequestDispatcher("/WEB-INF/views/auth/index.jsp").forward(request, response);
			return;
		}
		request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
	}

}









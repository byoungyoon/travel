package travel.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import travel.service.*;
import travel.vo.Login;
import travel.vo.Stats;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	/*
	 * ������ ����ڰ� �´��� Ȯ��(�α���)
	 */
	private StatsService statsService;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		HttpSession session = request.getSession();
		
		// �α��� ������ �ִ��� Ȯ��(���� �� Ȯ��)
		if(session.getAttribute("loginId") != null) {
			System.out.println(session.getAttribute("loginId") + ": �α��� ����");
			statsService = new StatsService();
			
			// �湮�� �� ǥ��
			Map<String, Object> map = statsService.getStats();
			
			Stats stats = (Stats)map.get("stats");
			int sumCnt = (Integer)map.get("sumCnt");
			
			request.setAttribute("stats", stats);
			request.setAttribute("sumCnt", sumCnt);
			
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
			
			// �湮�� �� ǥ��
			statsService = new StatsService();
			Map<String, Object> map = statsService.getStats();
			
			Stats stats = (Stats)map.get("stats");
			int sumCnt = (Integer)map.get("sumCnt");
			
			request.setAttribute("stats", stats);
			request.setAttribute("sumCnt", sumCnt);
			
			request.getRequestDispatcher("/WEB-INF/views/auth/index.jsp").forward(request, response);
			return;
		}
		request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
	}

}









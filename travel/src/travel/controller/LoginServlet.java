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
	 * 페이지 사용자가 맞는지 확인(로그인)
	 */
	private StatsService statsService;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		HttpSession session = request.getSession();
		
		// 로그인 정보가 있는지 확인(세션 값 확인)
		if(session.getAttribute("loginId") != null) {
			System.out.println(session.getAttribute("loginId") + ": 로그인 세션");
			statsService = new StatsService();
			
			// 방문자 수 표시
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
		
		// 로그인 정보 출력
		System.out.println(loginId + "<-- 사용자 아이디");
		System.out.println(loginPw + "<-- 사용자 비닐번호");
		
		LoginService loginService = new LoginService();
		Login login = loginService.getLoginCk(loginId, loginPw);
		
		HttpSession session = request.getSession();
		if(login != null) {
			System.out.println("로그인 아이디를 세션으로 추가");
			session.setAttribute("loginId", loginId);
			
			// 방문자 수 표시
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









package travel.filter;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter("/views/auth/*")
public class LoginFilter implements javax.servlet.Filter {
    public LoginFilter() {}
	public void destroy() {}

	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {		
		HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse)resp;
		
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		System.out.println(session.getAttribute("loginId") + ": 로그인 아이디");
		
		if(session.getAttribute("loginId") == null) {
			System.out.println("로그인 입력 세션의 정보가 없습니다");
			request.getRequestDispatcher("/WEB-INF/views/auth/login.jsp").forward(request, response);
		}
		
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {}

}

package travel.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import travel.dao.CountryDao;
import travel.service.MapService;
import travel.vo.ContinentAndCountry;

import java.util.ArrayList;
import java.util.List;

@WebServlet("/MapServlet")
public class MapServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String continentName = request.getParameter("continentName");
		System.out.println(continentName + "<--- Map");

		MapService mapService = new MapService(new CountryDao());
		
		List<ContinentAndCountry> list = mapService.getSelectCountryByContinent(continentName);
		
		System.out.println(list + "<-- controller list");
		
		request.setAttribute("list", list);
		request.getRequestDispatcher("/WEB-INF/views/auth/index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}

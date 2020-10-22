package travel.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import travel.dao.CountryDao;
import travel.service.MapService;
import travel.vo.Continent;
import travel.vo.ContinentAndCountry;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@WebServlet("/MapServlet")
public class MapServlet extends HttpServlet {
	private MapService mapService;
	
	// ¸Ê¿¡ °üÇÑ get controller
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String continentName = request.getParameter("continentName");
		System.out.println(continentName + "<--- Map");

		mapService = new MapService(new CountryDao());
		
		Map<String, Object> map = mapService.getSelectCountryByContinent(continentName);
		System.out.println(map + "<-- controller list");
		
		List<ContinentAndCountry> list = (List<ContinentAndCountry>)map.get("list");
		Continent continent = (Continent)map.get("continent");
		
		request.setAttribute("list", list);
		request.setAttribute("continent", continent);
		
		request.getRequestDispatcher("/WEB-INF/views/auth/index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}

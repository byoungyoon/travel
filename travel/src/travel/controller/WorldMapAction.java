package travel.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import travel.dao.CountryDao;
import travel.service.*;
import travel.vo.ContinentAndCountry;

import java.util.ArrayList;

@WebServlet("/WorldMapAction")
public class WorldMapAction extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String continentName = request.getParameter("continentName");
		System.out.println(continentName + "<--- worldMap");
		
		CountryDao countryDao = new CountryDao();
		ArrayList<ContinentAndCountry> list = countryDao.selectContinent(continentName);
		
		System.out.println(list + "<---list");
		
		request.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}

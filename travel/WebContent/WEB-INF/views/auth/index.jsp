<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">	
<title>index</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
	<h1>메인 페이지입니다</h1>
	<img src='https://ifh.cc/g/W2BTWK.jpg' usemap="#worldMap">
	<map name="worldMap">
		<area shape="rect" alt="northAmerica" title="" coords="46,46,163,136" href="${pageContext.request.contextPath}/MapServlet?continentName=north america"/>
		<area shape="rect" alt="southAmerica" title="" coords="123,157,189,238" href="${pageContext.request.contextPath}/MapServlet?continentName=south america"/>
		<area shape="rect" alt="europe" title="" coords="222,35,316,112" href="${pageContext.request.contextPath}/MapServlet?continentName=europe"/>
		<area shape="rect" alt="africa" title="" coords="215,125,312,212" href="${pageContext.request.contextPath}/MapServlet?continentName=africa"/>
		<area shape="rect" alt="asia" title="" coords="330,38,479,156" href="${pageContext.request.contextPath}/MapServlet?continentName=asia"/>
		<area shape="rect" alt="australia" title="" coords="370,166,453,235" href="${pageContext.request.contextPath}/MapServlet?continentName=australia"/>
	</map>
	
	<table class="table">
		<thead>
			<tr>
				<th>대륙 이름</th>
				<th>나라 이름</th>
			</tr>
		</thead>
		
		<tbody> 	
			<c:forEach var="b" items="${list}">
				<tr>
					<td></td>
					<td>${b.country.countryName}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>

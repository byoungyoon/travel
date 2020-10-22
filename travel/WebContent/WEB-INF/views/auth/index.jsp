<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<!--

	Design by TEMPLATED
	http://templated.co
	Released for free under the Creative Commons Attribution License

	Name       : Eponymous
	Version    : 1.0
	Released   : 20130222

-->
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta name="keywords" content="" />
        <meta name="description" content="" />
        <meta http-equiv="content-type" content="text/html; charset=utf-8" />
		<title>Travel</title>
        <link href="http://fonts.googleapis.com/css?family=Arvo" rel="stylesheet" type="text/css" />
        <link href="/travel/style.css" rel="stylesheet" type="text/css" />
    </head>
    <body>
		<div id="bg">
			<div id="outer">
				<div id="header">
					<div id="logo">
						<h1>
							<a href="${pageContext.request.contextPath}/IndexServlet">Lets's go travel</a>
						</h1>
					</div>
					<div id="nav">
						<ul>
							<li class="first active">
								<a href="${pageContext.request.contextPath}/IndexServlet">Home</a>
							</li>
							<li>
								<a href="#">Services</a>
							</li>
							<li>
								<a href="#">Blog</a>
							</li>
							<li>
								<a href="#">Portfolio</a>
							</li>
							<li>
								<a href="#">About</a>
							</li>
							<li class="last">
								<a href="#">Contact</a>
							</li>
						</ul>
						<br class="clear" />
					</div>
				</div>
				<div id="banner">
					<img src="images/pic3.jpg" width="1120" height="200" alt="" />
				</div>
				<div id="main">
					<div id="sidebar">
						<h3>
							Travel your life!
						</h3>
						<p>
							A student's project who wants to travel too much. 
							And the manufacturing method used the Model 2 method.
						</p>
						<ul class="linkedList">
							<li class="first">
								<a href="${pageContext.request.contextPath}/IndexServlet">All Map</a>
							</li>
							<li>
								<a href="${pageContext.request.contextPath}/MapServlet?continentName=north america">North America</a>
							</li>
							<li>
								<a href="${pageContext.request.contextPath}/MapServlet?continentName=south america">South america</a>
							</li>
							<li>
								<a href="${pageContext.request.contextPath}/MapServlet?continentName=europe">Europe</a>
							</li>
							<li>
								<a href="${pageContext.request.contextPath}/MapServlet?continentName=africa">Africa</a>
							</li>
							<li>
								<a href="${pageContext.request.contextPath}/MapServlet?continentName=asia">Asia</a>
							</li>
							<li class="last">
								<a href="${pageContext.request.contextPath}/MapServlet?continentName=australia">Australia</a>
							</li>
						</ul>
					</div>
					<div id="content">
						<div id="box1">
						<c:choose>
							<c:when test="${list eq null}">
								<h2>
									World Map
								</h2>
								<br></br>
								<img class="left" usemap="#worldMap" src="https://ifh.cc/g/2srtOW.jpg" width="890" height="410" alt="" />
								<map id="WorldMap" name="worldMap">
									<area shape="rect" alt="" title="" coords="24,20,300,196" href="${pageContext.request.contextPath}/MapServlet?continentName=north america"/>
									<area shape="rect" alt="" title="" coords="146,208,288,386" href="${pageContext.request.contextPath}/MapServlet?continentName=south america"/>
									<area shape="rect" alt="" title="" coords="322,122,494,334" href="${pageContext.request.contextPath}/MapServlet?continentName=africa"/>
									<area shape="rect" alt="" title="" coords="372,38,468,108" href="${pageContext.request.contextPath}/MapServlet?continentName=europe"/>
									<area shape="rect" alt="" title="" coords="500,24,770,260" href="${pageContext.request.contextPath}/MapServlet?continentName=asia"/>
									<area shape="rect" alt="" title="" coords="634,274,806,374" href="${pageContext.request.contextPath}/MapServlet?continentName=australia"/>
									<!-- Created by Online Image Map Editor (http://www.maschek.hu/imagemap/index) -->
								</map>
								<p>
									Please click on the desired area in the photo
								</p>
							</c:when>
							<c:when test="${list ne null}">
								<h2>
									${continent.continentName}
								</h2>
							</c:when>
						</c:choose>
						<br class="clear" />
					</div>
					<br class="clear" />
				</div>
				
			</div>
			<div id="copyright">
				&copy; travel | Made by byoungyoon
			</div>
		</div>
    </body>
</html>

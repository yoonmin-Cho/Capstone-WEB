<%@page import="java.util.*"%>
<%@page import="kr.ac.zebra.dto.*"%>
<%@ page import="java.net.URLEncoder"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="true"%>
<!DOCTYPE>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="description" content="">
	<meta name="author" content="">
	
	<!-- Bootstrap Core JavaScript -->
	<script src="js/bootstrap.min.js"></script>
	
	<spring:url value="/resources/core/css/bootstrap.min.css" var="bootstrapmincss" />
	<spring:url value="/resources/core/css/shop-item.css" var="cssshopitemcss" />
	<spring:url value="/resources/core/css/blog-home" var="bloghome" />
	<link href="${bloghome}" rel="stylesheet" />
	<link href="${bootstrapmincss}" rel="stylesheet" />
	<link href="${cssshopitemcss}" rel="stylesheet" />
	
	<spring:url value="/resources/core/js/jquery.js" var="jsjqueryjs" />
	<script src="${jsjqueryjs}"></script>
	
	<spring:url value="/resources/core/js/bootstrap.min.js" var="jsbootstrapminjs" />
	<script src="${jsbootstrapminjs}"></script>
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.2/jquery.min.js"></script>	
	
	<spring:url value="/resources/core/css/heroic-features" var="heroicfeatures" />
	<link href="${heroicfeatures}" rel="stylesheet" />
	
	<title>purchase</title>
	
</head>

<body>
	<style>
	.auction_btn{
		margin-top: 50px;
		/*background-Color: "#880000";*/
		width: 200px;
		height: 70px;
		font-weight:bold;   
		color:#ffffff;    
		border: 0;
		outline: 0;
	}
	
	.g_market_btn{
		margin-top: 30px;
		/*background-Color: "#299824";*/
		width: 200px;
		height: 70px;
		font-weight:bold;   
		color:#ffffff;    
		border: 0;
		outline: 0;
	}
	
	.eleven_st_btn{
		margin-top: 30px;
		/*background-Color: "#E93E35";*/
		width: 200px;
		height: 70px;
		font-weight:bold;   
		color:#ffffff;    
		border: 0;
		outline: 0;
	}
	</style>

	<!-- Navigation bar -->
	<jsp:include page="topNavigation.jsp" flush="false"></jsp:include>

	<div style="margin-top: 50px; margin-bottom: 20px;"></div>

	<jsp:include page="search.jsp" flush="false"></jsp:include>
	
	<jsp:include page="category.jsp"></jsp:include>
	
	<%
		request.setCharacterEncoding("UTF-8");
		String productName = (String)session.getAttribute("productName");
	%>
	
	<div class="container" style="padding-top: 50px">
		<div class="col-md-8">
			<div class="row">
				<div class="col-md-6" style="width: 500px">
					<img class="img-responsive" src="${productInfo.productUrl}" alt="" align="middle" style="width: 300px; height: 350px;">
				</div>
				
				<div class="col-md-6">
						<br/>
						<h2 style="font-weight: bolder;">
							<c:out value="${productInfo.productName}"></c:out>
						</h2>
						<p>
							<c:out value="${productInfo.description}"></c:out>
						</p>
				</div>
				
				<!-- button click and move to shopping mall -->
				
				<input class="auction_btn" style="background-color:#880000;" type="button" value="옥션에서 구매하기 "
					onclick="location.href='http://search.auction.co.kr/search/search.aspx?keyword=<%=URLEncoder.encode(productName,"euc-kr")%>'">
				
				<input class="g_market_btn" style="background-color:#299824;" type="button" value="G-market 에서 구매하기"
					onclick="location.href='http://search.gmarket.co.kr/search.aspx?keyword=<%=URLEncoder.encode(productName,"euc-kr")%>'">
				
				<input class="eleven_st_btn" style="background-color:#E93E35;"type="button" value="11번가에서 구매하기"
					onclick="location.href='http://search.11st.co.kr/SearchPrdAction.tmall?method=getTotalSearchSeller&kwd=<%=URLEncoder.encode(productName,"euc-kr")%>'">
			</div>
		</div>
	</div> 
</body>
</html>
<%@page import="kr.ac.zebra.dto.*"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="org.json.simple.*"%>
<%@ page session="true"%>

<%
	request.setCharacterEncoding("UTF-8");
	List<Product> products = (List<Product>) request.getAttribute("products");

	JSONObject jObject = new JSONObject();
	jObject.put("productInfo", products);

	out.println(jObject.toJSONString());
%>
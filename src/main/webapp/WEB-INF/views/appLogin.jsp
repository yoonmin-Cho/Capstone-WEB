<%@page import="kr.ac.zebra.dto.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="org.json.simple.*"%>
<%@ page session="true"%>

<%
	String str = "로그인성공";
	// 데이터를 안드로이드에서 받음
	request.setCharacterEncoding("UTF-8");

	CommonUser user = (CommonUser) request.getAttribute("user");

	// 초기 선언	
	JSONObject jObject = new JSONObject();

	// 안드로이드로 보낼 메시지를 만듬
	jObject.put("user", user);

	// 안드로이드에 보낼 데이터를 출력
	out.println(jObject.toJSONString());
%>
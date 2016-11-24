<%@page import="kr.ac.zebra.dto.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="org.json.simple.*"%>
<%@ page session="true"%>

<%
	
	request.setCharacterEncoding("UTF-8");
	//데이터를 안드로이드에서 받음
	String result = (String) request.getAttribute("result");

	// 초기 선언	
	JSONObject jObject = new JSONObject();
	// 안드로이드로 보낼 메시지를 만듬
	jObject.put("result", result);

	// 안드로이드에 보낼 데이터를 출력
	out.println(jObject);
%>
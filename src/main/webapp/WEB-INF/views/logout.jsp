<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<%	
		String nowName = (String)session.getAttribute("name");

		session.removeAttribute("name");
		session.removeAttribute("loginUser");
		
		session.invalidate();	

		String msg = null;
		msg = nowName + "님 안녕히 가세요";
	%>
	
	<script type="text/javascript">
		alert("<%= msg %>");
		location.href="/ZEBRA";
	</script>
</body>
</html>
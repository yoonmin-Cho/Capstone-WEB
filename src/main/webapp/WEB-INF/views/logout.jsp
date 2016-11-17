<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<%
		String nowName = (String) session.getAttribute("userName");

		/*
		session.removeAttribute("logOk");
		session.removeAttribute("user");
		session.removeAttribute("userName");
		*/
		session.invalidate();

		String msg = null;
		msg = nowName + "님 안녕히 가세요";
	%>

	<script type="text/javascript">
		alert("<%=msg%>");
		location.href = "/ZEBRA";
	</script>
</body>
</html>
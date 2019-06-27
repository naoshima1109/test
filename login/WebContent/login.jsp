<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン画面</title>
</head>
<body>
	<s:form action="LoginAction"> <!-- "name"と”password"を"LoginAction"に"submit"(送信) -->
		<s:textfield name="name"/>
		<s:password name="password"/>
		<s:submit value="ログイン"/>
	</s:form>

</body>
</html>
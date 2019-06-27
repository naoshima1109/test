<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="Content-Style-Type" content="text/css" />
	<meta http-equiv="Content-Script-Type"content="text/javascript" />
	<meta http-equiv="imagetoolbar" content="no" />
	<meta name="description" content=""/>
	<meta name="keywords" content=""/>
<title>Admin画面</title>

	<style type="text/css">
	body{
	margin:0;
	padding:0;
	line-height:1.6;
	letter-spacing:1px;
	font-family:Verdana,Helvetica,sans-serif;
	font-size:12px;
	color:#333
	background:#fff;
	}

	table{
	text-align:center;
	margin:0 auto;
	}

	/*========ID LAYOUT========*/
	#top{
	width:780px;
	margin:30px auto;
	border:1px solid #333;
	}

	#header{
	width:100%;
	height:80px;
	background-color: black;
	}

	#main{
	width:100%;
	height:500px;
	text-align:center;
	}

	#left{
	border:1px solid #333;
	margin-left:26px;
	padding-bottom:10px;
	width:385px;
	float:left;
	text-align:center;
	}

	#right{
	width:385px;
	margin-right:25px;
	padding-bottom:10px;
	float:right;
	text-align:center;
	border:1px solid #333;
	}

	#contents{
	width:100%;
	}

	#footer{
	width:100%;
	height:80px;
	background-color:black;
	clear:both;
	}
	</style>

</head>
<body>
	<div id="header">
	</div>
	<div id="main">
		<div id="top">
			<p>管理者画面</p>
		</div>
		<div id="contents">
			<div id="left">
				<p>商品</p>
				<s:form action="ItemCreateAction">
					<s:submit value="新規登録"/>
				</s:form>
				<s:form action="ItemListAction">
					<s:submit value="一覧"/>
				</s:form>
			</div>
			<div id="right">
				<p>ユーザー</p>
				<s:form action="UserCreateAction">
					<s:submit value="新規登録"/>
				</s:form>
				<s:form action="UserCreateAction">
					<s:submit value="一覧"/>
				</s:form>
			</div>
		</div>
	</div>
	<div id="footer">
	</div>
</body>
</html>
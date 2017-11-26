<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body style="background-color: #d3ccb8">
	<div id="banner">
		<div id="wrapper" style="width: 100%; overflow: hidden;">
			<div id="container" style="width: 100%; margin-right: auto;">
				<img style="width: 100%;" src="https://i.imgur.com/p0McYtw.jpg" />
			</div>
		</div>
	</div>
<font size="5">Personal Flash Card Sets</font>
		<table align="center">
		<tr>
		<th>FlashCardSet</th>
		<th>Public</th>
		<th>View</th>
		<th>Edit</th>
		<th>Print</th>
		</tr>
		<tr></tr>
		<c:forEach var="FlashCardSet" items="{FlashCardList}">
					<td><a href="FlashCardSet.Name"></a></td>, <td><a href="FlashCardSet.SetPublic"></a></td>, <td><a href="FlashCardSet.View"></a></td>, <td><a href="FlashCardSet.Edit"></a></td>, <td><a href="FlashCardSet.Print"></a></td><tr></tr>
			</c:forEach>
	</table>
		<table align="center">
		<tr>
			<td><a href="Create"></a></td>
		</tr>
	</table>
<font size ="5">Public Flash Card Sets</font>
	<table align="center">
	<tr>
		<th>FlashCardSet</th>
		<th>View</th>
		<th>Print</th>
		</tr>
		<tr></tr>
		<c:forEach var="PublicFlashCardSets" items="{PublicFlashCardList}">
					<td><a href="FlashCardSet.Name"></a></td>, <td><a href="FlashCardSet.Print"></a></td>, <tr></tr>
		</c:forEach>
	</table>
</body>
</html>
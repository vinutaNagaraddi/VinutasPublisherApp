<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<title>Hello World!</title>
<head>
</head>
<body>

<s:url action="listMagazines" namespace="magazine" id="listMagazines"/>
<s:a href="%{listMagazines}">List all Magazine</s:a>
<p/>
<s:url action="listBooks" namespace="book" id="listBooks"/>
<s:a href="%{listBooks}">List all Books</s:a>
<p/>
<s:url action="listOffices" namespace="office" id="listOffices"/>
<s:a href="%{listOffices}">List all Offices</s:a>

</body>
</html>
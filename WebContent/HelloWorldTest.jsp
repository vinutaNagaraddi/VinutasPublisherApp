<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<title>Hello World!</title>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
<p><a href="<s:url action='magazine/addMagazine'/>">Add Magazine</a></p>
<p><a href="<s:url action='magazine/updateMagazine'/>">Update Magazine</a></p>
<p><a href="<s:url action='magazine/deleteMagazine'/>">Delete Magazine</a></p>
<p><a href="<s:url action='magazine/listMagazines'/>">List all Magazine</a></p>

<p><a href="<s:url action='book/addBook'/>">Add Book</a></p>
<p><a href="<s:url action='book/updateBook'/>">Update Book</a></p>
<p><a href="<s:url action='book/deleteBook'/>">Delete Book</a></p>
<p><a href="<s:url action='book/listBooks'/>">List all Book</a></p>

<p><a href="<s:url action='office/addOffice'/>">Add Office</a></p>
<p><a href="<s:url action='office/updateOffice'/>">Update Office</a></p>
<p><a href="<s:url action='office/deleteOffice'/>">Delete Office</a></p>
<p><a href="<s:url action='office/listOffices'/>">List all Office</a></p>


</body>
</html>
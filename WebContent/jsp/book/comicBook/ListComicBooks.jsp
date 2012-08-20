<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<title>List all ComicBooks</title>
<link rel="stylesheet" type="text/css" href="../css/main.css"/>
</head>
<body>
	<s:form theme="simple">
		<table>
			<tr >
				<th colspan="4">
					<s:property value="%{getText('listComicBooks.heading')}"/>
				</th>
			</tr>
			<tr>
				<th><s:property value="%{getText('comicBook.id')}"/></th>
				<th><s:property value="%{getText('comicBook.name')}"/></th>
				<th><s:property value="%{getText('comicBook.publishDate')}"/></th>
				<th><s:property value="%{getText('label.action')}"/></th>
			</tr>
			<s:iterator value="comicBooks" status="rowstatus">
				<tr>
			    	<td><s:property value="id"/></td>
			    	<td><s:property value="name"/></td>
			    	<td>
			    		<s:set name="#formatedComicBookPublishDate" value=""/>
						<s:date name="publishDate" var="#formatedComicBookPublishDate" format = "MM/dd/yyyy"/>
			    		<s:property value="#formatedComicBookPublishDate"/>
			    	</td>
			    	<td>
			    		<s:url action="showComicBookDetails"  id="showComicBookDetails">
							<s:param name="comicBook.id" value="id"/>
						</s:url>
						<s:url action="showUpdateComicBookJSP" id="showUpdateComicBookJSP">
							<s:param name="comicBook.id" value="id"/>
						</s:url>
						<s:url action="deleteComicBook" id="deleteComicBook">
							<s:param name="comicBook.id" value="id"/>
						</s:url>
			    		<s:a href="%{showComicBookDetails}"><s:property value="%{getText('label.details')}"/></s:a>
			    		<s:a href="%{showUpdateComicBookJSP}"><s:property value="%{getText('label.update')}"/></s:a>
			    		<s:a href="%{deleteComicBook}"><s:property value="%{getText('label.delete')}"/></s:a>
			    	</td>
			  	</tr>
			</s:iterator>
			<tr>
				<td colspan="4" align="center">
					<s:submit action="showAddComicBookJSP"  key="label.addComicBook"/>
				</td>
			</tr>
			<tr>
				<td colspan="4" align="center">
					<s:url action="homePage" namespace="/home" id="homeLink"/>
					<s:a href="%{homeLink}">Home</s:a>
				</td>
			</tr>
		</table>
	</s:form>
</body>
</html>



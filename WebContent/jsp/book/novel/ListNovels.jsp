<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<title>List all Novels</title>
<link rel="stylesheet" type="text/css" href="../css/main.css"/>
</head>
<body>
	<s:form theme="simple">
		<table>
			<tr >
				<th colspan="4">
					<s:property value="%{getText('listNovels.heading')}"/>
				</th>
			</tr>
			<tr>
				<th><s:property value="%{getText('novel.id')}"/></th>
				<th><s:property value="%{getText('novel.name')}"/></th>
				<th><s:property value="%{getText('novel.publishDate')}"/></th>
				<th><s:property value="%{getText('label.action')}"/></th>
			</tr>
			<s:iterator value="novels" status="rowstatus">
			<tr>
		    	<td><s:property value="id"/></td>
		    	<td><s:property value="name"/></td>
		    	<td>
		    		<s:set name="#formatedPublishDate" value=""/>
					<s:date name="publishDate" var="#formatedPublishDate" format = "MM/dd/yyyy"/>
		    		<s:property value="#formatedPublishDate"/>
		    	</td>
		    	<td>
		    		<s:url action="showNovelDetails"  id="showNovelDetails">
						<s:param name="novel.id" value="id"/>
					</s:url>
					<s:url action="showUpdateNovelJSP" id="showUpdateNovelJSP">
						<s:param name="novel.id" value="id"/>
					</s:url>
					<s:url action="deleteNovel" id="deleteNovel">
						<s:param name="novel.id" value="id"/>
					</s:url>
		    		<s:a href="%{showNovelDetails}"><s:property value="%{getText('label.details')}"/></s:a>
		    		<s:a href="%{showUpdateNovelJSP}"><s:property value="%{getText('label.update')}"/></s:a>
		    		<s:a href="%{deleteNovel}"><s:property value="%{getText('label.delete')}"/></s:a>
		    	</td>
		  	</tr>
			</s:iterator>
			<tr>
				<td colspan="4" align="center">
					<s:submit action="showAddNovelJSP"  key="label.addNovel"/>
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



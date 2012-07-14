<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<title>Detail Comic Book</title>
<link rel="stylesheet" type="text/css" href="../css/main.css"/>
</head>
<body>
	<h3><s:property value="%{getText('detailComicBook.heading')}"/></h3>
	<s:fielderror/>
	<s:form theme="simple">
		<table>
			<tr>	
				<td>
					<s:property value="%{getText('comicBook.name')}"/>
				</td>
				<td>
					<s:property value="comicBook.name"/>
				</td>
			</tr>
			<tr>	
				<td>
					<s:property value="%{getText('comicBook.price')}"/>
				</td>
				<td>
					<s:property value="comicBook.price" />
				</td>
			</tr>
			<tr>	
				<td>
					<s:property value="%{getText('comicBook.publishDate')}"/>
				</td>
				<td>
					<s:date name="comicBook.publishDate" var="formatedPublishDate" format = "MM/dd/yyyy"/>
	    			<s:property value="#formatedPublishDate"/>
				</td>
			</tr>
			<s:iterator value='comicBook.authors' status="authorStat"> 
				<tr>	
					<td>
						<s:property value="%{getText('label.author')}"/>
						<s:property value="%{#authorStat.count}"/>
					</td>
					<td>
						<%@ include file="../../author/DetailAuthorForComicBook.jsp" %>
					</td>
				</tr>
			</s:iterator>
			<tr>
				<td colspan="2"  align="center">
					<s:submit action="listBooks" namespace="book" value="List Books"/>
				</td>
			</tr>
		</table>
	</s:form>
</body>
</html>

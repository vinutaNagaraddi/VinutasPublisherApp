<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<title>Magazine Details</title>
<link rel="stylesheet" type="text/css" href="../css/main.css"/>
</head>
<body>
	<h3><s:property value="%{getText('detailMagazine.heading')}"/></h3>
	<s:form theme="simple">
		<table>
			<tr>	
				<td>
					<s:property value="%{getText('magazine.name')}"/>
				</td>
				<td>
					<s:property value="magazine.name"/>
				</td>
			</tr>
			<tr>	
				<td>
					<s:property value="%{getText('magazine.price')}"/>
				</td>
				<td>
					<s:property value="magazine.price"/>
				</td>
			</tr>
			<tr>	
				<td>
					<s:property value="%{getText('magazine.avOnline')}"/>
				</td>
				<td>
					<s:checkbox key="magazine.availableOnline" disabled="true"/>
				</td>
			</tr>
			<tr>	
				<td>
					<s:property value="%{getText('magazine.publishDate')}"/>
				</td>
				<td>
					<s:date name="magazine.publishDate" var="formatedPublishDate" format = "MM/dd/yyyy"/>
	    			<s:property value="#formatedPublishDate"/>
				</td>
			</tr>
			<s:iterator value='magazine.articles' status="articleStat"> 
			<tr>	
				<td>
					<s:property value="%{getText('label.article')}"/>
					<s:property value="%{#articleStat.count}"/>
				</td>
				<td>
					<%@ include file="../article/DetailArticle.jsp" %>
				</td>
			</tr>
			</s:iterator>
			<tr>
				<td colspan="2"  align="center">
					<s:submit action="listMagazines" key="label.listMagazines"/>
				</td>
			</tr>
		</table>
	</s:form>
</body>
</html>

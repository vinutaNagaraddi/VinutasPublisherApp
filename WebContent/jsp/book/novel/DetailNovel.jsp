<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<title>Detail Novel</title>
<link rel="stylesheet" type="text/css" href="../css/main.css"/>
</head>
<body>
	<h3><s:property value="%{getText('detailNovel.heading')}"/></h3>
	<s:fielderror/>
	<s:form theme="simple">
		<table>
			<tr>	
				<td>
					<s:property value="%{getText('novel.name')}"/>
				</td>
				<td>
					<s:property value="novel.name"/>
				</td>
			</tr>
			<tr>	
				<td>
					<s:property value="%{getText('novel.isbn')}"/>
				</td>
				<td>
					<s:property value="novel.isbn"/>
				</td>
			</tr>
			<tr>	
				<td>
					<s:property value="%{getText('novel.price')}"/>
				</td>
				<td>
					<s:property value="novel.price" />
				</td>
			</tr>
			<tr>	
				<td>
					<s:property value="%{getText('novel.publishDate')}"/>
				</td>
				<td>
					<s:date name="novel.publishDate" var="formatedPublishDate" format="MM/dd/yyyy"/>
	    			<s:property value="#formatedPublishDate"/>
				</td>
			</tr>
			<s:iterator value='novel.authors' 
						status="authorStat"> 
			<tr>	
				<td>
					<s:property value="%{getText('label.author')}"/>
					<s:property value="%{#authorStat.count}"/>
				</td>
				<td>
					<%@ include file="../../author/DetailAuthorForNovel.jsp" %>
				</td>
			</tr>
			</s:iterator>
			<s:iterator value='novel.chapters' 
						status="chapterStat"> 
			<tr>	
				<td>
					<s:property value="%{getText('label.chapter')}"/>
					<s:property value="%{#chapterStat.count}"/>
				</td>
				<td>
					<%@ include file="../../chapter/DetailChapter.jsp" %>
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

<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<title>Update Novel</title>
<style type="text/css">@import url(css/main.css);</style>
</head>
<body>
	<h3><s:property value="%{getText('updateNovel.heading')}"/></h3>
	<s:fielderror/>
	<s:form theme="simple">
		<s:hidden name="novel.id" />
		<s:hidden name="novel.version" />
		<table>
			<tr>	
				<td class="requiredField">
					<s:property value="%{getText('novel.name')}"/>
				</td>
				<td>
					<s:textfield key="novel.name"/>
				</td>
			</tr>
			<tr>	
				<td>
					<s:property value="%{getText('novel.isbn')}"/>
				</td>
				<td>
					<s:textfield key="novel.isbn"/>
				</td>
			</tr>
			<tr>	
				<td>
					<s:property value="%{getText('novel.price')}"/>
				</td>
				<td>
					<s:textfield  key="novel.price" />
				</td>
			</tr>
			<tr>	
				<td>
					<s:property value="%{getText('novel.publishDate')}"/>
				</td>
				<td>
					<s:date name="novel.publishDate" format="MM/dd/yyyy" var="myDateVar"/>
					<s:if test="%{#myDateVar==null}">
						<s:textfield key="novel.publishDate"/>
					</s:if>
					<s:else>
						<s:textfield key="novel.publishDate" value="%{#myDateVar}"/>
					</s:else>	
				</td>
			</tr>
			<s:iterator value='new int[@main.java.com.vinuta.action.BookAction@NO_OF_AUTHORS]' 
						status="authorStat"> 
			<tr>	
				<td>
					<s:property value="%{getText('label.author')}"/>
					<s:property value="%{#authorStat.count}"/>
				</td>
				<td>
					<%@ include file="../../author/AuthorForNovel.jsp" %>
				</td>
			</tr>
			</s:iterator>
			<s:iterator value='new int[@main.java.com.vinuta.action.BookAction@NO_OF_CHAPTERS]' 
						status="chapterStat"> 
			<tr>	
				<td>
					<s:property value="%{getText('label.chapter')}"/>
					<s:property value="%{#chapterStat.count}"/>
				</td>
				<td>
					<%@ include file="../../chapter/Chapter.jsp" %>
				</td>
			</tr>
			</s:iterator>
			<tr>
				<td colspan="2"  align="center">
					<s:submit action="updateNovel" namespace="book" key="label.update"/>
					<s:submit action="listBooks" namespace="book" key="label.cancel"/>
				</td>
			</tr>
		</table>
	</s:form>
</body>
</html>

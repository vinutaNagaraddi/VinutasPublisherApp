<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<title>Add Comic Book</title>
<style type="text/css">@import url(css/main.css);</style>
</head>
<body>
	<h3><s:property value="%{getText('addComicBook.heading')}"/></h3>
	<s:fielderror/>
	<s:form theme="simple">
		<table>
			<tr>	
				<td class="requiredField">
					<s:property value="%{getText('comicBook.name')}"/>
				</td>
				<td>
					<s:textfield key="comicBook.name"/>
				</td>
			</tr>
			<tr>	
				<td>
					<s:property value="%{getText('comicBook.price')}"/>
				</td>
				<td>
					<s:textfield  key="comicBook.price" />
				</td>
			</tr>
			<tr>	
				<td>
					<s:property value="%{getText('comicBook.publishDate')}"/>
				</td>
				<td>
					<s:date name="comicBook.publishDate" format="MM/dd/yyyy" var="myDateVar"/>
					<s:if test="%{#myDateVar==null}">
						<s:textfield key="comicBook.publishDate"/>
					</s:if>
					<s:else>
						<s:textfield key="comicBook.publishDate" value="%{#myDateVar}"/>
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
					<%@ include file="../../author/AuthorForComicBook.jsp" %>
				</td>
			</tr>
			</s:iterator>
			<tr>
				<td colspan="2"  align="center">
					<s:submit action="addComicBook" namespace="book" key="label.add"/>
					<s:submit action="listBooks" namespace="book" key="label.cancel"/>
				</td>
			</tr>
		</table>
	</s:form>
</body>
</html>

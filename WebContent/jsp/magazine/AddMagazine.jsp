<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<title>Add Magazine</title>
<style type="text/css">@import url(css/main.css);</style>
</head>
<body>
	<h3><s:property value="%{getText('addMazine.heading')}"/></h3>
	<s:fielderror/>
	<s:form theme="simple">
		<table>
			<tr>	
				<td class="requiredField">
					<s:property value="%{getText('magazine.name')}"/>
				</td>
				<td>
					<s:textfield key="magazine.name"/>
				</td>
			</tr>
			<tr>	
				<td>
					<s:property value="%{getText('magazine.price')}"/>
				</td>
				<td>
					<s:textfield  key="magazine.price" />
				</td>
			</tr>
			<tr>	
				<td>
					<s:property value="%{getText('magazine.avOnline')}"/>
				</td>
				<td>
					<s:checkbox key="magazine.availableOnline"/>
				</td>
			</tr>
			<tr>	
				<td class="requiredField">
					<s:property value="%{getText('magazine.publishDate')}"/>
				</td>
				<td>
					<s:date name="magazine.publishDate" format="MM/dd/yyyy" var="myDateVar"/>
					<s:if test="%{#myDateVar==null}">
						<s:textfield key="magazine.publishDate"/>
					</s:if>
					<s:else>
						<s:textfield key="magazine.publishDate" value="%{#myDateVar}"/>
					</s:else>	
				</td>
			</tr>
			<s:iterator value='new int[@main.java.com.vinuta.action.MagazineAction@NO_OF_ARTICLES]' 
						status="articleStat"> 
			<tr>	
				<td>
					<s:property value="%{getText('label.article')}"/>
					<s:property value="%{#articleStat.count}"/>
				</td>
				<td>
					<%@ include file="../article/Article.jsp" %>
				</td>
			</tr>
			</s:iterator>
			<tr>
				<td colspan="2"  align="center">
					<s:submit action="addMagazine" namespace="magazine" key="label.add"/>
					<s:submit action="listMagazines" namespace="magazine" key="label.cancel"/>
				</td>
			</tr>
		</table>
	</s:form>
</body>
</html>

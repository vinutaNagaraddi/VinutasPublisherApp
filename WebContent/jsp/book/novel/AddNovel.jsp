<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<title>Add Novel</title>
<style type="text/css">@import url(css/main.css);</style>
</head>
<body>
	<h3><s:property value="%{getText('addNovel.heading')}"/></h3>
	<s:fielderror/>
	<s:form theme="simple">
		<table>
			<%@ include file="Novel.jsp" %>
			<tr>
				<td colspan="2"  align="center">
					<s:submit action="addNovel" namespace="book" key="label.add"/>
					<s:submit action="listBooks" namespace="book" key="label.cancel"/>
				</td>
			</tr>
		</table>
	</s:form>
</body>
</html>

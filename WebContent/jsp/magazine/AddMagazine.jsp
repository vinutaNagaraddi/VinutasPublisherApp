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
			<%@ include file="Magazine.jsp" %>
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

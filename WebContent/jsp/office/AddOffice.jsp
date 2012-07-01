<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<title>Add Publishing Office Branch</title>
<style type="text/css">@import url(css/main.css);</style>
</head>
<body>
	<h3><s:property value="%{getText('addOffice.heading')}"/></h3>
	<s:fielderror/>
	<s:form theme="simple">
		<table>
			<%@ include file="Office.jsp" %>
			<tr>
				<td colspan="2"  align="center">
					<s:submit action="addOffice" namespace="office" key="label.add"/>
					<s:submit action="listOffices" namespace="office" key="label.cancel"/>
				</td>
			</tr>
		</table>
	</s:form>
</body>
</html>

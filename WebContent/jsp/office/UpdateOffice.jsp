<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<title>Update Publishing Office Branch</title>
<style type="text/css">@import url(css/main.css);</style>
</head>
<body>
	<h3><s:property value="%{getText('updateOffice.heading')}"/></h3>
	<s:fielderror/>
	<s:form theme="simple">
		<s:hidden name="office.id" />
		<s:hidden name="office.version" />
		<s:hidden name="office.address.id" />
		<table>
			<%@ include file="Office.jsp" %>
			<tr>
				<td colspan="2"  align="center">
					<s:submit action="updateOffice" namespace="office" key="label.add"/>
					<s:submit action="listOffices" namespace="office" key="label.cancel"/>
				</td>
			</tr>
		</table>
	</s:form>
</body>
</html>
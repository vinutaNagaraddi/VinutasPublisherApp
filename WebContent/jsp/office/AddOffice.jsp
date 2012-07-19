<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<title>Add Publishing Office Branch</title>
<link rel="stylesheet" type="text/css" href="../css/main.css"/>
</head>
<body>
	<h3><s:property value="%{getText('addOffice.heading')}"/></h3>
	<s:actionerror/>
	<s:fielderror/>
	<s:form theme="simple">
		<table>
			<%@ include file="Office.jsp" %>
			<tr>
				<td colspan="2"  align="center">
					<s:submit action="addOffice"  key="label.add"/>
					<s:submit action="listOffices" key="label.cancel"/>
				</td>
			</tr>
		</table>
	</s:form>
</body>
</html>

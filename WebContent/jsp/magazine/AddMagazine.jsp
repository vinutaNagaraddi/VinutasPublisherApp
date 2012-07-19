<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<title>Add Magazine</title>
<link rel="stylesheet" type="text/css" href="../css/main.css"/>
</head>
<body>
	<h3><s:property value="%{getText('addMazine.heading')}"/></h3>
	<s:fielderror/>
	<s:actionerror/>
	<s:form theme="simple">
		<table>
			<%@ include file="Magazine.jsp" %>
			<tr>
				<td colspan="2"  align="center">
					<s:submit action="addMagazine" key="label.add"/>
					<s:submit action="listMagazines" key="label.cancel"/>
				</td>
			</tr>
		</table>
	</s:form>
</body>
</html>

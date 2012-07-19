<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<title>Update Magazine</title>
<link rel="stylesheet" type="text/css" href="../css/main.css"/>
</head>
<body>
	<h3><s:property value="%{getText('updateMazine.heading')}"/></h3>
	<s:actionerror/>
	<s:fielderror/>
	<s:form theme="simple">
		<s:hidden name="magazine.id" />
		<s:hidden name="magazine.version" />
		<table>
			<%@ include file="Magazine.jsp" %>
			<tr>
				<td colspan="2"  align="center">
					<s:submit action="updateMagazine" key="label.update"/>
					<s:submit action="listMagazines" key="label.cancel"/>
				</td>
			</tr>
		</table>
	</s:form>
</body>
</html>

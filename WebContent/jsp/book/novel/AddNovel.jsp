<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<title>Add Novel</title>
<link rel="stylesheet" type="text/css" href="../css/main.css"/>
</head>
<body>
	<h3><s:property value="%{getText('addNovel.heading')}"/></h3>
	<s:actionerror/>
	<s:fielderror/>
	<s:form theme="simple">
		<table>
			<%@ include file="Novel.jsp" %>
			<tr>
				<td colspan="2"  align="center">
					<s:submit action="addNovel" key="label.add"/>
					<s:submit action="listBooks" key="label.cancel"/>
				</td>
			</tr>
		</table>
	</s:form>
</body>
</html>

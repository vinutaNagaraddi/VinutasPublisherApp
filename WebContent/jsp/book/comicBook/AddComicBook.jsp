<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<title>Add Comic Book</title>
<link rel="stylesheet" type="text/css" href="../css/main.css"/>
</head>
<body>
	<h3><s:property value="%{getText('addComicBook.heading')}"/></h3>
	<s:actionerror/>
	<s:fielderror/>
	<s:form theme="simple" enctype="multipart/form-data">
		<table>
			<%@ include file="ComicBook.jsp" %>
			<tr>
				<td colspan="2"  align="center">
					<s:submit action="addComicBook" key="label.add"/>
					<s:submit action="listComicBooks" key="label.cancel"/>
				</td>
			</tr>
		</table>
	</s:form>
</body>
</html>

<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<title>Update Comic Book</title>
<style type="text/css">@import url(css/main.css);</style>
</head>
<body>
	<h3><s:property value="%{getText('updateComicBook.heading')}"/></h3>
	<s:fielderror/>
	<s:form theme="simple">
		<s:hidden name="comicBook.id" />
		<s:hidden name="comicBook.version" />
		<table>
			<%@ include file="ComicBook.jsp" %>
			<tr>
				<td colspan="2"  align="center">
					<s:submit action="updateComicBook" namespace="book" key="label.update"/>
					<s:submit action="listBooks" namespace="book" key="label.cancel"/>
				</td>
			</tr>
		</table>
	</s:form>
</body>
</html>

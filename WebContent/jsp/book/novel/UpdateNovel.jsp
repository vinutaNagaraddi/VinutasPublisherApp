<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<title>Update Novel</title>
<style type="text/css">@import url(css/main.css);</style>
</head>
<body>
	<h3><s:property value="%{getText('updateNovel.heading')}"/></h3>
	<s:fielderror/>
	<s:form theme="simple">
		<s:hidden name="novel.id" />
		<s:hidden name="novel.version" />
		<s:hidden name="%{'novel.chapters['+#chapterStat.index+'].id'}"/>
		<s:hidden name="%{'novel.chapters['+#chapterStat.index+'].version'}"/>
		<table>
			<%@ include file="Novel.jsp" %>
			<tr>
				<td colspan="2"  align="center">
					<s:submit action="updateNovel" namespace="book" key="label.update"/>
					<s:submit action="listBooks" namespace="book" key="label.cancel"/>
				</td>
			</tr>
		</table>
	</s:form>
</body>
</html>

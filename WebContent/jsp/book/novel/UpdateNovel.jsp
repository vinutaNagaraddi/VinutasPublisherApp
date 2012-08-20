<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<title>Update Novel</title>
<link rel="stylesheet" type="text/css" href="../css/main.css"/>
</head>
<body>
	<h3><s:property value="%{getText('updateNovel.heading')}"/></h3>
	<s:actionerror/>
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
					<s:submit action="updateNovel" key="label.update"/>
					<s:submit action="listNovels" key="label.cancel"/>
				</td>
			</tr>
		</table>
	</s:form>
</body>
</html>

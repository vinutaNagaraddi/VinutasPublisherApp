<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<title>Update Magazine</title>
<style type="text/css">@import url(css/main.css);</style>
</head>
<body>
	<h3><s:property value="%{getText('updateMazine.heading')}"/></h3>
	<s:fielderror/>
	<s:form theme="simple">
		<s:hidden name="magazine.id" />
		<s:hidden name="magazine.version" />
		<s:hidden name="%{'magazine.articles['+#articleStat.index+'].id'}" />
		<s:hidden name="%{'magazine.articles['+#articleStat.index+'].version'}"/>
		<table>
			<%@ include file="Magazine.jsp" %>
			<tr>
				<td colspan="2"  align="center">
					<s:submit action="updateMagazine" namespace="magazine" key="label.update"/>
					<s:submit action="listMagazines" namespace="magazine" key="label.cancel"/>
				</td>
			</tr>
		</table>
	</s:form>
</body>
</html>

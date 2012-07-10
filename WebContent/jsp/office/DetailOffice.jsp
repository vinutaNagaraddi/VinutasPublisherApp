<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<title>Office Details</title>
<style type="text/css">@import url(css/main.css);</style>
</head>
<body>
	<h3><s:property value="%{getText('detailOffice.heading')}"/></h3>
	<s:form theme="simple">
		<table>
			<tr>	
				<td>
					<s:property value="%{getText('office.name')}"/>
				</td>
				<td>
					<s:property value="office.name"/>
				</td>
			</tr>
			<tr>	
				<td>
					<s:property value="%{getText('office.phoneNumber')}"/>
				</td>
				<td>
					<s:property value="office.phoneNumber"/>
				</td>
			</tr>
			<tr>	
				<td>
					<s:property value="%{getText('office.address')}"/>
				</td>
				<td>
					<%@ include file="../address/DetailAddress.jsp" %>
				</td>
			</tr>
			<tr>	
				<td>
					<s:property value="%{getText('office.contact')}"/>
				</td>
				<td>
					<%@ include file="../contact/DetailContact.jsp" %>
				</td>
			</tr>
			<tr>
				<td colspan="2"  align="center">
					<s:submit action="listOffices" namespace="office" value="List Offices"/>
				</td>
			</tr>
		</table>
	</s:form>
</body>
</html>
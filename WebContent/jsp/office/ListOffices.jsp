<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<title>List all Offices</title>
<link rel="stylesheet" type="text/css" href="../css/main.css"/>
</head>
<body>
	<s:form theme="simple">
		<table>
			<tr >
				<th colspan="4" align="center">
					<s:property value="%{getText('listOffices.heading')}"/>
				</th>
			</tr>
			<tr>
				<th><s:property value="%{getText('office.id')}"/></th>
				<th><s:property value="%{getText('office.name')}"/></th>
				<th><s:property value="%{getText('office.location')}"/></th>
				<th><s:property value="%{getText('label.action')}"/></th>
			</tr>
			<s:iterator value="offices" status="rowstatus">
			<tr>
		    	<td><s:property value="id"/></td>
		    	<td><s:property value="name"/></td>
		    	<td>
		    		<s:property value="address.city"/>, <s:property value="address.state"/>
		    	</td>
		    	<td>
		    		<s:url action="showDetails" id="showDetails">
						<s:param name="office.id" value="id"/>
					</s:url>
					<s:url action="showUpdateOfficeJSP" id="showUpdateOfficeJSP">
						<s:param name="office.id" value="id"/>
					</s:url>
					<s:url action="deleteOffice" id="deleteOffice">
						<s:param name="office.id" value="id"/>
					</s:url>
		    		<s:a href="%{showDetails}"><s:property value="%{getText('label.details')}"/></s:a>
		    		<s:a href="%{showUpdateOfficeJSP}"><s:property value="%{getText('label.update')}"/></s:a>
		    		<s:a href="%{deleteOffice}"><s:property value="%{getText('label.delete')}"/></s:a>
		    	</td>
		  	</tr>
			</s:iterator>
			<tr>
				<td colspan="4" align="center">
					<s:submit action="showAddOfficeJSP" key="label.addOffice"/>
				</td>
			</tr>
			<tr>
				<td colspan="4" align="center">
					<s:url action="homePage" namespace="/home" id="homeLink"/>
					<s:a href="%{homeLink}">Home</s:a>
				</td>
			</tr>
		</table>
	</s:form>
</body>
</html>

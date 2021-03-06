<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<title>List all Magazines</title>
<link rel="stylesheet" type="text/css" href="../css/main.css"/>
</head>
<body>
	<s:form theme="simple">
		<table>
			<tr >
				<th colspan="4">
					<s:property value="%{getText('listMazine.heading')}"/>
				</th>
			</tr>
			<tr>
				<th><s:property value="%{getText('magazine.id')}"/></th>
				<th><s:property value="%{getText('magazine.name')}"/></th>
				<th><s:property value="%{getText('magazine.publishDate')}"/></th>
				<th><s:property value="%{getText('label.action')}"/></th>
			</tr>
			<s:iterator value="magazines" status="rowstatus">
				<tr>
			    	<td><s:property value="id"/></td>
			    	<td><s:property value="name"/></td>
			    	<td>
			    		<s:date name="publishDate" var="formatedPublishDate" format = "MM/dd/yyyy"/>
			    		<s:property value="#formatedPublishDate"/>
			    	</td>
			    	<td>
			    		<s:url action="showDetails" id="showDetails">
							<s:param name="magazine.id" value="id"/>
						</s:url>
						<s:url action="showUpdateMagazineJSP"   id="showUpdateMagazineJSP">
							<s:param name="magazine.id" value="id"/>
						</s:url>
						<s:url action="deleteMagazine" id="deleteMagazine">
							<s:param name="magazine.id" value="id"/>
						</s:url>
			    		<s:a href="%{showDetails}"><s:property value="%{getText('label.details')}"/></s:a>
			    		<s:a href="%{showUpdateMagazineJSP}"><s:property value="%{getText('label.update')}"/></s:a>
			    		<s:a href="%{deleteMagazine}"><s:property value="%{getText('label.delete')}"/></s:a>
			    	</td>
			  	</tr>
			</s:iterator>
			<tr>
				<td colspan="4" align="center">
					<s:submit action="showAddMagazineJSP" key="label.addMagazine"/>
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

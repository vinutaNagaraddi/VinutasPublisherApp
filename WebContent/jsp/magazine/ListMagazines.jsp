<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<title>List all Magazines</title>
<style type="text/css">@import url(css/main.css);</style>
</head>
<body>
	<h3>
		<s:if test="magazines.isEmpty">
			<s:property value="%{getText('listMazine.noMagazine')}"/>
		</s:if>
		<s:else>
			<s:property value="%{getText('listMazine.heading')}"/>
		</s:else>
	</h3>
	<s:form theme="simple">
		<table>
		<s:if test="magazines.size>0">
		<tr>
			<th><s:property value="%{getText('magazine.id')}"/></th>
			<th><s:property value="%{getText('magazine.name')}"/></th>
			<th><s:property value="%{getText('magazine.publishDate')}"/></th>
			<th><s:property value="%{getText('action')}"/></th>
		</tr>
		</s:if>
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
					<s:param name="id" value="id"/>
				</s:url>
				<s:url action="updateMagazine" id="updateMag">
					<s:param name="id" value="id"/>
				</s:url>
				<s:url action="deleteMagazine" id="deleteMag">
					<s:param name="id" value="id"/>
				</s:url>
	    		<s:a href="%{showDetails}"><s:property value="%{getText('details')}"/></s:a>
	    		<s:a href="%{updateMag}"><s:property value="%{getText('update')}"/></s:a>
	    		<s:a href="%{deleteMag}"><s:property value="%{getText('delete')}"/></s:a>
	    	</td>
	  	</tr>
		</s:iterator>
		<tr>
			<td colspan="4" align="center">
				<s:submit action="showAddMagazineJSP" namespace="magazine" value="Add Magazine"/>
			</td>
		</tr>
		</table>
	</s:form>
</body>
</html>

<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<title>Search Magazines</title>
<link rel="stylesheet" type="text/css" href="../css/main.css"/>
</head>
<body>
	<h3><s:property value="%{getText('searchMagazines.heading')}"/></h3>
	<s:fielderror/>
	<s:actionerror/>
	<s:form theme="simple">
		<table>
			<tr>	
				<td>
					<s:property value="%{getText('magazine.name')}"/>
				</td>
				<td>
					<s:textfield key="magazineDTO.magazine.name"/>
				</td>
			</tr>
			<tr>	
				<td>
					<s:property value="%{getText('magazine.price')}"/>
				</td>
				<td>
					<s:select  name="magazineDTO.priceSymbol" list="symbols"/>
					<s:textfield  key="magazineDTO.magazine.price" />
				</td>
			</tr>
			<tr>	
				<td>
					<s:property value="%{getText('magazine.publishDate')}"/>
				</td>
				<td>
					<s:date name="magazine.publishDate" format="MM/dd/yyyy" var="myDateVar"/>
					<s:if test="%{#myDateVar==null}">
						<s:select  name="magazineDTO.publishDateSymbol" list="symbols"/>
						<s:textfield key="magazineDTO.magazine.publishDate"/>
					</s:if>
					<s:else>
						<s:select  name="magazineDTO.publishDateSymbol" list="symbols"/>
						<s:textfield key="magazineDTO.magazine.publishDate" value="%{#myDateVar}"/>
					</s:else>	
				</td>
			</tr>
			<tr>	
				<td>
					<s:property value="%{getText('magazine.avOnline')}"/>
				</td>
				<td>
					<s:select  name="magazineDTO.availableOnlineBooleanValue" list="booleanValues"
						emptyOption="true"/>
				</td>
			</tr>
			<tr>
				<td colspan="2"  align="center">
					<s:submit action="searchMagazines" key="label.search"/>
					<s:submit action="listMagazines" key="label.cancel"/>
				</td>
			</tr>
		</table>
		
		<s:if test="%{magazines != null}">
				<table width="75%">
					<tr>
						<th colspan="4" align="center">
							<s:property value="%{getText('label.searchResults')}"/>
						</th>
					</tr>
					<tr>
						<th><s:property value="%{getText('magazine.name')}"/></th>
						<th><s:property value="%{getText('magazine.price')}"/></th>
						<th><s:property value="%{getText('magazine.publishDate')}"/></th>
						<th><s:property value="%{getText('magazine.avOnline')}"/></th>
					</tr>
					<s:iterator value="magazines" status="rowstatus">
						<tr>
					    	<td><s:property value="name"/></td>
					    	<td><s:property value="price"/></td>
					    	<td>
					    		<s:set name="#formatedPublishDate" value=""/>
								<s:date name="publishDate" var="#formatedPublishDate" format = "MM/dd/yyyy"/>
					    		<s:property value="#formatedPublishDate"/>
					    	</td>
					    	<td>
					    		<s:property value="availableOnline"/>
					    	</td>
					  	</tr>
					</s:iterator>
				</table>
			</s:if>
	</s:form>
</body>
</html>

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
					<s:property value="%{getText('magazine.avOnline')}"/>
				</td>
				<td>
					<s:checkbox key="magazineDTO.magazine.availableOnline"/>
				</td>
			</tr>
			<tr>	
				<td>
					<s:property value="%{getText('magazine.publishDate')}"/>
				</td>
				<td>
					<s:date name="magazine.publishDate" format="MM/dd/yyyy" var="myDateVar"/>
					<s:if test="%{#myDateVar==null}">
						<s:select  name="magazineDTO.priceSymbol" list="symbols"/>
						<s:textfield key="magazineDTO.magazine.publishDate"/>
					</s:if>
					<s:else>
						<s:select  name="magazineDTO.priceSymbol" list="symbols"/>
						<s:textfield key="magazineDTO.magazine.publishDate" value="%{#myDateVar}"/>
					</s:else>	
				</td>
			</tr>
			<tr>	
				<td>
					<s:property value="%{getText('label.author')}"/>
				</td>
				<td>
					<table>
						<tr>	
							<td>
								<s:property value="%{getText('author.lastName')}"/>
							</td>
							<td>
								<s:textfield key="%{'magazineDTO.magazine.articles[0].authors[0].lastName'}"/>
							</td>
						</tr>
						<tr>	
							<td>
								<s:property value="%{getText('author.firstName')}"/>
							</td>
							<td>
								<s:textfield key="%{'magazineDTO.magazine.articles[0].authors[0].firstName'}"/>
							</td>
						</tr>
					</table>	
				</td>
			</tr>
			<tr>
				<td colspan="2"  align="center">
					<s:submit action="searchMagazines" namespace="magazine" key="label.search"/>
					<s:submit action="listMagazines" namespace="magazine" key="label.cancel"/>
				</td>
			</tr>
		</table>
	</s:form>
</body>
</html>

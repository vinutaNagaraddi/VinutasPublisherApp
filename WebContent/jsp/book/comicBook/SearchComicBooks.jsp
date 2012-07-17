<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<title>Search Novels</title>
<link rel="stylesheet" type="text/css" href="../css/main.css"/>
</head>
<body>
	<h3><s:property value="%{getText('searchComicBook.heading')}"/></h3>
	<s:actionerror/>
	<s:fielderror/>
	<s:form theme="simple">
		<table>
			<tr>	
				<td>
					<s:property value="%{getText('comicBook.name')}"/>
				</td>
				<td>
					<s:textfield key="comicBookDTO.comicBook.name"/>
				</td>
			</tr>
			<tr>	
				<td>
					<s:property value="%{getText('comicBook.price')}"/>
				</td>
				<td>
					<s:select  name="novelDTO.priceSymbol" list="symbols"/>
					<s:textfield  key="comicBookDTO.comicBook.price" />
				</td>
			</tr>
			<tr>	
				<td>
					<s:property value="%{getText('comicBook.publishDate')}"/>
				</td>
				<td>
					<s:date name="comicBook.publishDate" format="MM/dd/yyyy" var="myDateVar"/>
					<s:if test="%{#myDateVar==null}">
						<s:select  name="novelDTO.priceSymbol" list="symbols"/>
						<s:textfield key="comicBookDTO.comicBook.publishDate"/>
					</s:if>
					<s:else>
						<s:select  name="novelDTO.priceSymbol" list="symbols"/>
						<s:textfield key="comicBookDTO.comicBook.publishDate" value="%{#myDateVar}"/>
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
								<s:textfield key="%{'comicBookDTO.comicBook.authors[0].lastName'}"/>
							</td>
						</tr>
						<tr>	
							<td>
								<s:property value="%{getText('author.firstName')}"/>
							</td>
							<td>
								<s:textfield key="%{'comicBookDTO.comicBook.authors[0].firstName'}"/>
							</td>
						</tr>
					</table>	
				</td>
			</tr>
			<tr>
				<td colspan="2"  align="center">
					<s:submit action="searchComicBooks" namespace="book" key="label.search"/>
					<s:submit action="listBooks" namespace="book" key="label.cancel"/>
				</td>
			</tr>
		</table>
	</s:form>
</body>
</html>
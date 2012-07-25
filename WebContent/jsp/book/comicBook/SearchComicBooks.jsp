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
					<s:select  name="comicBookDTO.priceSymbol" list="symbols"/>
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
						<s:select  name="comicBookDTO.publishDateSymbol" list="symbols"/>
						<s:textfield key="comicBookDTO.comicBook.publishDate"/>
					</s:if>
					<s:else>
						<s:select  name="comicBookDTO.publishDateSymbol" list="symbols"/>
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
					<s:submit action="searchComicBooks" key="label.search"/>
					<s:submit action="listBooks" key="label.cancel"/>
				</td>
			</tr>
			<s:if test="%{comicBooks != null}">
				<tr>
					<td colspan="2">
						<table width="100%">
							<tr>
								<th><s:property value="%{getText('comicBook.name')}"/></th>
								<th><s:property value="%{getText('comicBook.publishDate')}"/></th>
								<th><s:property value="%{getText('comicBook.price')}"/></th>
								<th><s:property value="%{getText('comicBook.fileName')}"/></th>
							</tr>
							<s:iterator value="comicBooks" status="rowstatus">
								<tr>
							    	<td><s:property value="name"/></td>
							    	<td>
							    		<s:set name="#formatedNovelPublishDate" value=""/>
										<s:date name="publishDate" var="#formatedNovelPublishDate" format = "MM/dd/yyyy"/>
							    		<s:property value="#formatedNovelPublishDate"/>
							    	</td>
							    	<td><s:property value="price"/></td>
							    	<td><s:property value="attachmentFileName"/></td>
							  	</tr>
							</s:iterator>
						</table>
					</td>
				</tr>
			</s:if>
		</table>
	</s:form>
</body>
</html>

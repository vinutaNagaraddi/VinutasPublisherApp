<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<title>Search Novels</title>
<link rel="stylesheet" type="text/css" href="../css/main.css"/>
</head>
<body>
	<h3><s:property value="%{getText('searchNovel.heading')}"/></h3>
	<s:actionerror/>
	<s:fielderror/>
	<s:form theme="simple">
		<table>
			<tr>	
				<td>
					<s:property value="%{getText('novel.name')}"/>
				</td>
				<td>
					<s:textfield key="novelDTO.novel.name"/>
				</td>
			</tr>
			<tr>	
				<td>
					<s:property value="%{getText('novel.isbn')}"/>
				</td>
				<td>
					<s:textfield key="novelDTO.novel.isbn"/>
				</td>
			</tr>
			<tr>	
				<td>
					<s:property value="%{getText('novel.price')}"/>
				</td>
				<td>
					<s:select  name="novelDTO.priceSymbol" list="symbols"/>
					<s:textfield  key="novelDTO.novel.price" />
				</td>
			</tr>
			<tr>	
				<td>
					<s:property value="%{getText('novel.publishDate')}"/>
				</td>
				<td>
					<s:date name="novelDTO.novel.publishDate" format="MM/dd/yyyy" var="myDateVar"/>
					<s:if test="%{#myDateVar==null}">
						<s:select  name="novelDTO.publishDateSymbol" list="symbols"/>
						<s:textfield key="novelDTO.novel.publishDate"/>
					</s:if>
					<s:else>
						<s:select  name="novelDTO.publishDateSymbol" list="symbols"/>
						<s:textfield key="novelDTO.novel.publishDate" value="%{#myDateVar}"/>
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
								<s:textfield key="%{'novelDTO.novel.authors[0].lastName'}"/>
							</td>
						</tr>
						<tr>	
							<td>
								<s:property value="%{getText('author.firstName')}"/>
							</td>
							<td>
								<s:textfield key="%{'novelDTO.novel.authors[0].firstName'}"/>
							</td>
						</tr>
					</table>	
				</td>
			</tr>
			<tr>
				<td colspan="2"  align="center">
					<s:submit action="searchNovels" key="label.search"/>
					<s:submit action="listBooks" key="label.cancel"/>
				</td>
			</tr>
			<s:if test="%{novels != null}">
				<tr>
					<td colspan="2">
						<table width="100%">
							<tr>
								<th><s:property value="%{getText('novel.name')}"/></th>
								<th><s:property value="%{getText('novel.isbn')}"/></th>
								<th><s:property value="%{getText('novel.publishDate')}"/></th>
								<th><s:property value="%{getText('novel.price')}"/></th>
							</tr>
							<s:iterator value="novels" status="rowstatus">
								<tr>
							    	<td><s:property value="name"/></td>
							    	<td><s:property value="isbn"/></td>
							    	<td>
							    		<s:set name="#formatedNovelPublishDate" value=""/>
										<s:date name="publishDate" var="#formatedNovelPublishDate" format = "MM/dd/yyyy"/>
							    		<s:property value="#formatedNovelPublishDate"/>
							    	</td>
							    	<td><s:property value="price"/></td>
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

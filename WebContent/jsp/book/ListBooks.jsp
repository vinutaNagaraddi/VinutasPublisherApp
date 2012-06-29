<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<title>List all Books</title>
<style type="text/css">@import url(css/main.css);</style>
</head>
<body>
	<s:form theme="simple">
		<table>
			<tr >
				<th colspan="4" align="center">
					<s:property value="%{getText('listBooks.heading')}"/>
				</th>
			</tr>
			<tr>
				<th><s:property value="%{getText('book.book_type')}"/></th>
				<th><s:property value="%{getText('comicBook.name')}"/></th>
				<th><s:property value="%{getText('comicBook.publishDate')}"/></th>
				<th><s:property value="%{getText('label.action')}"/></th>
			</tr>
			<s:iterator value="comicBooks" status="rowstatus">
			<tr>
		    	<td>Comic Book</td>
		    	<td><s:property value="name"/></td>
		    	<td>
		    		<s:date name="publishDate" var="formatedPublishDate" format = "MM/dd/yyyy"/>
		    		<s:property value="#formatedPublishDate"/>
		    	</td>
		    	<td>
		    		<s:url action="showComicBookDetails" id="showComicBookDetails">
						<s:param name="comicBook.id" value="id"/>
					</s:url>
					<s:url action="showUpdateComicBookJSP" id="showUpdateComicBookJSP">
						<s:param name="comicBook.id" value="id"/>
					</s:url>
					<s:url action="deleteComicBook" id="deleteComicBook">
						<s:param name="comicBook.id" value="id"/>
					</s:url>
		    		<s:a href="%{showComicBookDetails}"><s:property value="%{getText('label.details')}"/></s:a>
		    		<s:a href="%{showUpdateComicBookJSP}"><s:property value="%{getText('label.update')}"/></s:a>
		    		<s:a href="%{deleteComicBook}"><s:property value="%{getText('label.delete')}"/></s:a>
		    	</td>
		  	</tr>
			</s:iterator>
			<s:iterator value="novels" status="rowstatus">
			<tr>
		    	<td>Novel</td>
		    	<td><s:property value="name"/></td>
		    	<td>
		    		<s:date name="publishDate" var="formatedPublishDate" format = "MM/dd/yyyy"/>
		    		<s:property value="#formatedPublishDate"/>
		    	</td>
		    	<td>
		    		<s:url action="showNovelDetails" id="showNovelDetails">
						<s:param name="novel.id" value="id"/>
					</s:url>
					<s:url action="showUpdateNovelJSP" id="showUpdateNovelJSP">
						<s:param name="novel.id" value="id"/>
					</s:url>
					<s:url action="deleteNovel" id="deleteNovel">
						<s:param name="novel.id" value="id"/>
					</s:url>
		    		<s:a href="%{showNovelDetails}"><s:property value="%{getText('label.details')}"/></s:a>
		    		<s:a href="%{showUpdateNovelJSP}"><s:property value="%{getText('label.update')}"/></s:a>
		    		<s:a href="%{deleteNovel}"><s:property value="%{getText('label.delete')}"/></s:a>
		    	</td>
		  	</tr>
			</s:iterator>
			<tr>
				<td colspan="4" align="center">
					<s:submit action="showAddNovelJSP" namespace="book" value="Add Novel"/>
					<s:submit action="showAddComicBookJSP" namespace="book" value="Add Comic Book"/>
				</td>
			</tr>
		</table>
	</s:form>
</body>
</html>

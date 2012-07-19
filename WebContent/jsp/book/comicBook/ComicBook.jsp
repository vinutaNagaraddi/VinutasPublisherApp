<%@ taglib prefix="s" uri="/struts-tags" %>
	<tr>	
		<td class="requiredField">
			<s:property value="%{getText('comicBook.name')}"/>
		</td>
		<td>
			<s:textfield key="comicBook.name"/>
		</td>
	</tr>
	<tr>	
		<td>
			<s:property value="%{getText('comicBook.price')}"/>
		</td>
		<td>
			<s:textfield  key="comicBook.price" />
		</td>
	</tr>
	<tr>	
		<td>
			<s:property value="%{getText('comicBook.publishDate')}"/>
		</td>
		<td>
			<s:date name="comicBook.publishDate" format="MM/dd/yyyy" var="myDateVar"/>
			<s:if test="%{#myDateVar==null}">
				<s:textfield key="comicBook.publishDate"/>
			</s:if>
			<s:else>
				<s:textfield key="comicBook.publishDate" value="%{#myDateVar}"/>
			</s:else>	
		</td>
	</tr>
	<tr>	
		<td>
			<s:property value="%{getText('comicBook.noOfPages')}"/>
		</td>
		<td>
			<s:textfield  key="comicBook.noOfPages" />
		</td>
	</tr>
	<s:if test="%{comicBook.id != null}">
		<tr>
			<td>
				<s:property value="%{getText('comicBook.coverImage')}"/>
			</td>
			<td>
				<s:url action="getImage?comicBook.id=%{comicBook.id}" id="url"/>
				<img src="<s:property value='#url'/>" width="100" height="100"/>
			</td>
		</tr>
		<tr>
			<td>
				<s:property value="%{getText('comicBook.fileName')}"/>
			</td>
			<td>
				<s:property value="comicBook.attachmentFileName"/>
			</td>
		</tr>
		<tr>
			<td>
				<s:property value="%{getText('comicBook.coverImage')}"/>
			</td>
			<td>
				<s:file name="comicBook.updatedAttachment"/>
			</td>
		</tr>
	</s:if>
	<s:else>
		<tr>
			<td>
				<s:property value="%{getText('comicBook.coverImage')}"/>
			</td>
			<td>
				<s:file name="comicBook.attachment"/>
			</td>
		</tr>
	</s:else>
	<s:iterator value='new int[@main.java.com.vinuta.action.BookAction@NO_OF_AUTHORS]' 
				status="authorStat"> 
		<tr>	
			<td>
				<s:property value="%{getText('label.author')}"/>
				<s:property value="%{#authorStat.count}"/>
			</td>
			<td>
				<%@ include file="../../author/AuthorForComicBook.jsp" %>
			</td>
		</tr>
	</s:iterator>
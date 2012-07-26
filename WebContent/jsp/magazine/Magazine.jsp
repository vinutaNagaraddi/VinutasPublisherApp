<%@ taglib prefix="s" uri="/struts-tags" %>			
			
	<tr>	
		<td class="requiredField">
			<s:property value="%{getText('magazine.name')}"/>
		</td>
		<td>
			<s:textfield key="magazine.name"/>
		</td>
	</tr>
	<tr>	
		<td>
			<s:property value="%{getText('magazine.price')}"/>
		</td>
		<td>
			<s:textfield  key="magazine.price" />
		</td>
	</tr>
	<tr>	
		<td class="requiredField">
			<s:property value="%{getText('magazine.publishDate')}"/>
		</td>
		<td>
			<s:date name="magazine.publishDate" format="MM/dd/yyyy" var="myDateVar"/>
			<s:if test="%{#myDateVar==null}">
				<s:textfield key="magazine.publishDate"/>
			</s:if>
			<s:else>
				<s:textfield key="magazine.publishDate" value="%{#myDateVar}"/>
			</s:else>	
		</td>
	</tr>
	<tr>	
		<td>
			<s:property value="%{getText('magazine.avOnline')}"/>
		</td>
		<td>
			<s:checkbox key="magazine.availableOnline"/>
		</td>
	</tr>
	<s:iterator value='new int[@main.java.com.vinuta.action.MagazineAction@NO_OF_ARTICLES]' 
				status="articleStat"> 
		<tr>	
			<td>
				<s:property value="%{getText('label.article')}"/>
				<s:property value="%{#articleStat.count}"/>
			</td>
			<td>
				<%@ include file="../article/Article.jsp" %>
			</td>
		</tr>
	</s:iterator>
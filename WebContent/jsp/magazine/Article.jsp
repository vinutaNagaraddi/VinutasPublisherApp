<%@ taglib prefix="s" uri="/struts-tags" %>

	<table>
		<tr>	
			<s:if test="#articleStat.index==0">
				<td class="requiredField">
					<s:property value="%{getText('article.title')}"/>
				</td>
			</s:if>
			<s:else>
				<td>
					<s:property value="%{getText('article.title')}"/>
				</td>
			</s:else>
			<td>
				<s:textfield key="%{'magazine.articles['+#articleStat.index+'].title'}"/>
			</td>
		</tr>
		<tr>	
			<td>
				<s:property value="%{getText('article.noOfPages')}"/>
			</td>
			<td>
				<s:textfield key="%{'magazine.articles['+#articleStat.index+'].noOfPages'}"/>
			</td>
		</tr>
		<s:iterator value="new int[@main.java.com.vinuta.action.MagazineAction@NO_OF_AUTHORS]" 
				status="authorStat"> 
			<tr>	
				<td>
					<s:property value="%{getText('author')}"/>
					<s:property value="%{#authorStat.count}"/>
				</td>
				<td>
					<%@ include file="../author/Author.jsp" %>
				</td>
			</tr>
		</s:iterator>
	</table>

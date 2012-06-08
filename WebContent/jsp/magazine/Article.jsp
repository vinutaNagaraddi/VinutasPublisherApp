<%@ taglib prefix="s" uri="/struts-tags" %>

	<table>
		<tr>	
			<td>
				<s:property value="%{getText('article.title')}"/>
			</td>
			<td>
				<s:textfield name="%{'magazine.articles['+#articleStat.index+'].title'}"/>
			</td>
		</tr>
		<tr>	
			<td>
				<s:property value="%{getText('article.noOfPages')}"/>
			</td>
			<td>
				<s:textfield name="%{'magazine.articles['+#articleStat.index+'].noOfPages'}"/>
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
					<%@ include file="Author.jsp" %>
				</td>
			</tr>
		</s:iterator>
	</table>

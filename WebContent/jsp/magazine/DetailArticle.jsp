<%@ taglib prefix="s" uri="/struts-tags" %>
	<table>
		<tr>	
			<td>
				<s:property value="%{getText('article.title')}"/>
			</td>
			<td>
				<s:property value="magazine.articles[#articleStat.index].title"/>
			</td>
		</tr>
		<tr>	
			<td>
				<s:property value="%{getText('article.noOfPages')}"/>
			</td>
			<td>
				<s:property value="magazine.articles[#articleStat.index].noOfPages"/>
			</td>
		</tr>
		<s:iterator value="magazine.articles[#articleStat.index].authors" status="authorStat"> 
			<tr>	
				<td>
					<s:property value="%{getText('label.author')}"/>
					<s:property value="%{#authorStat.count}"/>
				</td>
				<td>
					<%@ include file="../author/DetailAuthor.jsp" %>
				</td>
			</tr>
		</s:iterator>
	</table>

<%@ taglib prefix="s" uri="/struts-tags" %>

	<table>
		<tr>	
			<td>
				<s:property value="%{getText('author.lastName')}"/>
			</td>
			<td>
				<s:textfield name="%{'magazine.articles['+#articleStat.index+'].authors['+#authorStat.index+'].lastName'}"/>
			</td>
		</tr>
		<tr>	
			<td>
				<s:property value="%{getText('author.firstName')}"/>
			</td>
			<td>
				<s:textfield name="%{'magazine.articles['+#articleStat.index+'].authors['+#authorStat.index+'].firstName'}"/>
			</td>
		</tr>
	</table>

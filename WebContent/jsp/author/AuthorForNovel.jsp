<%@ taglib prefix="s" uri="/struts-tags" %>

	<table>
		<tr>	
			<s:if test="#authorStat.index==0">
				<td class="requiredField">
					<s:property value="%{getText('author.lastName')}"/>
				</td>
			</s:if>
			<s:else>
				<td>
					<s:property value="%{getText('author.lastName')}"/>
				</td>
			</s:else>
			<td>
				<s:textfield key="%{'novel.authors['+#authorStat.index+'].lastName'}"/>
			</td>
		</tr>
		<tr>	
			<s:if test="#authorStat.index==0">
				<td class="requiredField">
					<s:property value="%{getText('author.firstName')}"/>
				</td>
			</s:if>
			<s:else>
				<td>
					<s:property value="%{getText('author.firstName')}"/>
				</td>
			</s:else>
			<td>
				<s:textfield key="%{'novel.authors['+#authorStat.index+'].firstName'}"/>
			</td>
		</tr>
	</table>

<%@ taglib prefix="s" uri="/struts-tags" %>

	<table class="fullWidth">
		<tr>	
			<s:if test="#articleStat.index==0  && #authorStat.index==0">
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
				<s:textfield key="%{'magazine.articles['+#articleStat.index+'].authors['+#authorStat.index+'].lastName'}"/>
			</td>
		</tr>
		<tr>	
			<s:if test="#articleStat.index==0  && #authorStat.index==0">
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
				<s:textfield key="%{'magazine.articles['+#articleStat.index+'].authors['+#authorStat.index+'].firstName'}"/>
			</td>
		</tr>
	</table>

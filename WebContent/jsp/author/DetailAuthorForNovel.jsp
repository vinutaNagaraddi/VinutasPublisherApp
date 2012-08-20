<%@ taglib prefix="s" uri="/struts-tags" %>

	<table class="fullWidth">
		<tr>	
			<td>
				<s:property value="%{getText('author.lastName')}"/>
			</td>
			<td>
				<s:property value="novel.authors[#authorStat.index].lastName"/>
			</td>
		</tr>
		<tr>	
			<td>
				<s:property value="%{getText('author.firstName')}"/>
			</td>
			<td>
				<s:property value="novel.authors[#authorStat.index].firstName"/>
			</td>
		</tr>
	</table>

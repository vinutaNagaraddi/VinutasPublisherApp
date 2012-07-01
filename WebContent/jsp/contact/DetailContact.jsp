<%@ taglib prefix="s" uri="/struts-tags" %>
	<table>
		<tr>	
			<td>
				<s:property value="%{getText('contact.firstName')}"/>
			</td>
			<td>
				<s:property value="office.contact.firstName"/>
			</td>
		</tr>
		<tr>	
			<td>
				<s:property value="%{getText('contact.lastName')}"/>
			</td>
			<td>
				<s:property value="office.contact.lastName"/>
			</td>
		</tr>
		<tr>	
			<td>
				<s:property value="%{getText('contact.phoneNumber')}"/>
			</td>
			<td>
				<s:property value="office.contact.phoneNumber"/>
			</td>
		</tr>
		<tr>	
			<td>
				<s:property value="%{getText('contact.emailAddress')}"/>
			</td>
			<td>
				<s:property value="office.contact.emailAddress"/>
			</td>
		</tr>
</table>
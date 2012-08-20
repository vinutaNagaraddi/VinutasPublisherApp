<%@ taglib prefix="s" uri="/struts-tags" %>

	<table class="fullWidth">
		<tr>	
			<td>
				<s:property value="%{getText('contact.firstName')}"/>
			</td>
			<td>
				<s:textfield key="office.contact.firstName"/>
			</td>
		</tr>
		<tr>	
			<td>
				<s:property value="%{getText('contact.lastName')}"/>
			</td>
			<td>
				<s:textfield key="office.contact.lastName"/>
			</td>
		</tr>
		<tr>	
			<td>
				<s:property value="%{getText('contact.phoneNumber')}"/>
			</td>
			<td>
				<s:textfield key="office.contact.phoneNumber"/>
			</td>
		</tr>
		<tr>	
			<td>
				<s:property value="%{getText('contact.emailAddress')}"/>
			</td>
			<td>
				<s:textfield key="office.contact.emailAddress"/>
			</td>
		</tr>
	</table>
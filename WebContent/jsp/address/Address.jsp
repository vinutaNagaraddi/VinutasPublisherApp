<%@ taglib prefix="s" uri="/struts-tags" %>

	<table>
		<tr>	
			<td class="requiredField">
				<s:property value="%{getText('address.address1')}"/>
			</td>
			<td>
				<s:textfield key="office.address.address1"/>
			</td>
		</tr>
		<tr>	
			<td>
				<s:property value="%{getText('address.address2')}"/>
			</td>
			<td>
				<s:textfield key="office.address.address2"/>
			</td>
		</tr>
		<tr>	
			<td>
				<s:property value="%{getText('address.city')}"/>
			</td>
			<td>
				<s:textfield key="office.address.city"/>
			</td>
		</tr>
		<tr>	
			<td>
				<s:property value="%{getText('address.state')}"/>
			</td>
			<td>
				<s:textfield key="office.address.state"/>
			</td>
		</tr>
		<tr>	
			<td>
				<s:property value="%{getText('address.zipCode')}"/>
			</td>
			<td>
				<s:textfield key="office.address.zipCode"/>
			</td>
		</tr>
	</table>
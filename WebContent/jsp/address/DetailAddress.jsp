<%@ taglib prefix="s" uri="/struts-tags" %>

	<table class="fullWidth">
		<tr>	
			<td>
				<s:property value="%{getText('address.address1')}"/>
			</td>
			<td>
				<s:property value="office.address.address1"/>
			</td>
		</tr>
		<tr>	
			<td>
				<s:property value="%{getText('address.address2')}"/>
			</td>
			<td>
				<s:property value="office.address.address2"/>
			</td>
		</tr>
		<tr>	
			<td>
				<s:property value="%{getText('address.city')}"/>
			</td>
			<td>
				<s:property value="office.address.city"/>
			</td>
		</tr>
		<tr>	
			<td>
				<s:property value="%{getText('address.state')}"/>
			</td>
			<td>
				<s:property value="office.address.state"/>
			</td>
		</tr>
		<tr>	
			<td>
				<s:property value="%{getText('address.zipCode')}"/>
			</td>
			<td>
				<s:property value="office.address.zipCode"/>
			</td>
		</tr>
	</table>
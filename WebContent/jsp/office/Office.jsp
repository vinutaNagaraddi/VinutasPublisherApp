<%@ taglib prefix="s" uri="/struts-tags" %>
	<tr>	
		<td class="requiredField">
			<s:property value="%{getText('office.name')}"/>
		</td>
		<td>
			<s:textfield key="office.name"/>
		</td>
	</tr>
	<tr>	
		<td>
			<s:property value="%{getText('office.phoneNumber')}"/>
		</td>
		<td>
			<s:textfield key="office.phoneNumber"/>
		</td>
	</tr>
	<tr>	
		<td>
			<s:property value="%{getText('office.address')}"/>
		</td>
		<td>
			<%@ include file="../address/Address.jsp" %>
		</td>
	</tr>
	<tr>	
		<td>
			<s:property value="%{getText('office.contact')}"/>
		</td>
		<td>
			<%@ include file="../contact/Contact.jsp" %>
		</td>
	</tr>
	
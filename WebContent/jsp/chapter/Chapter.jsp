<%@ taglib prefix="s" uri="/struts-tags" %>
	<s:hidden name="%{'novel.chapters['+#chapterStat.index+'].id'}" /> 
    <s:hidden name="%{'novel.chapters['+#chapterStat.index+'].version'}"/> 
	<table class="fullWidth">
		<tr>	
			<s:if test="#chapterStat.index==0">
				<td class="requiredField">
					<s:property value="%{getText('chapter.title')}"/>
				</td>
			</s:if>
			<s:else>
				<td>
					<s:property value="%{getText('chapter.title')}"/>
				</td>
			</s:else>
			<td>
				<s:textfield key="%{'novel.chapters['+#chapterStat.index+'].title'}"/>
			</td>
		</tr>
		<tr>	
			<td>
				<s:property value="%{getText('chapter.noOfPages')}"/>
			</td>
			<td>
				<s:textfield key="%{'novel.chapters['+#chapterStat.index+'].noOfPages'}"/>
			</td>
		</tr>
	</table>

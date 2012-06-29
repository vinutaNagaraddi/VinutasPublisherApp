<%@ taglib prefix="s" uri="/struts-tags" %>
	<table>
		<tr>	
			<td>
				<s:property value="%{getText('chapter.title')}"/>
			</td>
			<td>
				<s:property value="novel.chapters[#chapterStat.index].title"/>
			</td>
		</tr>
		<tr>	
			<td>
				<s:property value="%{getText('chapter.noOfPages')}"/>
			</td>
			<td>
				<s:property value="novel.chapters[#chapterStat.index].noOfPages"/>
			</td>
		</tr>
	</table>

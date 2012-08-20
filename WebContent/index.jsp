<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<title>Vinuta's Publisher App</title>
<link rel="stylesheet" type="text/css" href="../css/main.css"/>
</head>
<body>
	<h3><s:property value="%{getText('label.homePage')}"/></h3>
	<s:form theme="simple">
		<table id="homeTable" >
			<tr >
				<td>
					<s:property value="%{getText('magazine')}"/>
					<s:url action="listMagazines" namespace="/magazine" id="listMagazines"/>
					<p> <img src="<s:url value='/image/magazine.jpg'/>" width="100" height="100" border="0"/>
					<s:a href="%{listMagazines}">
						<br><s:property value="%{getText('label.crud')}"/>
					</s:a>
					<s:url action="showSearchMagazineJSP" namespace="/magazine" id="showSearchMagazineJSP"/>
					<s:a href="%{showSearchMagazineJSP}"><p><s:property value="%{getText('label.search')}"/></s:a>
				</td>
				<td>
					<s:property value="%{getText('novel')}"/>
					<s:url action="listNovels" namespace="/novel" id="listNovels"/>
					<p> <img src="<s:url value='/image/novel.jpg'/>" width="100" height="100" border="0"/>
					<s:a href="%{listNovels}">
						<br><s:property value="%{getText('label.crud')}"/>
					</s:a>
					<s:url action="showSearchNovelJSP" namespace="/novel" id="showSearchNovelJSP"/>
					<s:a href="%{showSearchNovelJSP}"><p><s:property value="%{getText('label.search')}"/></s:a>
				</td>
				<td>
					<s:property value="%{getText('comicBook')}"/>
					<s:url action="listComicBooks" namespace="/comicBook" id="listComicBooks"/>
					<p> <img src="<s:url value='/image/comicBook.jpg'/>" width="100" height="100" border="0"/>
					<s:a href="%{listComicBooks}">
						<br><s:property value="%{getText('label.crud')}"/>
					</s:a>
					<s:url action="showSearchComicBooksJSP" namespace="/comicBook" id="showSearchComicBooksJSP"/>
					<s:a href="%{showSearchComicBooksJSP}"><p><s:property value="%{getText('label.search')}"/></s:a>
				</td>
				<td >
					<s:property value="%{getText('office')}"/>
					<s:url action="listOffices" namespace="/office" id="listOffices"/>
					<p> <img src="<s:url value='/image/office.jpg'/>" width="100" height="100" border="0"/>
					<s:a href="%{listOffices}">
						<br><s:property value="%{getText('label.crud')}"/>
					</s:a>
				</td>
			</tr>
		</table>
	</s:form>
</body>
</html>
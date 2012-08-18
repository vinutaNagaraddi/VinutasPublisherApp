<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<title>Vinuta's Publisher App</title>
<link rel="stylesheet" type="text/css" href="../css/main.css"/>
</head>
<body>
	<h3>Welcome to Vinuta's Publisher Application!</h3>
	<s:form theme="simple">
		<table width="65%" height="50%">
			<tr>
				<td><s:url action="listMagazines" namespace="/magazine" id="listMagazines"/>
					<s:a href="%{listMagazines}">
						Manage Magazines <br> (Create, Update, Delete)
					</s:a>
				</td>
				<td><s:url action="listBooks" namespace="/book" id="listBooks"/>
					<s:a href="%{listBooks}">
						Manage Books <br> (Create, Update, Delete)
					</s:a>
				</td>
				<td><s:url action="listOffices" namespace="/office" id="listOffices"/>
					<s:a href="%{listOffices}">
						Manage Office Locations <br> (Create, Update, Delete)
					</s:a>
				</td>
			</tr>
			<tr>
				<td><s:url action="showSearchMagazineJSP" namespace="/magazine" id="showSearchMagazineJSP"/>
					<s:a href="%{showSearchMagazineJSP}">Search all Magazines</s:a></td>
				<td><s:url action="showSearchComicBooksJSP" namespace="/book" id="showSearchComicBooksJSP"/>
						<s:a href="%{showSearchComicBooksJSP}">Search all Comic Books</s:a>
				</td>
				<td><s:url action="showSearchNovelJSP" namespace="/book" id="showSearchNovelJSP"/>
					<s:a href="%{showSearchNovelJSP}">Search all Novels</s:a>
				</td>
			</tr>	
		</table>
	</s:form>
</body>
</html>
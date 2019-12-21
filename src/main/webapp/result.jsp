<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>RFC search</title>
</head>
<body>
<p><a href="index.html">Back to search</a></p>
<br>
<h2>Searching results</h2>
<p> Text for search:<b><%= request.getParameter("text") %></b></p>
<p>Ok </p>
<p> Lines match count: ${counter} </p>
<p><b>Files:</b> ${files}</p>
<br>
<a href="download" download>Download results</a>
<br><br>
<a href="download">Watch results</a>
</body>
</html>

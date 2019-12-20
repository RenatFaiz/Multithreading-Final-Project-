<%@page import="ru.itpark.service.FileVisitor" %>
<%@ page import="java.nio.file.Files" %>
<%@ page import="java.nio.file.Path" %>
<%@ page import="java.nio.file.Paths" %>
<%@ page import="java.io.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>RFC search</title>
</head>
<body>
<h2>Searching results</h2>
<p> Text for search: <%= request.getParameter("text") %>
</p>
<%--<p> Text: ${results[0]} </p>--%>

<p>Ok </p>
<p> Line match counts: ${counter} </p>
<br>
<a href="/download" download>Download results from servlet</a>
<br>
<a href="/download">Watch results from servlet</a>

</body>
</html>


<%--    String textForSearch = request.getParameter("text");--%>
<%--    out.println(textForSearch);--%>
<%--    visitor.setSearchString(textForSearch);--%>
<%--<p> Buffered: <%= request.getReader().lines() %>--%>
<%--    PrintWriter writer = response.getWriter();--%>
<%--    writer.println(Files.walkFileTree(path, visitor));--%>
<%--    out.println(path);--%>



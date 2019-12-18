<%@page import="ru.itpark.service.FileVisitor" %>
<%@ page import="java.nio.file.Files" %>
<%@ page import="java.nio.file.Path" %>
<%@ page import="java.nio.file.Paths" %>
<%@ page import="java.io.*" %>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
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
<%--<p> Buffered: <%= request.getReader().lines() %>--%>
<%--</p> --%>
<p>Ok </p>
<%--<p> Text: ${results[0]} </p>--%>
<%--<p> Number of matches: ${counter} </p>--%>
<%--<p><% final FileVisitor visitor = new FileVisitor();--%>
<%--    Path path = Paths.get("D:\\Coding\\Destination");--%>
<%--    Path path1 = Paths.get("Destination/").toAbsolutePath();--%>
<%--    String textForSearch = request.getParameter("text");--%>
<%--    out.println(textForSearch);--%>
<%--    visitor.setSearchString(textForSearch);--%>

<%--    PrintWriter writer = response.getWriter();--%>
<%--    writer.println(Files.walkFileTree(path, visitor));--%>
<%--    out.println(path);--%>
<%--    out.println(path1);--%>
<%--%>--%>

</body>
</html>

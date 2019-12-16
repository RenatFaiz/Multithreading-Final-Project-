<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<% String header = "Users list";
    String[] people = new String[]{"Tom", "Bob", "Sam"};
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>First JSP App</title>
</head>
<body>
<h2><%= header %>
</h2>
<ul>
    <% for (String person : people) {
      out.println("<li>" + person + "</li>");
    }
    %>
</ul>
<p> 2 + 3 = <%= 2 + 2 %>
</p>
<p>Today <%= new java.util.Date() %>
</p>
</body>
</html>

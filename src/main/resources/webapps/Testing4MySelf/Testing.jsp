<%@page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<head>
    <title>TestingJSP</title>
</head>
<body>
<h1>Testing JSP</h1>
<p>
    <%
        for (int i = 0; i < 5; i++) {
            out.println("<p>" + "hello : " + i + "</p>");
        }
    %>
</p>
</body>
</html>
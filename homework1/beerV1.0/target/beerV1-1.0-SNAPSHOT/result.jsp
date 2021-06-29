<%--
  Created by IntelliJ IDEA.
  User: zhongpu
  Date: 3/3/21
  Time: 10:42 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*" %>
<%@ page import="com.swufe.javaee.beerV1.model.Beer" %>
<html>
<head>
    <title>String Recommended JSP</title>
</head>
<body>
<%
    List<String> styles = (List<String>) request.getAttribute("styles");
    out.println("<br/>this is a jsp page");
    for (Object brand: styles) {
        out.println("<br/>try: " + ((Beer)brand).toString());
    }
%>

</body>
</html>

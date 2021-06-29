<%@ page import="javax.imageio.ImageIO" %>
<%@ page import="java.awt.image.BufferedImage" %>
<%@ page import="java.io.ByteArrayOutputStream" %>
<%@ page import="java.util.Base64" %><%--
  Created by IntelliJ IDEA.
  User: 24508
  Date: 2021/4/4
  Time: 17:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Your Avatar</title>
</head>
<body>
<img src="data:image/png;base64,${imageAsBase64}" />
<%
  Hello;
%>
</body>
</html>

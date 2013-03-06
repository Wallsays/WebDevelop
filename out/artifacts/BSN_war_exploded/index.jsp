<%--
  Created by IntelliJ IDEA.
  User: Dis
  Date: 25.12.12
  Time: 23:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<form action="/Login " method=post>
    Login <INPUT TYPE=TEXT NAME=login
                 SIZE=20><BR>
    Password <INPUT TYPE=password
                    NAME=pass SIZE=20
        ><BR>
    <P><INPUT TYPE=SUBMIT value="Enter">
</FORM>
<form ACTION="reg.jsp" method=post>
   <P><INPUT TYPE=SUBMIT value="Registration">
</FORM>
</body>
</html>
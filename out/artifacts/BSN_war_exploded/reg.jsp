<%--
  Created by IntelliJ IDEA.
  User: Dis
  Date: 26.12.12
  Time: 0:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<form action="/Registration " method=post>
    Login <INPUT TYPE=TEXT NAME=login
                 SIZE=20><BR>
    Password <INPUT TYPE=password
                    NAME=pass1 SIZE=20
        ><BR>
    <%--re-type <INPUT TYPE=password--%>
                   <%--NAME=pass2 SIZE=20--%>
        <%--><BR>--%>
    Name <INPUT TYPE=TEXT NAME=name
                SIZE=20><BR>
    Age <INPUT TYPE=TEXT NAME=age
               SIZE=20><BR>

    <P><INPUT TYPE=SUBMIT value="Зарегистрироватья">
</FORM>
</body>
</html>
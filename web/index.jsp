<%@ page import="Sample.HelloWorld" %>
<%--
  Created by IntelliJ IDEA.
  User: Dis
  Date: 22.12.12
  Time: 22:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <link rel="stylesheet" type="text/css" href="styles.css"/>
</head>
<body>
<h3 class="message"><%=HelloWorld.getMessage()%>
</h3>

<FORM METHOD=POST ACTION=j_security_check>
    <%--Login <INPUT TYPE=TEXT NAME=j_username--%>
                 <%--SIZE=20><BR>--%>
    <%--Pass <INPUT TYPE=PASSWORD  NAME=j_password SIZE=20><BR>--%>
    <%--<INPUT TYPE=SUBMIT>--%>
    <%--pageContext.forward( "GetName.html" );--%>
 <jsp:forward page="GetName.html"></jsp:forward>
</body>
</html>
<%--
  Created by IntelliJ IDEA.
  User: Dis
  Date: 26.12.12
  Time: 1:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form action="index.jsp " method=post>
    <INPUT TYPE=SUBMIT value="Logout">
</form>

<form action="/Send " method=post>
    <INput type=text name="sender" value=<%= request.getParameter( "uId" ) %>>
    Whom <INPUT TYPE=TEXT NAME=uId
                SIZE=20><BR>
    IM <textarea TYPE=text rows="5" cols="20"
                 NAME=text
        ></textarea><BR>

    <P><INPUT TYPE=SUBMIT value="Send">
</FORM>

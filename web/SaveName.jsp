<jsp:useBean id="user" class="user.UserData" scope="session"/>
<jsp:setProperty name="user" property="*"/>
<%
    String tgtPage = null;
    if ( user.getUsername() == ( null ))
        tgtPage = "index.jsp";
    else if ( user.getEmail()==( null ))
        tgtPage = "index.jsp";
    else
        tgtPage = "NextPage.jsp";
    response.sendRedirect( tgtPage );
%>
<%@page pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="ru">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>Junior Java Developer</title>
    <link href="style.css" rel="stylesheet" type="text/css"/>
</head>

<body>


<div class="container">
    <jsp:include page="header.jsp"/>
    <jsp:include page="leftSide.jsp"/>
    <div class="content">
        <% String content = request.getParameter("nav");
            if (content == null) {
                pageContext.include("main.jsp");
            } else if (content.equals("career")) {
                pageContext.include("career.jsp");
            } else if (content.equals("activity")) {
                pageContext.include("activity.jsp");
            } else if (content.equals("req")) {
                pageContext.include("requirements.jsp");
            } else if (content.equals("job")) {
                pageContext.include("job.jsp");
            } else if (content.equals("main")) {
                pageContext.include("main.jsp");
            } else {
                out.print(content);
            }
        %>

        <!-- end .content --></div>
    <jsp:include page="footer.jsp"/>
    <!-- end .container --></div>
</body>
</html>
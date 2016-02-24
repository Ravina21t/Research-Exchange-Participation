
<!DOCTYPE html>
<html>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"   %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="CSS/style.css" rel="stylesheet" type="text/css" />
    </head>

    <header>            
        <span class="align_left_green">
            <a href="UserController?action=home"> Researchers Exchange Participation</a>
        </span>

        <span class ="align_right">
            <a href="UserController?action=about">About Us</a>&nbsp;
            <a href="UserController?action=how">How it works</a>&nbsp;
             
            <c:if test="${not empty theUser.name}">
                Hello,${theUser.name}
            </c:if>
            <c:if test="${empty theUser}">
                <a href="login.jsp">Login</a>&nbsp;
            </c:if>
        </span>
    </header>


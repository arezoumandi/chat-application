<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<META http-equiv="Content-Type" content="text/html; charset=UTF-8">


<html lang="fa">
<head>
    <title>Home Page</title>
    <link href="<c:url value="/resources/my.css" />" rel="stylesheet"/>
</head>
<body>
<div id="container">
    <div id="header">
        <div id="navigation">
            <a href="/signup" >ثبت نام </a>
        </div>
    </div>
    <div id="content">
        <div class="form">
            <div id="signUp">
                <h1><spring:message code="form.login.subject"/> </h1>
                <form:form action="/login" method="post" commandName="signupForm" ><br/>
                    <div id="feilds">
                        <spring:message code="form.login.label.username" /> <input type="text" name="username" value=""/> <form:errors path="username" /><br/>
                        <spring:message code="form.login.label.password" /> <input type="password" name="password" value=""/> <form:errors path="password" /><br />
                        <input type="submit" name="register"  class="button button-block" value=" <spring:message code="form.login.button.login" />"/>
                    </div>
                </form:form>
            </div>
        </div>
</div>

<div id="footer">

</div>
</div>
</body>
</html>

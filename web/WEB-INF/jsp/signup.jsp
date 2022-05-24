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
            <a href="/login">ورود</a>
        </div>
    </div>
    <div id="content">

        <div class="form">

            <div id="signUp">
                <h1><spring:message code="form.signup.h1"></spring:message> </h1>
                <form:form action="/signup" method="post" commandName="signupForm"><br/>
                    <div id="feilds">
                       <label></label> <spring:message code="form.signup.label.name"/></label><input type="text" name="name" value=""/>
                        <fom:errors path="name"/><br/>
                        <label><spring:message code="form.signup.label.username"/></label> <input type="text" name="username" value=""/> ${msg}<form:errors path="username"/><br/>
                        <spring:message code="form.signup.label.password"/> <input type="password" name="password" value=""/> <form:errors path="password"/><br/>
                        <spring:message code="form.signup.label.confirmPassword"/> <input type="password" name="confirmPassword" value=""/> <br/>${notMatch}<form:errors
                            path="confirmPassword"/><br/>
                        <spring:message code="form.signup.label.email"/> <input type="text" name="email" value=""/> <form:errors path="email"/><br/>
                        <spring:message code="form.signup.label.sex"/><input type="text" name="sex" value=""/><form:errors path="sex"/><br/>
                        <input type="submit" name="register" class="button button-block" value="<spring:message code="form.signup.button.register"/> " />
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

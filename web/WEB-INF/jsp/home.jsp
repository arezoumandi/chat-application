<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<META http-equiv="Content-Type" content="text/html; charset=UTF-8">

<html>
<head>
    <title>Home Page</title>
    <link href="<c:url value="/resources/chat.css" />" rel="stylesheet"/>
    <script type="text/javascript">

        var ws = new WebSocket("ws://localhost:8080/home");
        var userList=new Array();
        var index=0;


        ws.onmessage = function (message) {
            //console.log("Received: ");
            var reciveMessage = message.data;
            var tokens = reciveMessage.split(":");
            if(tokens[0]==="REG")
            {
                userList[index]=tokens[1];
                index++;
               // localStorage["userList"]=JSON.stringify("userList")
                updateUser();

            }
           if (tokens[0]==="MRC" && tokens[2] !== "") {
                document.getElementById("display").innerHTML += "<span class='message'><span class='bubble'>" + tokens[2] + "</span> <span class='username'>" + tokens[1] + " : </span>" + "</span>";
            }

        }


        function firstSendRequest() {
            ws.send("REG:" + document.getElementById("myUsername").value);
            document.getElementById("display").disabled = false;
            document.getElementById("myMessage").disabled = false;
            document.getElementById("sendButton").disabled = false;

        }
        function sendMessage() {
            ws.send("MBC:" + document.getElementById("myMessage").value);
            document.getElementById("myMessage").value = "";
        }

        function updateUser() {
            document.getElementById("authenticate").innerHTML="";
           // var st=JSON.parse(localStorage["userList"]);
            var s=userList.length;
            var i;
            //var text;
            for(i=0;i<index;i++)
            {
                document.getElementById("authenticate").innerHTML+= "<li>" + userList[i] + "</li>";
             }

        }


    </script>
</head>
<body>

<div id="container">
    <div id="header">
        <div id="navigation">
        </div>
    </div>
    <div id="content">
        <div id="chatBox">
            <input id="myUsername" type="hidden" value="${u.username}">
            <button onclick="firstSendRequest()"> شروع </button>
            <div id="show">
                <div id="display" disabled="true"></div>
                </br>
                <div id="authenticate"></div>
            </div>
            <div id="sendMessage">
                <input id="myMessage" type="text" class="center" placeholder="پیام" disabled="true">
                <button id="sendButton" class="center" onclick="sendMessage()" disabled="true"> ارسال</button>
            </div>
        </div>
    </div>

    <div id="footer">

    </div>
</div>
</body>
</html>
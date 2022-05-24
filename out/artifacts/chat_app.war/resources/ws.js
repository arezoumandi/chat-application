
function weGotMessage(message) {
    document.getElementById("myDiv").innerHTML += "<h1>" + message.data + "</h1>";
    }
var ws = new WebSocket("ws://localhost:8080/chat_app/home");
ws.onmessage = weGotMessage;
function sendRequest() {
    ws.send("John");
    }

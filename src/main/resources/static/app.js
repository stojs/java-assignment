var host = "http://localhost:8080"
var i = 0;
var stompClient = null;

function getMessages() {
    i = 0;
    $.get(host + "/app/get", function (data) {
        data.forEach(getMessage);
    });
}

function getMessage(testEntry, prepend) {
    i++;
    var dateNow = new Date(testEntry.timestamp);
    var divBlock = "<tr> <td>" + i + "</td> <td style='width: 30%;'>"
            + dateNow.format("yyyy-mm-dd HH:MM:ss o") + "</td> <td style='width: 35%;'>"
            + testEntry.content + "</td><td>"
            + testEntry.size + " </td> </tr> ";
    if (prepend !== "prepend") {
        $('#tabl').append(divBlock);
    } else {
        $('#tabl').prepend(divBlock);
    }
}

function setConnected(connected) {
    document.getElementById('connect').disabled = connected;
    document.getElementById('disconnect').disabled = !connected;
    document.getElementById('response').innerHTML = '';
}

function connect() {
    stompClient = Stomp.client('ws://localhost:8080/add');
    stompClient.debug = null;
    stompClient.connect({}, function (frame) {
        var obj = null;
        var date = null;
        setConnected(true);
        console.log('Connected: ' + frame);
        stompClient.subscribe('/topic/messages', function (message) {
            obj = JSON.parse(message.body);
            date = new Date(obj.timestamp);
            showMessage(date.format("yyyy-mm-dd HH:MM:ss o") + " " + obj.content);
        });
    });
}

function disconnect() {
    if (stompClient != null) {
        stompClient.disconnect();
    }
    setConnected(false);
    console.log("Disconnected");
}

function showMessage(message) {
    var response = document.getElementById('response');
    var p = document.createElement('p');
    p.style.wordWrap = 'break-word';
    p.appendChild(document.createTextNode(message));
    response.appendChild(p);
}

function saveContent() {
    var test = {
        timestamp: $.now(),
        content: $("#content").val()
    }
    $.ajax({
        url: '/app/add',
        type: 'post',
        dataType: 'json',
        contentType: 'application/json',
        data: JSON.stringify(test),
        success: function () {
            alert("Only alphabetic characters are allowed! ");
        }
    });
    if (stompClient != null && test["content"].match("^[ A-Za-z]+$")) {
        stompClient.send("/app/add", {}, JSON.stringify(test));
    }

}

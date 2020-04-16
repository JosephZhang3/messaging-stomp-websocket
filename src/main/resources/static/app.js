var stompClient = null;

function setConnected(connected) {
    $("#connect").prop("disabled", connected);
    $("#disconnect").prop("disabled", !connected);
    if (connected) {
        $("#conversation").show();
    }
    else {
        $("#conversation").hide();
    }
    $("#greetings").html("");
}

function connect() {
    var socket = new SockJS('localhost:9090/ma');//构造器参数为websocket服务器url
    stompClient = Stomp.over(socket);
    stompClient.connect(
        {},
        function connectCallBack(frame) {
            //连接
            setConnected(true);
            console.log('connect websocket success : ' + frame);

            //订阅
            stompClient.subscribe('/topic/redCount/f8fc7e3330564f83b854a1c15b8bce1c', function (notify) {
                showNotify(JSON.parse(notify.body));
            });
            console.log('subscribe red count success : ');

            //初始化拉取一次消息
            stompClient.send("/queryRedCount/f8fc7e3330564f83b854a1c15b8bce1c",[],'');
            console.log('init red count success : ');
        },
        function errorCallBack() {
            connect();
        }
    );
}

function disconnect() {
    if (stompClient !== null) {
        stompClient.disconnect();
    }
    setConnected(false);
    console.log("Disconnected");
}

function sendName() {
    stompClient.send("/app/hello", {}, JSON.stringify({'name': $("#name").val()}));
}

function showGreeting(message) {
    $("#greetings").append("<tr><td>" + message + "</td></tr>");
}

//展示消息内容
function showNotify(message) {
    console.log("Received push msg: "+message);
    $("#notifySomeThing").append("<tr><td>" + message + "</td></tr>");
}

$(function () {
    $("form").on('submit', function (e) {
        e.preventDefault();
    });
    $( "#connect" ).click(function() { connect(); });
    $( "#disconnect" ).click(function() { disconnect(); });
    $( "#send" ).click(function() { sendName(); });
});
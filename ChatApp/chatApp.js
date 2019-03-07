function ajaxGetRequest(path, callback){
    var request = new XMLHttpRequest();
    request.onreadystatechange = function(){
        if(this.readyState === 4 && this.status === 200){
            callback(this.response);
        }
    };
    request.open("GET", path);
    request.send();
}

function ajaxPostRequest(path, data, callback){
    var request = new XMLHttpRequest();
    request.onreadystatechange = function(){
        if(this.readyState === 4 && this.status === 200){
            callback(this.response);
        }
    };
    request.open("POST", path);
    request.send(data);
}

function renderChat(response){
    // var chat = "";
    // for(var data of JSON.parse(response)){
    //     chat = chat + data.message + "</br>";
    // }
    chat = JSON.parse(response);
    document.getElementById("chatHistory").innerHTML = chat;
}

function loadChat(){
    //var info = getUser();
    var sendFrom = "testuser1";
    var sendTo = "testuser2";

    var historyInfo = JSON.stringify({"chatFrom": sendFrom, "chatTo": sendTo})
    
    //historyInfo = JSON.stringify({"dd":"22"})
    ajaxPostRequest("/chat", historyInfo , renderChat);
}

function sendMessage(){
    var messageElement = document.getElementById("inputArea");
    var info = getUser();
    var sendFrom = info[0];
    var sendTo = info[1];

    var message = messageElement.value;
    messageElement.value = "";
    document.getElementById("chatHistory").scrollTop = document.getElementById("chatHistory").scrollHeight;
    var toSend = JSON.stringify({"chatFrom": sendFrom, "chatTo": sendTo, "message": message});

    ajaxPostRequest("/send", toSend, renderChat);
}

function getUser(){
    var sendFrom = document.getElementById("searchInput").value;
    var sendTo;

    if(sendFrom == "testuser1"){
        sendTo = "testuser2";
    }
    else{
        sendTo = "testuser1";
    }

    return [sendFrom,sendTo]
}

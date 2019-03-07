import bottle
import json
import chatControl

@bottle.route('/')
def index():
    print("index")
    return bottle.static_file("GUI.html", root = "")

@bottle.route('/chatApp.js')
def static():
    return bottle.static_file("chatApp.js", root = "")

@bottle.post('/chat')
def get_chat():
    print("chat")
    content = bottle.request.body.read().decode()
    content = json.loads(content)
    chatFrom = content['chatFrom']
    chatTo = content['chatTo']
    print(chatFrom)
    print(chatTo)
    chatMap = chatControl.get_chat(chatFrom, chatTo)
    chatHistory = chatControl.gen_history(chatMap, chatFrom, 100)
    print(json.dumps(chatHistory))
    return json.dumps(chatHistory)

@bottle.post('/send')
def do_chat():
    print("send")
    content = bottle.request.body.read().decode()
    content = json.loads(content)
    chatFrom = content['chatFrom']
    chatTo = content['chatTo']
    chatMessage = content['message']
    chatControl.add_message(chatFrom, chatTo, chatMessage)
    chatMap = chatControl.get_chat(chatFrom, chatTo)
    chatHisotry = chatControl.gen_history(chatMap, chatFrom, 100)
    return json.dumps(chatHisotry)


bottle.run(host = "0.0.0.0", port = 8080, debug = True)
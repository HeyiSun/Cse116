import bottle
import json
import chat

@bottle.route('/')
def index():
    return bottle.static_file("index.html",root="")

@bottle.route('/chat.js')
def static():
    return bottle.static_file("chat.js", root="")

@bottle.route('/chat')
def get_chat():
    return json.dumps(chat.get_chat())

@bottle.post('/send')
def do_chat():
    content = bottle.request.body.read().decode()
    content = json.loads(content)
    chat.add_message(content['message'])
    
    return json.dumps(chat.get_chat())

bottle.run(host = "0.0.0.0", port = 8080, debug=True)
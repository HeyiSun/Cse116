def add_message(chatFrom, chatTo, message):
	filename = chat_file(chatFrom, chatTo)
	with open(filename, "a+") as file:
	    file.write("&&&@@@&&&" + "\n")
	    file.write(chatFrom + "\n")
	    file.write(message + "\n")

def get_chat(chatFrom, chatTo):
	filename = chat_file(chatFrom, chatTo)
	fullChat = []
	with open(filename, "r+") as file:
		for line in file:
			if line.rstrip("\n\r") == "&&&@@@&&&" :
				username = file.readline()
				fullChat.append({"username": username.rstrip("\n\r")})
			else:
				fullChat.append({"message": line.rstrip("\n\r")})
		
	return fullChat

def chat_file(chatFrom, chatTo):
	if(chatFrom <= chatTo):
		return "../ChatHistory/" + chatFrom + "@" + chatTo + ".txt"
	else:
	    return "../ChatHistory/" + chatTo + "@" + chatFrom + ".txt"


def gen_history(fullChat, chatFrom, nCharPerLine):
	length = (nCharPerLine - 1) // 2
	isUser = 2
	history = ""

	for record in fullChat:
		key = ""
		value = ""
		for (k, v) in record.items():
			key = k
			value = v
		if(key == "username"):
			if value == chatFrom and isUser != 1:
				history += "\n"
				isUser = 1
				history += value + ":\n"
			if value != chatFrom and isUser != 0:
				history += "\n"
				isUser = 0
				history += value + ":\n"
		elif(key == "message"):
			history += value + "\n"
		else:
			print("ERROR: gen_history() Found unexcepted key for fullChat")

	return history
	


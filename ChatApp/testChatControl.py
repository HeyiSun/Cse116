import unittest
import chatControl


class testChatControl(unittest.TestCase):

	def test_chat_file(self):
		self.assertEqual(chatControl.chat_file("testuser1", "testuser2"), "../ChatHistory/testuser1@testuser2.txt")

	def test_get_and_add_chat(self):
		user1 = "testuser1"
		user2 = "testuser2"
		chatControl.add_message(user1, user2, "Hi Heyi")
		self.assertEqual(chatControl.get_chat(user1, user2)[0]["username"], "testuser1")
		self.assertEqual(chatControl.get_chat(user1, user2)[1]["message"], "Hi Heyi")
		with open("../ChatHistory/" + user1 + "@" + user2 + ".txt", "w") as f:
			print()

	def test_gem_history(self):
		chatMap = [
			{"username": "testuser2"},
			{"message": "1"},
			{"username": "testuser2"},
			{"message": "2"},
			{"username": "testuser1"},
			{"message": "3"},
			{"username": "testuser1"},
			{"message": "4"},
			{"username": "testuser1"},
			{"message": "5"},
			{"username": "testuser2"},
			{"message": "6"},
			{"username": "testuser2"},
			{"message": "7"},
			{"username": "testuser2"},
			{"message": "8"},
			{"username": "testuser1"},
			{"message": "9"},
			{"username": "testuser2"},
			{"message": "10"},
			{"username": "testuser1"},
			{"message": "11"},
			{"username": "testuser2"},
			{"message": "12"},
			{"username": "testuser1"},
			{"message": "13"},
			{"username": "testuser2"},
			{"message": "14"}
		]

		self.assertEqual(chatControl.gen_history(chatMap, "testuser1", 100), \
		"\ntestuser2:\n1\n2\n\ntestuser1:\n3\n4\n5\n\ntestuser2:\n6\n7\n8\n\ntestuser1:\n9\n\ntestuser2:\n10\n\ntestuser1:\n11\n\ntestuser2:\n12\n\ntestuser1:\n13\n\ntestuser2:\n14\n")

		#print(chatControl.gen_history(chatMap, "testuser1", 100))


if __name__ == "__main__":
    unittest.main()

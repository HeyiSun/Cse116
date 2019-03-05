package chatApp
import java.io.FileWriter

import scala.io._

class chat (var chatFrom: user, var chatTo: user){

  var chatHistoryFilename = "../ChatHistory/" + chatFrom.name + "@" + chatTo.name + ".txt"


  def chatHistory(): String = {
    Source.fromFile(chatHistoryFilename).mkString
  }

  def addChat(curUser:user, newWord:String):Unit = {
    if(curUser.name != chatFrom.name && curUser.name != chatTo.name){
      println("ERROR: user and chat don't much")
    }else{
      val writer = new FileWriter(chatHistoryFilename, true)
      writer.write(newWord + "\n")
      writer.close()
    }
  }

  def partHistory(): String ={
    ""
  }


}

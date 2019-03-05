package chatUI
import javafx.event.ActionEvent
import scalafx.Includes._
import scalafx.application
import scalafx.application.JFXApp
import scalafx.scene.Scene
import scalafx.scene.control.{Button, TextArea, TextField}
import scalafx.scene.paint.Color._
import scalafx.scene.shape.Rectangle
import chatApp._
import scalafx.animation.AnimationTimer


object chatUI extends JFXApp {

  val curUser = new user("testUser1")
  val curChat = curUser.chatWith(new user("testUser2"))


  val inputDisplay: TextArea = new TextArea {
    style = "-fx-font: 18 ariel;"
    prefWidth = 680
    prefHeight = 210
    layoutX = 300
    layoutY = 500
    wrapText = true
    //width = 700
    //height = 300
  }

  val sendButton: Button = new Button {
    text = "Send"
    style = "-fx-font: 12 ariel;"
    minWidth = 65
    minHeight = 1
    maxHeight = 24
    layoutX = 905
    layoutY = 720

    onAction = (event: ActionEvent) => {
      curChat.addChat(curUser, inputDisplay.text.value)
      inputDisplay.text.value = ""
    };
  }


  val searchUser: TextField = new TextField{
    layoutX = 20
    layoutY = 15
  }

  val searchButton: Button = new Button {
    layoutX = 220
    layoutY = 18
    minHeight = 1
    maxHeight = 25
    minWidth = 65
    text = "Search"
    style = "-fx-font: 12 ariel;"
  }

  val chatSelect = new Rectangle {
    x = 0
    y = 0
    width = 300
    height = 800
    fill <== when(hover) choose LightGrey otherwise WhiteSmoke
  }

  val historyDisplay = new TextArea(""){
    style = "-fx-font: 22 ariel"
    layoutX = 300
    layoutY = 0
    prefWidth = 680
    prefHeight = 500
    editable = false
    wrapText = true
  }

  stage = new application.JFXApp.PrimaryStage{
    title.value = "Chat App"
    width = 1000
    height = 800

    scene = new Scene{
      fill = White
      content = List(chatSelect, inputDisplay,sendButton, historyDisplay, searchUser, searchButton)

    }
    AnimationTimer(update).start()
  }

  def update(time: Long): Unit ={

      historyDisplay.text.value = curChat.chatHistory()

  }

}

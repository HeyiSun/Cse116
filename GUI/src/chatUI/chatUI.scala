package chatUI
import javafx.event.ActionEvent

import scalafx.Includes._
import scalafx.application
import scalafx.application.JFXApp
import scalafx.scene.Scene
import scalafx.scene.control.{Button, TextArea, TextField}
import scalafx.scene.paint.Color._
import scalafx.scene.shape.{Rectangle}
import scalafx.scene.text._
import chatApp._


object chatUI extends JFXApp {

  val curUser = new user("testUser")



  val sendButton: Button = new Button {
    text = "Send"
    style = "-fx-font: 12 ariel;"
    minWidth = 65
    minHeight = 1
    maxHeight = 24
    layoutX = 905
    layoutY = 720

    //onAction = (event: ActionEvent) => sendMessage();
  }

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

  val historyDisplay = new TextArea("Heyi, I love you!!! Don't leave me!!! Please!!! I want to born a child for you!!!"){
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
  }

}

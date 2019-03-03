package chatApp

class chat (var chatFrom: user, var chatTo: user){
  var chatHistoryFilename = chatFrom.name + "@" + chatTo.name

  def partHistory(): String ={
    ""
  }
}

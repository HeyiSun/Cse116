package chatApp

class user (var name: String){

  def chatWith(usr:user):chat = {
    if(usr.name < this.name){
      new chat(usr, this)
    }else {
      new chat(this, usr)
    }
  }


}

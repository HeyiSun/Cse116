package chatApp
import java.io.FileWriter

import scala.io._

object test {
  def main(args:Array[String])={
    val filename:String = "../ChatHistory/testUser1@testUser2.txt"
    var content = Source.fromFile(filename).mkString
    print(content)

    val writer: FileWriter = new FileWriter(filename, true)
    writer.write("2222")
    writer.close()
    content = Source.fromFile(filename).mkString
    print(content)


  }

}

package org.chat

import java.io._

import com.neovisionaries.ws.client._


object SocketModule{

  import com.neovisionaries.ws.client._

   
  //Replace with Server IP
  val uri =  "ws://10.100.27.60:9000/chat"
  val echo = println("***"+uri)

  //Replace with server IP
  val SERVER: String = "ws://10.100.27.60:9000/chat"
  val TIMEOUT: Int = 2000
  
  var output:String= ""
  var text:String = ""
  
  def connect(): WebSocket =
    new WebSocketFactory()
      .setConnectionTimeout(TIMEOUT)
      .createSocket(SERVER)
      .addListener(new WebSocketAdapter() {
        //Text Message arrived from the server
        override def onTextMessage(websocket: WebSocket, message:String): Unit = {
          //output= message
          println(s"Output: $message")  
        }
      })
      .addExtension(WebSocketExtension.PERMESSAGE_DEFLATE)
      //.connect()
  
      val names = Vector("Bob", "Fred", "Joe", "Julia", "Kim")
      var msg = ""
      
  def main(args: Array[String]): Unit = {
      val ws: WebSocket = connect().connectAsynchronously()
      ws.setPingInterval(1 * 1000)
      while(msg!="exit"){
        println("Enter Message: ")
        msg= scala.io.StdIn.readLine()
        ws.sendText(msg)
      }
      ws.disconnect()
   }     
}